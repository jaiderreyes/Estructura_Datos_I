package listacircularsimple;

public class ListaCircular {
    private Nodo cabeza;
    private Nodo cola;

    public ListaCircular() {
        cabeza = null;
        cola = null;
    }

    // Insertar al final
    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza;
        }
        System.out.println("Nodo insertado: " + dato);
    }

    // Mostrar en orden desde la cabeza
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo actual = cabeza;
        System.out.print("Lista Circular: ");
        do {
            System.out.print("[" + actual.dato + "] -> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(cabeza)");
    }

    // Buscar
    public boolean buscar(int valor) {
        if (cabeza == null) return false;
        Nodo actual = cabeza;
        do {
            if (actual.dato == valor) return true;
            actual = actual.siguiente;
        } while (actual != cabeza);
        return false;
    }

    // Eliminar primera ocurrencia
    public void eliminar(int valor) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo actual = cabeza;
        Nodo anterior = cola;
        boolean encontrado = false;

        do {
            if (actual.dato == valor) {
                encontrado = true;
                if (actual == cabeza) {
                    if (cabeza == cola) { // único nodo
                        cabeza = null;
                        cola = null;
                    } else {
                        cabeza = cabeza.siguiente;
                        cola.siguiente = cabeza;
                    }
                } else if (actual == cola) {
                    cola = anterior;
                    cola.siguiente = cabeza;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                System.out.println("Nodo eliminado: " + valor);
                break;
            }
            anterior = actual;
            actual = actual.siguiente;
        } while (actual != cabeza);

        if (!encontrado) {
            System.out.println("El nodo con valor " + valor + " no existe en la lista.");
        }
    }

    // Contar
    public int contarNodos() {
        if (cabeza == null) return 0;
        int contador = 0;
        Nodo actual = cabeza;
        do {
            contador++;
            actual = actual.siguiente;
        } while (actual != cabeza);
        return contador;
    }
}
