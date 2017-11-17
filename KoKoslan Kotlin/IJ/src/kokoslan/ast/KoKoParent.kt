/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.io.*
import java.util.*

class KoKoParent(protected var head: KoKoAst) : KoKoAst {

    override fun genCode(out: PrintStream) {
        out.print("(")
        this.head.genCode(out)
        out.print(")")
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        val v = this.head.eval(ctx) as KoKoNumValue
        return KoKoNumValue(v.value)
    }

}