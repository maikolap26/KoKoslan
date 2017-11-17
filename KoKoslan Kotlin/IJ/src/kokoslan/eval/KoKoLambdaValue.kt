/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.io.*

class KoKoLambdaValue<T>(val pattern: T, val expr: T, val args: T?) : KoKoValue {
    override fun toString(): String {
        return if (this.args != null)
            this.pattern.toString() + this.expr.toString() + this.args.toString()
        else
            this.pattern.toString() + this.expr.toString()
    }
}