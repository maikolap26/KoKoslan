/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.io.*


interface KoKoAst {
    fun genCode() {
        genCode(System.out)
    }

    open fun genCode(out: PrintStream) {}
    fun eval(ctx: KoKoContext): KoKoValue

}