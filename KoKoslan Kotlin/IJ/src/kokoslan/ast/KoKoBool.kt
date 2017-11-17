/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

class KoKoBool(value: Boolean) : KoKoAtom<Boolean>(value) {
    override fun eval(ctx: KoKoContext): KoKoValue = KoKoBoolValue(value)

}