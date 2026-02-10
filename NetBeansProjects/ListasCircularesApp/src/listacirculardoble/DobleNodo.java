package listacirculardoble;

public class DobleNodo {
    int dato;
    DobleNodo siguiente;
    DobleNodo anterior;

    public DobleNodo(int dato) {
        this.dato = dato;
        this.siguiente = this;
        this.anterior = this;
    }
}
