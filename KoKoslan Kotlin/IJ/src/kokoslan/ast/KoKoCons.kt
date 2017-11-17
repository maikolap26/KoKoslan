/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.io.*
import java.util.*

class KoKoCons(var FArgs: KoKoAst, var SArgs: KoKoAst) : KoKoAst {

    override fun genCode(out: PrintStream) {
        this.FArgs.genCode(out)
    }

    override fun eval(ctx: KoKoContext): KoKoValue {
        val FArgs = this.FArgs.eval(ctx)
        val SArgs = this.SArgs.eval(ctx) 
        val list = KoKoListValue()
        if(FArgs is KoKoListValue){
            FArgs.forEach{
                e -> list.add(e)
            }
        }
        else{
            list.add(FArgs)
        }
        if(SArgs is KoKoListValue){
            SArgs.forEach{
                e -> list.add(e)
            }
        }
        else{
            list.add(SArgs)
        }
        return list
    }
}