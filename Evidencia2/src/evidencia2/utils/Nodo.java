package evidencia2.utils;

import java.util.Optional;


/**
 * Representa un nodo en una estructura de datos enlazada.
 */
public class Nodo<E> {
    E dato;
    Optional<Nodo<E>> siguiente;

    public Nodo(E dato) {
        this.dato = dato;
        siguiente = Optional.empty();
    }
}
