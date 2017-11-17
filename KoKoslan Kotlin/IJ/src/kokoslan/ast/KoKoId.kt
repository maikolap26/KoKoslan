/*
 Maykol Alfaro Paniagua
 Alexander Jiménez Mejía
 Giancarlo Navarro Valverde
 Jeffrie Sáenz Rodríguez
 */
package kokoslan.ast


class KoKoId(value: String) : KoKoAtom<String>(value) {
    override fun eval(ctx: KoKoContext): KoKoValue {
        return ctx.find(this)
    }

}