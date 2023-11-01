package evidencia2.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class NodoGrafo<T> {
    private T dato;
    private Map<NodoGrafo<T>, Integer> pesosAristas;

    public NodoGrafo(T dato) {
        establecerDato(dato);
        pesosAristas = new HashMap<>();
    }

    public void agregarArista(NodoGrafo<T> nodoAdyacente, int pesoArista) {
        pesosAristas.put(nodoAdyacente, pesoArista);
    }

    public T obtenerDato() {
        return dato;
    }

    public Map<NodoGrafo<T>, Integer> obtenerAristas() {
        return pesosAristas;
    }

    public void establecerDato(T dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        String strResultado = "Nodo: " + this.obtenerDato();

        for (Map.Entry<NodoGrafo<T>, Integer> entrada : this.obtenerAristas().entrySet()) {
            strResultado += "\n\tVecino: " + entrada.getKey().obtenerDato() + ", Peso: " + entrada.getValue();
        }

        return strResultado;
    }

    @Override
    public boolean equals(Object otroObjeto) {
        if (this == otroObjeto) return true;
        if (otroObjeto == null || getClass() != otroObjeto.getClass()) return false;
        NodoGrafo<?> nodo = (NodoGrafo<?>) otroObjeto;
        return Objects.equals(dato, nodo.dato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dato);
    }
}
