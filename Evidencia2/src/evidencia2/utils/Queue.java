package evidencia2.utils;

import java.util.Optional;

public class Queue<E>{
    private ListaEnlazada<E> queue;

    public Queue(){
        queue = new ListaEnlazada<>();
    }

    public void push(E elmtToPush){
        queue.agregar(elmtToPush);
    }

    public Optional<E> pop(){
        Optional<E> popped = queue.obtener(0);
        queue.eliminar(popped.get());
        return popped;
    }

    public Optional<E> peek(){
        return queue.obtener(0);
    }

    public int size() {
        return queue.obtenerTamaño();
    }

    public boolean isEmpty(){ return !(queue.obtenerTamaño() > 0);
    }
    public void agregar (E elemento) {
        push(elemento);
    }

}