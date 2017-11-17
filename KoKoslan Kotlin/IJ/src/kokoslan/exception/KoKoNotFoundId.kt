/**
 * @author loriacarlos@gmail.com
 */
package kokoslan.ast

class KoKoNotFoundId(id: KoKoId) : RuntimeException("*** Id '$id.value' is not defined! ***")