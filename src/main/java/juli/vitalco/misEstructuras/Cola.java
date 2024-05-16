package juli.vitalco.misEstructuras;

public class Cola<T> {
	private Nodo<T> siguiente;
    private Nodo<T> ultimo;

    public Cola() {
        this.siguiente = null;
        this.ultimo = null;
    }

    // Método que agrega un elemento a la cola
    public void enqueue(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (estaVacia()) {
            siguiente = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.siguiente = nuevoNodo;
            ultimo = nuevoNodo;
        }
    }

    // Método que elimina el primer elemento agregado a la cola
    public T dequeue() {
        if (estaVacia()) {
            System.out.println("La cola está vacía. No se puede extraer ningún elemento.");
            return null;
        }
        T elemento = siguiente.getValor();
        siguiente = siguiente.siguiente;
        if (siguiente == null) {
            ultimo = null;
        }
        return elemento;
    }

    // Método que muestra el primer elemento agregado a la cola
    public T peek() {
        if (estaVacia()) {
            System.out.println("La cola está vacía. No hay elementos para mostrar.");
            return null;
        }
        return siguiente.getValor();
    }

    public boolean estaVacia() {
        return siguiente == null;
    }

    //vaciar la cola
    public void vaciar() {
        siguiente = null;
        ultimo = null;
    }


    public Object[] toArray() {
        Object[] array = new Object[tamano()];
        Nodo<T> temp = ultimo;
        for (int i = 0; i < array.length; i++) {
            array[i] = temp.getElemento();
            temp = temp.getSiguiente();
        }
        return array;
    }

    public int tamano() {
        int size = 0;
        Nodo<T> temp = siguiente;
        while (temp != null) {
            size++;
            temp = temp.siguiente;
        }
        return size;
    }
    
    private static class Nodo<T> {
        T valor;
        Nodo<T> siguiente;
        Nodo<T> anterior;

        public T getElemento() {
            return valor;
        }
        
        public Nodo(T valor){
            this(valor, null, null);
        }

        public Nodo(T valor, Nodo<T> siguiente, Nodo<T> anterior) {
            this.valor = valor;
            this.siguiente = siguiente;
            this.anterior = anterior;
        }

        public T getValor() {
            return valor;
        }

        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<T> siguiente) {
            this.siguiente = siguiente;
        }

        public Nodo<T> getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo<T> anterior) {
            this.anterior = anterior;
        }
    }
}
