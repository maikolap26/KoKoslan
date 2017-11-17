/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.util.*
import java.io.*


class KoKoGEQ(operator: KoKoAst, left: KoKoAst, right: KoKoAst) : KoKoBiOperation(operator, left, right) {

    override fun eval(ctx: KoKoContext): KoKoValue {
        try {
            val lv = left().eval(ctx) as KoKoNumValue
            val rv = right().eval(ctx) as KoKoNumValue
            return KoKoBoolValue(lv.value > rv.value || lv.value == rv.value)
        } catch (e: Exception) {
            throw KoKoEvalException(e.toString())
        }

    }

}