/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.io.*


data class KoKoLambda(val pattern: KoKoAst, val expr: KoKoAst, val args: KoKoAst?) : KoKoAst { //puede que no hayan args
    override fun genCode(out: PrintStream) {
        out.print("\\")
        this.pattern.genCode(out)
        out.print(".(")
        this.expr.genCode(out)
        out.print(")")
        if (this.args != null) {
            out.print(" ( ")
            this.args.genCode(out)
            out.print(" ) ")
        }
    }
    
    override fun eval(ctx: KoKoContext): KoKoValue {
        if (args != null) {
            val id = KoKoId("zzz")
            ctx.assoc(id, KoKoLambdaValue(pattern, expr, args))
            val call = KoKoCall(id, args as KoKoList)
            return call.eval(ctx)
        } else
            return KoKoLambdaValue(pattern, expr, args) //sino hay argumentos solo devuelve la lambda
    }
}