/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.io.*
import java.util.*

class KoKoCall (protected var head: KoKoAst, protected var args: KoKoList = KoKoList()) : KoKoAst {
//head: id -> xxx

    override fun genCode(out: PrintStream) {
        this.head.genCode(out)
        out.print("(")
        this.args.genCode(out)
        out.print(")")
    }
   fun lambdaCall(expr: KoKoAst, ctx: KoKoContext,args: KoKoList): KoKoValue{
       if(expr is KoKoLambda){ //si viene anidada entra aquí  \x.\y
           val id = expr.pattern as KoKoId
           val ctxLambda = ctx.push() // crea un nuevo contexto con la nueva lambda anidada
           val l = args.f as KoKoList
           val result = l.f.eval(ctx)
           ctxLambda.assoc(id, result)
           val kbo = expr.expr
           return lambdaCall(kbo,ctxLambda,KoKoList(args.subList(1,args.size)))
       }
       else{
           //sino solo la evalua con el nuevo contexto
           return expr.eval(ctx)
       }

    }

    private fun patternCall(expr: KoKoAst, ctx: KoKoContext, args:KoKoList): KoKoValue{  //cuando hay lambdas anidadas con pattern matching
       if(expr is KoKoLambda){
            val id = expr.pattern
            val ex = expr.expr
            val l = args.f as KoKoList
            val result = l.f.eval(ctx) as KoKoListValue
            when{
                id is KoKoList_pat -> { //pregunta si el parametro de la lambda es [x|r]
                    return pat(id,ex,args,ctx,result)
                }
                else -> {
                     return expr.eval(ctx)
                }
            }
       }
       else
           return expr.eval(ctx)
    
    }

    private fun pat(expr: KoKoList_pat,value: KoKoAst,args: KoKoList,ctx: KoKoContext,result: KoKoListValue): KoKoValue{
            val ctxPattern = ctx.push()
            //crea el contexto
            val expre = expr.expr as KoKoListBodyPat

            when{
                expre.pat is KoKoList_pat ->{ //cuando viene pat anidado  [[x|r]|c], caso Hsing Wei
                    val ex = expre.pat as KoKoList_pat
                    ctxPattern.assoc(expre.rest as KoKoId, result[result.size - 1])
                    val r = KoKoListValue(result.subList(0,result.size - 1))
                    return pat(ex,value,args,ctxPattern,r);
                }
                expre.rest is KoKoList_pat ->{   //rest es de listbodypat, [x|[r|s]], si funciona prolog
                    val ex = expre.rest as KoKoList_pat
                    ctxPattern.assoc(expre.pat as KoKoId, result[0]) //a x le asocia el primero de la lista
                    val r = KoKoListValue(result.subList(1,result.size)) // al result le quita el primero 
                    return pat(ex,value,args,ctxPattern,r);
                }
                else ->{
                    val rest = KoKoListValue(result.subList(1,result.size)) //[x|r]
                    ctxPattern.assoc(expre.rest as KoKoId, rest) //a r le asigna el resto de la lista
                    ctxPattern.assoc(expre.pat as KoKoId, result[0])//a x le asigna el primero
                    return patternCall(value,ctxPattern,this.args)
                }
            }
    }

