/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.util.*
import java.io.*

class KoKoProgram(private val statements: List<KoKoAst>) : KoKoAst {
    override fun genCode(out: PrintStream) {
        this.statements
                .forEach { t -> t.genCode(out) }
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        var res: KoKoValue?
        for (i in 0 until statements.size - 1) {
            res = statements[i].eval(ctx)
        }
        res = statements[statements.size - 1].eval(ctx)
        return res
    }

    fun eval(): KoKoValue? {
        return eval(KoKoContext())
    }
}