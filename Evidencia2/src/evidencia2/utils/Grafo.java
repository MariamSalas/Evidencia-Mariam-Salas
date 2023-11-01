package evidencia2.utils;

import java.util.*;


public class Grafo<T> {
    private Set<NodoGrafo<T>> nodos;
    private HashMap<NodoGrafo<T>, Integer> distancias;

    public Grafo() {
        nodos = new HashSet<>();
        distancias = new HashMap<>();
        inicializarDistancias();
    }

    public void agregarNodo(NodoGrafo<T> nuevoNodo) {
        if (nuevoNodo != null && !nodos.contains(nuevoNodo)) {
            nodos.add(nuevoNodo);
        }
    }

    public void agregarArista(NodoGrafo<T> desde, NodoGrafo<T> hacia, int peso) {
        if (desde != null && hacia != null) {
            desde = obtenerNodo(desde.obtenerDato());
            desde.agregarArista(hacia, peso);
            agregarNodo(desde);
            agregarNodo(hacia);
        }
    }

    public boolean existeCaminoDFS(NodoGrafo<T> origen, NodoGrafo<T> destino) {
        System.out.println("Búsqueda en Profundidad (DFS)");

        if (origen == null || destino == null) {
            return false;
        }

        Set<NodoGrafo<T>> visitados = new HashSet<>();
        Stack<NodoGrafo<T>> pila = new Stack<>();

        pila.push(origen);
        visitados.add(origen);

        while (!pila.isEmpty()) {
            NodoGrafo<T> nodoActual = pila.pop();
            System.out.println("Nodo actual:\n" + nodoActual);

            if (nodoActual.equals(destino)) {
                return true;
            }

            for (NodoGrafo<T> vecino : nodoActual.obtenerAristas().keySet()) {
                if (!visitados.contains(vecino)) {
                    pila.push(vecino);
                    visitados.add(vecino);
                }
            }
        }

        return false;
    }

    public boolean existeCaminoBFS(NodoGrafo<T> origen, NodoGrafo<T> destino) {
        System.out.println("Búsqueda en Anchura (BFS)");

        if (origen == null || destino == null) {
            return false;
        }

        Set<NodoGrafo<T>> visitados = new HashSet<>();
        Queue<NodoGrafo<T>> cola = new Queue<NodoGrafo<T>>();

        cola.agregar(origen);
        visitados.add(origen);

        while (!cola.isEmpty()) {
            NodoGrafo<T> nodoActual = cola.peek().get();
            System.out.println("Nodo actual:\n" + nodoActual);

            if (nodoActual.equals(destino)) {
                return true;
            }

            for (NodoGrafo<T> vecino : nodoActual.obtenerAristas().keySet()) {
                if (!visitados.contains(vecino)) {
                    cola.agregar(vecino);
                    visitados.add(vecino);
                }
            }

            cola.pop();
        }

        return false;
    }

    public int caminoMasCortoDijkstra(NodoGrafo<T> origen, NodoGrafo<T> destino) {
        if (origen == null || destino == null) {
            return -1;
        }

        Map<NodoGrafo<T>, Integer> distancias = new HashMap<>();
        Set<NodoGrafo<T>> visitados = new HashSet<>();

        for (NodoGrafo<T> nodo : nodos) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }

        distancias.put(origen, 0);

        while (!visitados.contains(destino)) {
            NodoGrafo<T> nodoActual = null;
            int distanciaMinima = Integer.MAX_VALUE;

            for (NodoGrafo<T> nodo : nodos) {
                if (!visitados.contains(nodo) && distancias.get(nodo) < distanciaMinima) {
                    nodoActual = nodo;
                    distanciaMinima = distancias.get(nodo);
                }
            }

            if (nodoActual == null) {
                break;
            }

            visitados.add(nodoActual);

            for (Map.Entry<NodoGrafo<T>, Integer> entrada : nodoActual.obtenerAristas().entrySet()) {
                NodoGrafo<T> vecino = entrada.getKey();
                int peso = entrada.getValue();
                if (!visitados.contains(vecino)) {
                    int nuevaDistancia = distancias.get(nodoActual) + peso;
                    if (nuevaDistancia < distancias.get(vecino)) {
                        distancias.put(vecino, nuevaDistancia);
                    }
                }
            }
        }

        return distancias.get(destino);
    }

    public NodoGrafo<T> obtenerNodo(T dato) {
        Optional<NodoGrafo<T>> nodoEncontrado = nodos.stream()
                .filter(nodo -> dato.equals(nodo.obtenerDato()))
                .findFirst();
        return nodoEncontrado.orElse(null);
    }

    public Set<NodoGrafo<T>> obtenerNodos() {
        return nodos;
    }

    private void inicializarDistancias() {
        for (NodoGrafo<T> nodo : nodos) {
            distancias.put(nodo, Integer.MAX_VALUE);
        }
    }
    private int V; // Número de vértices
    private List<List<Integer>> adjacencyList;



    public void addEdge(NodoGrafo<T> source, NodoGrafo<T> destination, int weight) {
        if (source != null && destination != null) {
            source = obtenerNodo(source.obtenerDato());
            destination = obtenerNodo(destination.obtenerDato());

            if (source != null && destination != null) {
                source.agregarArista(destination, weight);
                agregarNodo(source);
            }
        }
    }


    private class Edge {
            int destination;
            int weight;

            public Edge(int destination, int weight) {
                this.destination = destination;
                this.weight = weight;
            }
        }
}

