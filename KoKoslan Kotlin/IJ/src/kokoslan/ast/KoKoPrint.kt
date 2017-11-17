/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.io.*
import java.util.*

class KoKoPrint(protected var expr: KoKoAst) : KoKoAst {

    override fun genCode(out: PrintStream) {
        out.print("print")
        out.print("(")
        this.expr.genCode(out)
        out.print(")")
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        val v = this.expr.eval(ctx) as KoKoNumValue
        return KoKoNumValue(v.value)
    }

}