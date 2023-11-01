package evidencia2.utils;

import java.util.Optional;

/**
 * Interfaz base para la implementación de listas enlazadas.
 */
public interface IListaEnlazada<E> {
    void agregar(E elemento);
    void eliminar(E elemento);
    Optional<E> obtener(int índice);
    void actualizar(E valorAntiguo, E valorNuevo);
    int obtenerTamaño();
    boolean contiene (E elemento);
}
