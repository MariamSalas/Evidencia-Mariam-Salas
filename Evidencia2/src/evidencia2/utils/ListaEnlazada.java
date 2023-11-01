package evidencia2.utils;
import java.util.NoSuchElementException;
import java.util.Optional;

public class ListaEnlazada<E> implements IListaEnlazada<E> {
    private Optional<Nodo<E>> raíz;
    private int tamaño;

    public ListaEnlazada(){
        raíz = Optional.empty();
        tamaño = 0;
    }

    @Override
    public void agregar(E elemento) {
        Nodo<E> nuevoNodo = new Nodo<>(elemento);

        if (raíz.isEmpty()) {
            raíz = Optional.of(nuevoNodo);
        } else {
            Optional<Nodo<E>> nodoActual = raíz;

            while (nodoActual.get().siguiente.isPresent()) {
                nodoActual = nodoActual.get().siguiente;
            }

            nodoActual.get().siguiente = Optional.of(nuevoNodo);
        }

        aumentarTamaño();
    }

    public void agregarPrimero(E elemento) {
        Nodo<E> nuevoNodo = new Nodo<>(elemento);

        if (raíz.isEmpty()) {
            raíz = Optional.of(nuevoNodo);
        } else {
            nuevoNodo.siguiente = raíz;
            raíz = Optional.of(nuevoNodo);
        }

        aumentarTamaño();
    }

    @Override
    public void actualizar(E valorAntiguo, E valorNuevo) {
        Optional<Nodo<E>> nodoActual = raíz;

        while (nodoActual.isPresent() && !nodoActual.get().dato.equals(valorAntiguo)) {
            nodoActual = nodoActual.get().siguiente;
        }

        if (nodoActual.isPresent()) {
            nodoActual.get().dato = valorNuevo;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void eliminar(E elemento) {
        if (raíz.isEmpty()) {
            throw new NoSuchElementException();
        }

        if (raíz.get().dato.equals(elemento)) {
            raíz = raíz.get().siguiente;
            disminuirTamaño();
            return;
        }

        Optional<Nodo<E>> nodoActual = raíz;
        Optional<Nodo<E>> nodoAnterior = Optional.empty();

        while (nodoActual.isPresent()) {
            if (nodoActual.get().dato.equals(elemento)) {
                nodoAnterior.get().siguiente = nodoActual.get().siguiente;
                disminuirTamaño();
                return;
            }
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.get().siguiente;
        }

        throw new NoSuchElementException();
    }

    @Override
    public Optional<E> obtener(int índice) {
        if (índice < 0 || índice >= tamaño) {
            throw new IndexOutOfBoundsException();
        }

        int índiceActual = 0;
        Optional<Nodo<E>> nodoActual = raíz;

        while (índiceActual != índice) {
            nodoActual = nodoActual.get().siguiente;
            ++índiceActual;
        }

        return Optional.of(nodoActual.get().dato);
    }

    @Override
    public int obtenerTamaño() {
        return tamaño;
    }

    private void aumentarTamaño() {
        ++tamaño;
    }

    private void disminuirTamaño() {
        --tamaño;
    }

    @Override
    public boolean contiene(E elemento) {
        Optional<Nodo<E>> nodoActual = raíz;

        while (!nodoActual.get().dato.equals(elemento) && nodoActual.get().siguiente.isPresent()) {
            nodoActual = nodoActual.get().siguiente;
        }

        if (nodoActual.get().dato.equals(elemento)) {
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        return (this.obtenerTamaño() > 0)? false : true;
    }

    public Optional<E> getFirst(){
        return obtener(0);
    }
    public E removeFirst() {
        if (raíz.isEmpty()) {
            throw new NoSuchElementException();
        }

        E elementoEliminado = raíz.get().dato;
        raíz = raíz.get().siguiente;
        disminuirTamaño();

        return elementoEliminado;
    }

}
