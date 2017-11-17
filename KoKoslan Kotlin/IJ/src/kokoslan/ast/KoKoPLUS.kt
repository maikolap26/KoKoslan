/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.util.*
import java.io.*


class KoKoPLUS(operador: KoKoAst, left: KoKoAst, right: KoKoAst) : KoKoBiOperation(operador, left, right) {

    override fun eval(ctx: KoKoContext): KoKoValue {
        try {
            val lv = left().eval(ctx) as KoKoNumValue
            val rv = right().eval(ctx) as KoKoNumValue
            return KoKoNumValue(lv.value + rv.value)
        } catch (e: Exception) {
            throw KoKoEvalException(e.message.toString())
        }

    }

}