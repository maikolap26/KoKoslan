/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.util.*
import java.io.*


open class KoKoOperation(protected var operador: KoKoAst, protected var operands: MutableList<KoKoAst> = ArrayList()) : KoKoAst {
    fun addOperand(x: KoKoAst) {
        this.operands.add(x)
    }

    override fun genCode(out: PrintStream) {
        this.operands[0].genCode(out)
        this.operands
                .drop(1)
                .forEach { t ->
                    this.operador.genCode(out)
                    t.genCode(out)
                }
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        throw KoKoEvalException("KoKoOperation: eval not implemented")

    }

}