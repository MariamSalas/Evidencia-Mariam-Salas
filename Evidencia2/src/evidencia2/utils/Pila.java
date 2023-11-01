package evidencia2.utils;

import java.util.Optional;


public class Pila<E> {
    private ListaEnlazada<E> elementos;

    public Pila() {
        elementos = new ListaEnlazada<>();
    }

    public void apilar(E elemento) {
        elementos.agregarPrimero(elemento);
    }

    public Optional<E> verCima() {
        if (!elementos.isEmpty()) {
            return elementos.getFirst();
        } else {
            return Optional.empty();
        }
    }

    public Optional<E> desapilar() {
        if (!elementos.isEmpty()) {
            return Optional.of(elementos.removeFirst());
        } else {
            return Optional.empty();
        }
    }

    public int tamaño() {
        return elementos.obtenerTamaño();
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }
}
