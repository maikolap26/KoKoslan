/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.io.*
import java.util.*

class KoKoFail(var operation: KoKoAst) : KoKoAst {

    override fun genCode(out: PrintStream) {
        this.operation.genCode(out)
        out.print("()")
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        throw Exception("Fail Exception")
    }

}