/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.io.*
import java.util.*

data class KoKoListBodyPat(var pat: KoKoAst,var rest: KoKoAst) : KoKoAst {

    override fun genCode(out: PrintStream) {
        this.pat.genCode(out)
        out.print("|")
        this.rest.genCode(out)
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        val va = ctx.find(this.pat as KoKoId)
        return KoKoAtomValue(va)
    }

}