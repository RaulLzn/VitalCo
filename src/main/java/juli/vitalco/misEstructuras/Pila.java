package juli.vitalco.misEstructuras;

public class Pila<T> { 
	private Nodo<T> cabeza;
	
    public Pila() {
		this.cabeza = null;
	}

    // Método que agrega un elemento a la pila
	public void push(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza = nuevoNodo;
        }
    }

    // Método que elimina el último elemento agregado a la pila
    public T pop() {
        if (estaVacia()) {
            System.out.println("La pila está vacía. No se puede extraer ningún elemento.");
            return null;
        }
        T valor = cabeza.getValor();
        cabeza = cabeza.siguiente;
        if (cabeza == null) {
            System.out.println("Se ha extraído el último elemento de la pila.");
        }
        return valor   ;
    }

    // Método que muestra el último elemento agregado a la pila
    public T peek() {
        if (estaVacia()) {
            System.out.println("La pila está vacía. No hay elementos para mostrar.");
            return null;
        }
        return cabeza.getValor();
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public T[] toArray() {
        int size = size(); // Calcular el tamaño de la pila
        T[] array = (T[]) new Object[size]; // Crear un arreglo del tamaño de la pila
        Nodo<T> temp = cabeza; // Nodo temporal para recorrer la pila
        int index = 0;

        // Recorrer la pila y agregar los elementos al arreglo
        while (temp != null) {
            array[index++] = temp.getValor();
            temp = temp.getSiguiente();
        }

        return array;
    }

    public int size() {
        int size = 0;
        Nodo<T> temp = cabeza;
        while (temp != null) {
            size++;
            temp = temp.getSiguiente();
        }
        return size;
    }

    //metodo addAll
    public void addAll(Pila<T> pila) {
        while (!pila.estaVacia()) {
            push(pila.pop());
        }
    }

    private static class Nodo<T> {
        T valor;
        Nodo<T> siguiente;
        Nodo<T> anterior;
        
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
