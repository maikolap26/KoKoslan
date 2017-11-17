/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.util.*


open class KoKoBiOperation( operador: KoKoAst,  left: KoKoAst,  right: KoKoAst) : KoKoOperation(operador, Arrays.asList(left, right)) {

    fun left(): KoKoAst {
        return this.operands[0]
    }

    fun right(): KoKoAst {
        return this.operands[1]
    }

    fun logicOperation(operator: String): Boolean {
        return operator == "&&" || operator == "||"
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        println("biOper")
        try {
            val operId = operador as KoKoId
            if (logicOperation(operId.value)) {
                return eval_bool(ctx)
            }

            val lv = left().eval(ctx) as KoKoNumValue
            val rv = right().eval(ctx) as KoKoNumValue


            when (operId.value) {
                "+" -> return KoKoNumValue(lv.value + rv.value)
                "-" -> return KoKoNumValue(lv.value - rv.value)
                "*" -> return KoKoNumValue(lv.value * rv.value)    //new
                "/" -> return KoKoNumValue(lv.value / rv.value)
                ">" -> return KoKoBoolValue(lv.value > rv.value) //new
                "<" -> return KoKoBoolValue(lv.value < rv.value) //new
                "==" -> return KoKoBoolValue(lv.value == rv.value) //new
                "!=" -> return KoKoBoolValue(lv.value != rv.value) //new
                "<=" -> return KoKoBoolValue(lv.value <= rv.value) //new
                ">=" -> return KoKoBoolValue(lv.value >= rv.value) //new
                else -> throw KoKoEvalException("KoKoBiOperation: unimplemented operador: " + operId.value)
            }

        } catch (e: Exception) {
            throw KoKoEvalException(e.message.toString())
        }

    }

    fun eval_bool(ctx: KoKoContext): KoKoValue {
        try {
            val operId = operador as KoKoId
            val lv = left().eval(ctx) as KoKoBoolValue
            val rv = right().eval(ctx) as KoKoBoolValue
            when (operId.value) {
                "&&" -> return KoKoBoolValue(lv.value && rv.value) //new
                "||" -> return KoKoBoolValue(lv.value || rv.value) //new
                else -> throw KoKoEvalException("KoKoBiOperation_bool: unimplemented operador: " + operId.value)
            }

        } catch (e: Exception) {
            throw KoKoEvalException(e.message.toString())
        }

    }

}