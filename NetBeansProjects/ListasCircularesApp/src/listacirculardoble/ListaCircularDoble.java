package listacirculardoble;

public class ListaCircularDoble {
    private DobleNodo cabeza; // referencia a un nodo cualquiera (cabeza lógica)

    public ListaCircularDoble() {
        cabeza = null;
    }

    // Insertar al final
    public void insertar(int dato) {
        DobleNodo nuevo = new DobleNodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            DobleNodo cola = cabeza.anterior;
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
        }
        System.out.println("Nodo insertado: " + dato);
    }

    // Mostrar hacia adelante
    public void mostrarAdelante() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.print("Lista Doble (→): ");
        DobleNodo actual = cabeza;
        do {
            System.out.print("[" + actual.dato + "] -> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(cabeza)");
    }

    // Mostrar hacia atrás
    public void mostrarAtras() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.print("Lista Doble (←): ");
        DobleNodo actual = cabeza.anterior; // empezar desde la cola
        do {
            System.out.print("[" + actual.dato + "] -> ");
            actual = actual.anterior;
        } while (actual != cabeza.anterior);
        System.out.println("(cola)");
    }

    // Buscar
    public boolean buscar(int valor) {
        if (cabeza == null) return false;
        DobleNodo actual = cabeza;
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

        DobleNodo actual = cabeza;
        do {
            if (actual.dato == valor) {
                if (actual.siguiente == actual) { // único elemento
                    cabeza = null;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                    if (actual == cabeza) {
                        cabeza = actual.siguiente;
                    }
                }
                System.out.println("Nodo eliminado: " + valor);
                return;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);

        System.out.println("El nodo con valor " + valor + " no existe en la lista.");
    }

    // Contar
    public int contarNodos() {
        if (cabeza == null) return 0;
        int contador = 0;
        DobleNodo actual = cabeza;
        do {
            contador++;
            actual = actual.siguiente;
        } while (actual != cabeza);
        return contador;
    }
}
