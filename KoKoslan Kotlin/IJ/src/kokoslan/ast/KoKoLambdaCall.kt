/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.io.*


class KoKoLambdaCall(val pattern: KoKoAst, val expr: KoKoAst, val args: KoKoAst) : KoKoAst {
    override fun genCode(out: PrintStream) {
        out.print(" ( ")
        this.pattern.genCode(out)
        out.print(" -> ")
        this.expr.genCode(out)
        out.print(" ) ")
        this.args.genCode(out)
        out.println()
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        //val expression = expr as KoKoBiOperation
        //KoKoAst num = (KoKoAst)this.args.eval(ctx);
        //val ex = KoKoBiOperation(expression.operador, this.args, this.args)
        throw Exception()
    }
}