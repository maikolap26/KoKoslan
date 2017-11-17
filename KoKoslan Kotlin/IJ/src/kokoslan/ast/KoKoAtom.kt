/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.io.*


open class KoKoAtom<T>(val value: T) : KoKoAst {
    override fun genCode(out: PrintStream) {
        out.print(this.value.toString() + " ")
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        throw KoKoEvalException("KoKoAtom: eval not implemented")

    }

    override fun toString(): String {
        return value.toString()
    }
}