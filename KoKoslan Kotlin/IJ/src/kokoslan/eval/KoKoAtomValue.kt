/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.io.*

open class KoKoAtomValue<T>(val value: T) : KoKoValue {
    override fun toString(): String = value.toString()
}