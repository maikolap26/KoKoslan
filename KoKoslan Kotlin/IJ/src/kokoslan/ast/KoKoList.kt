/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.util.*
import java.io.*

class KoKoList : ArrayList<KoKoAst>, KoKoAst {
    var list: List<KoKoAst>? = null
        internal set
    val f: KoKoAst
        get() = this[0]

    constructor(list: List<KoKoAst>) : super(list) {
        this.list = list
    }

    constructor() : super() {}

    override fun genCode(out: PrintStream) {
        if (this.size == 0) return
        this[0].genCode(out)
        this.drop(1)
                .forEach { t ->
                    out.print(", ")
                    t.genCode(out)
                    out.print(" ")
                }
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        val res = KoKoListValue()
        this.forEach { t -> res.add(t.eval(ctx)) }
        return res
    }

    fun eval(): KoKoValue {
        return eval(KoKoContext())
    }

    fun size(): Double {
		return this.size.toDouble()
	}

}