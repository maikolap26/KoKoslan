/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.util.*
import java.io.*


class KoKoEQUALS(operator: KoKoAst, left: KoKoAst, right: KoKoAst) : KoKoBiOperation(operator, left, right) {

    override fun eval(ctx: KoKoContext): KoKoValue {
        try {
            val lv = left().eval(ctx) 
            val rv = right().eval(ctx)

            when{
                lv is KoKoNumValue ->{
                    val l = lv
                    val r = rv as KoKoNumValue
                    return KoKoBoolValue(l.value == r.value)
                }
                 lv is KoKoListValue && rv is KoKoListValue ->{
                    var res:Boolean
                    val l = lv
                    val r = rv 
                    res = evalList(l,r)
                
                    return KoKoBoolValue(res)
                }
                else -> {
                    throw Exception()
                }

            }            
        } catch (e: Exception) {
            throw KoKoEvalException(e.message.toString())
        }

    }

    fun evalList(l1: KoKoListValue, l2:KoKoListValue):Boolean{
        var res = false
        if(l1.size != l2.size)
            return false
    for((index, lValue) in  l1.withIndex() ){
            when{
                lValue is KoKoListValue && l2.get(index) is KoKoListValue ->{
                    res = evalList(lValue, l2.get(index) as KoKoListValue)
                    if (!res) return res
                    
                }
                lValue is KoKoListValue && l2.get(index) is KoKoNumValue ||
                lValue is KoKoNumValue && l2.get(index) is KoKoListValue -> {
                    return false
                }
                else ->{
                    if((lValue as KoKoNumValue).value != (l2.get(index) as KoKoNumValue).value){
                    res = false
                    return res
                     }
                    res = true
                }

                }

            }

    return res;
    }

}