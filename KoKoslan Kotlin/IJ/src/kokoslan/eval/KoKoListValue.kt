/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */

package kokoslan.ast

import java.util.*
import java.io.*

class KoKoListValue : ArrayList<KoKoValue>, KoKoValue {
    constructor(list: List<KoKoValue>) : super(list)
    constructor() : super()

}