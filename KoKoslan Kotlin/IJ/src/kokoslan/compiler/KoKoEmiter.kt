/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.compile

import kokoslan.ast.*
import java.util.*

interface KoKoEmiter {

    fun PROGRAM(stmts: List<KoKoAst>): KoKoProgram {
        return KoKoProgram(stmts)
    }

    fun LET(id: KoKoAst, expr: KoKoAst): KoKoAst {
        return KoKoLet(id, expr)
    }


    fun OPERATOR(operator: String): KoKoAst {
        return KoKoId(operator)
    }

    fun OPERATION(operator: KoKoAst, operands: MutableList<KoKoAst>): KoKoAst {
        return KoKoOperation(operator, operands)
    }

    fun BI_OPERATION(operator: KoKoAst, left: KoKoAst, right: KoKoAst): KoKoAst {
        val id = operator as KoKoId
        when (id.value) {
            "+" -> return KoKoPLUS(operator, left, right)
            "-" -> return KoKoMINUS(operator, left, right)
            "*" -> return KoKoMULT(operator, left, right) //new
            ">" -> return KoKoGREATER(operator, left, right) //new
            "<" -> return KoKoLESS(operator, left, right) //new
            "==" -> return KoKoEQUALS(operator, left, right) //new
            "!=" -> return KoKoNOT_EQUALS(operator, left, right) //new
            "<=" -> return KoKoLEQ(operator, left, right) //new
            ">=" -> return KoKoGEQ(operator, left, right) //new
            "&&" -> {
                BI_OPERATION_BOOL(operator, left, right) //new
                BI_OPERATION_BOOL(operator, left, right) //new
                return KoKoBiOperation(operator, left, right)
            }
            "||" -> {
                BI_OPERATION_BOOL(operator, left, right)
                return KoKoBiOperation(operator, left, right)
            }
            else -> return KoKoBiOperation(operator, left, right)
        }

    }

    fun BI_OPERATION_BOOL(operator: KoKoAst, left: KoKoAst, right: KoKoAst): KoKoAst {
        val id = operator as KoKoId
        when (id.value) {
            "&&" -> return KoKoAND(operator, left, right) //new
            "||" -> return KoKoOR(operator, left, right) //new
            else -> return KoKoBiOperation(operator, left, right)
        }

    }

    fun PRIMITIVE_OPERATION(operation: KoKoAst, expression: KoKoAst):KoKoAst{
        val id = operation as KoKoId
        when (id.value) {
            "length" -> return KoKoLength(expression) //new
            "first" -> return KoKoFirst(expression) //new
            "rest" -> return KoKoRest(expression) //new
             "print" -> return KoKoPrint(expression)
             else -> throw Exception()
        }
    }
    

    fun NUM(value: Double): KoKoNum {
        return KoKoNum(value)
    }

    fun ID(value: String): KoKoId {
        return KoKoId(value)
    }


    fun LIST(expressions: List<KoKoAst>): KoKoList {
        return KoKoList(expressions)
    }

    fun LIST(): KoKoList {
        return KoKoList()
    }

    fun CALL(head: KoKoAst, args: KoKoList): KoKoAst {
        return KoKoCall(head, args)
    }

    fun LAMBDA(pattern: KoKoAst, expr: KoKoAst, args: KoKoAst?): KoKoAst {
        return KoKoLambda(pattern, expr, args)
    }

    fun LAMBDACALL(pattern: KoKoAst, expr: KoKoAst, args: KoKoAst): KoKoAst {
        return KoKoLambdaCall(pattern, expr, args)
    }

    fun PARENT(head: KoKoAst): KoKoAst {
        return KoKoParent(head)
    }
	
	fun LENGTH(arr: KoKoAst, l: KoKoAst): KoKoAst{
        val id = l as KoKoId
        println("primi: "+id)
		return KoKoLength(arr)
	}

    fun PRINT(expr: KoKoAst): KoKoAst {
        return KoKoPrint(expr)
    }

    fun NOT(expr: KoKoAst): KoKoAst {
        return KoKoNOT(expr)
    }

    fun Tern_expr(condition: KoKoAst, tr: KoKoAst, fal: KoKoAst): KoKoAst {
        return KoKoTernExpr(condition, tr, fal)
    }

    fun LISTPAT(expr: KoKoAst): KoKoAst {
        return KoKoList_pat(expr)
    }

    fun ListBodyPat(pat: KoKoAst, rest: KoKoAst): KoKoAst{
        return KoKoListBodyPat(pat, rest)
    }

    fun FAILEXPR(operation: KoKoAst): KoKoAst{
        return KoKoFail(operation)
    }

    fun CONSEXPR(FArgs: KoKoAst, SArgs: KoKoAst): KoKoAst{
        return KoKoCons(FArgs, SArgs)
    }

    companion object {

        val TRUE = KoKoBool(true)
        val FALSE = KoKoBool(false)

        val PLUS: KoKoAst = KoKoId("+")
        val MINUS: KoKoAst = KoKoId("-")
        val MULT: KoKoAst = KoKoId("*")        //new
        val GREATER: KoKoAst = KoKoId(">")    //new
        val LESS: KoKoAst = KoKoId("<")        //new
        val EQUALS: KoKoAst = KoKoId("==")    //new
        val NOT_EQUALS: KoKoAst = KoKoId("!=") //new
        val AND: KoKoAst = KoKoId("&&")        //new
        val OR: KoKoAst = KoKoId("||")        //new
        val ERROR: KoKoAst = KoKoId("??")
        val LEQ: KoKoAst = KoKoId("<=") 
        val GEQ: KoKoAst = KoKoId(">=") 
    }

}