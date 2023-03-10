package tpoprogamriPackage;

public class GrafoDinamico implements GrafoTDA {
	NodoGrafo nodo;
	int cantidad;

	public void agregarVertice(int v) {
		if (this.encontrarNodo(v) == null) {

			NodoGrafo aux = new NodoGrafo();
			aux.valor = v;
			aux.lista = null;
			aux.sig = nodo;
			aux.Visitado = false;
			aux.marcado = false;
			nodo = aux;
			cantidad++;
		}

	}

	public void agregarArista(int v1, int v2, int peso) {
		if (this.encontrarNodo(v1) != null && this.encontrarNodo(v2) != null) {
			NodoArista aux = new NodoArista();
			aux.origen = v1;
			aux.peso = peso;
			aux.Visitado = false;
			aux.apunta = this.encontrarNodo(v2);
			aux.sig = encontrarNodo(v1).lista;
			encontrarNodo(v1).lista = aux;
		} else {
			System.out.println("No existe nodo");
		}
	}

	public void mostrarGrafo() {
		NodoGrafo aux = nodo;
		NodoArista arista;
		while (aux != null) {
			System.out.print(" Nodo: " + aux.valor + " - ");
			arista = aux.lista;
			while (arista != null) {

				System.out.print("Peso: " + arista.peso + " -> " + "Nodo: " + arista.apunta.valor + "\t");
				arista = arista.sig;
			}
			System.out.println();
			aux = aux.sig;
		}
	}

	public NodoGrafo encontrarNodo(int v) {
		NodoGrafo aux = nodo;
		while (aux != null) {
			if (aux.valor == v) {
				return aux;
			}
			aux = aux.sig;
		}
		return null;
	}
}