    private fun lambda(value: KoKoLambdaValue<*>, ctx: KoKoContext,args: KoKoList):KoKoValue{ //le entra la lambda, el contexto, y los args
        //el parametro de la lambda
        val id = value.pattern 
        //x*x
        val expr = value.expr as KoKoAst
        when{
            id is KoKoList_pat -> {
                //id [x|r]
                val l = args.f as KoKoList
                //l guarda la list que paso por argumentos
                val result = l.f.eval(ctx) as KoKoListValue
                //result evalua y devuelve la lista
                return pat(id,expr,this.args,ctx,result)
            }
            id is KoKoNum -> {
                val i = KoKoId("X")
                val x = KoKoLambda(i,KoKoTernExpr(KoKoEQUALS(KoKoId("=="),i,id),expr,KoKoBool(false)),null)
                val ctxPat = ctx.push()
                ctxPat.assoc(x.pattern as KoKoId,id.eval(ctxPat))
                return lambdaCall(x,ctxPat,args)
            }
            else -> {
                //crea un nuevo contexto
                val ctxLambda = ctx.push()
                //trae el primer argumento de la lista
                val l = args.f as KoKoList
                //obtiene el parametro
                val result = l.f.eval(ctx)
                //al pattern le asocio el parametro
                ctxLambda.assoc(id as KoKoId, result)
                //le extrae la expresión a la lambda y lo parsea como lambda
                val kbo = value.expr
                //retorna un lambda call yla vuelve a llamar sin el primer argumento
                return lambdaCall(kbo,ctxLambda,KoKoList(args.subList(1,args.size)))
            }
        }
    }
    
    private fun transpilar(expr: KoKoLambdaValue<*>, ctx: KoKoContext): KoKoValue{
        val id = expr.pattern 
        val exprr = expr.expr as KoKoAst
        when{
            id is KoKoNum -> {
                val num = Math.random()
                val i = KoKoId("case$num")
                            val xx = KoKoId("XX$num")
                            val n = KoKoId("N$num")
                            val li = KoKoList()
                            li.add(xx)
                            val list = KoKoList()
                            list.add(li)
                            val y = KoKoLambda(xx,KoKoLambda(n
                                ,KoKoTernExpr(KoKoEQUALS(KoKoId("=="),xx,id),exprr
                                ,KoKoCall(n,list)),null),null)
                 ctx.assoc(i,y.eval(ctx))               
                 return KoKoAtomValue(i)               
            }
            else -> {
                val num = Math.random()
                val i = KoKoId("case$num")
                ctx.assoc(i,expr)
                return KoKoAtomValue(i)
            }
        }
    }
    private fun anidar(list : KoKoListValue,args: KoKoList): KoKoLambda{
        if(list.size == 1 ){
            return KoKoLambda(KoKoId("YYY"),KoKoCall(KoKoId(((list[0] as KoKoAtomValue<*>)
                .value as KoKoId).value),args),null)
        }
        else{
            val li = KoKoList()
            li.add(anidar(KoKoListValue(list.subList(1,list.size)),args))
            args.add(li)
            return KoKoLambda(KoKoId("YYY"),KoKoCall(KoKoId(((list[0] as KoKoAtomValue<*>)
                .value as KoKoId).value),args),null)
        }
    }
    private fun whenExpr(exprs: KoKoListValue, ctx:KoKoContext): KoKoValue {
        when {
            exprs.size == 0 -> return KoKoListValue()
            exprs.size == 1 -> {
                val list = exprs.map{ e -> lambda(e as KoKoLambdaValue<*>,ctx,this.args) }
                return (list[0])
            }
            else -> {
                val list = exprs.map{ e -> transpilar(e as KoKoLambdaValue<*>,ctx) }
                val l = KoKoList()       
                l.add(anidar(KoKoListValue(list.subList(1,list.size)),this.args))
                this.args.add(l)
                val result = ctx.find(KoKoId(((list[0] as KoKoAtomValue<*>).value as KoKoId).value)) as KoKoLambdaValue<*>
                return lambda(result,ctx,this.args)
            } 
        }  
    }

    override fun eval(ctx: KoKoContext): KoKoValue {       
        val `val` = ctx.find(this.head as KoKoId) //le devuelve la lambda buscandola por el id
        when{
            `val` is KoKoLambdaValue<*> -> {  //cuando es una lambda
                return lambda(`val`,ctx,this.args);
            }
            else ->{
              val kbo = `val` as KoKoListValue              
              //return lambda(kbo[0] as KoKoLambdaValue<*>,ctx,this.args)
                return whenExpr(kbo,ctx)
            }  
        }
    }

}
