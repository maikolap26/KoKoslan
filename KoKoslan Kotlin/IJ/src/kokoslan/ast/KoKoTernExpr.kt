/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.io.*


data class KoKoTernExpr(val condition: KoKoAst, val `true`: KoKoAst, val `false`: KoKoAst) : KoKoAst {

    init {
    }

    override fun genCode(out: PrintStream) {
        this.condition.genCode(out)
        out.print(" ? ")
        this.`true`.genCode(out)
        out.print(" : ")
        this.`false`.genCode(out)
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        val lv = condition.eval(ctx) as KoKoBoolValue
        if (lv.value) {
            //println("Es true")
            return `true`.eval(ctx)
        } else {
            //println("Es false")
            return `false`.eval(ctx)
        }

        //throw new KoKoEvalException("KoKoTernExpr: eval not implemented");

    }
}