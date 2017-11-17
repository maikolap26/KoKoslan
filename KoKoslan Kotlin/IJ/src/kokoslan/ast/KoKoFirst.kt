/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.io.*
import java.util.*

class KoKoFirst(protected var arr: KoKoAst) : KoKoAst {

    override fun genCode(out: PrintStream) {
        out.print("first")
		out.print("(")
		out.print("[")
        this.arr.genCode(out)
		out.print("]")
        out.print(")")
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        var arrE = arr.eval(ctx) as KoKoListValue
        return arrE.get(0)
    }

}