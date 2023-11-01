package evidencia2;

import evidencia2.utils.Grafo;
import evidencia2.utils.NodoGrafo;

public class Main {
    public static void main(String[] args) {
            Grafo<String> grafo = new Grafo<>();

            NodoGrafo<String> nodeAxel = new NodoGrafo<>("Axel");
            NodoGrafo<String> nodeEduardo = new NodoGrafo<>("Eduardo");
            NodoGrafo<String> nodeMariam = new NodoGrafo<>("Mariam");
            NodoGrafo<String> nodeFabian = new NodoGrafo<>("Fabian");


            grafo.agregarNodo(nodeAxel);
            grafo.agregarNodo(nodeEduardo);
            grafo.agregarNodo(nodeMariam);
            grafo.agregarNodo(nodeFabian);

            grafo.addEdge(nodeAxel, nodeEduardo, 2);
            grafo.addEdge(nodeAxel, nodeMariam, 6);
            grafo.addEdge(nodeEduardo, nodeMariam, 2);
            grafo.addEdge(nodeEduardo, nodeFabian, 3);
            grafo.addEdge(nodeMariam, nodeFabian, 2);

            // Encontrar la distancia mínima entre dos nodos (por ejemplo, de A a D)
            int shortestDistance = grafo.caminoMasCortoDijkstra(nodeAxel, nodeFabian);

            if (shortestDistance != -1) {
                System.out.println("La distancia mínima entre Axel y Fabian es: " + shortestDistance);
            } else {
                System.out.println("No se encontró un camino entre Axel y Fabian");
            }

    }
}

