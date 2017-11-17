/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast

class KoKoNum(value: Double) : KoKoAtom<Double>(value) {
    override fun eval(ctx: KoKoContext): KoKoValue {
        return KoKoNumValue(value)

    }

}