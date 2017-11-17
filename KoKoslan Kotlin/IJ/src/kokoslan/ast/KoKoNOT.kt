/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.io.*
import java.util.*

class KoKoNOT(protected var expr: KoKoAst) : KoKoAst {

    override fun genCode(out: PrintStream) {
        out.print("!")
        this.expr.genCode(out)
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        val v = this.expr.eval(ctx) as KoKoBoolValue
        return KoKoBoolValue(!v.value)
    }

}