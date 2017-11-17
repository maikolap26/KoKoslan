/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.io.*


class KoKoLet(val id: KoKoAst, val expr: KoKoAst) : KoKoAst {
    override fun genCode(out: PrintStream) {
        out.print("let ")
        this.id.genCode(out)
        out.print(" = ")
        this.expr.genCode(out)
        out.println()
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        val `val` = expr.eval(ctx)
        ctx.assoc(id as KoKoId, `val`)
        return `val`
    }
}