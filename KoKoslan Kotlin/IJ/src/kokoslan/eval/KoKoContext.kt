/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

import java.util.*

class KoKoContext (private val parent: KoKoContext? = null) : HashMap<String, KoKoValue>() {
    fun find(id: KoKoId): KoKoValue {
        val `val` = get(id.value)
        if (`val` != null) return `val`
        if (parent == null) throw KoKoNotFoundId(id)
        return parent.find(id)
    }

    fun assoc(id: KoKoId, `val`: KoKoValue) {
        put(id.value, `val`)
    }

    fun push(): KoKoContext {
        return KoKoContext(this)
    }

    fun pop(): KoKoContext {
        if (parent == null) throw KoKoStackUnderflow()
        return parent
    }

}