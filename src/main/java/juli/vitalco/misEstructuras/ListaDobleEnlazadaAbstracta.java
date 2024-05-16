package juli.vitalco.misEstructuras;

public abstract class ListaDobleEnlazadaAbstracta<T> implements Lista<T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamano;

    public ListaDobleEnlazadaAbstracta() {
        cabeza = null;
        cola = null;
        tamano = 0;
    }
    
    //Añade un nuevo elemento al inicio de la lista.Actualiza las referencias del nodo actual de la cabeza y del nuevo nodo.
    @Override
    public void agregarAlInicio(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor, cabeza, null);
        if (cabeza != null) {
            cabeza.setAnterior(nuevoNodo);
        }
        cabeza = nuevoNodo;
        if (cola == null) {
            cola = nuevoNodo;
        }
        tamano++;
    }

    //Inserta un elemento al final de la lista.Si la lista está vacía,se convierte en el nuevo nodo de la cabeza
    @Override
    public void agregarAlFinal(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor, null, cola);
        if (cola != null) {
            cola.setSiguiente(nuevoNodo);
        }
        cola = nuevoNodo;
        if (cabeza == null) {
            cabeza = nuevoNodo;
        }
        tamano++;
    }

    //Inserta un elemento en una posición específica,no solo al inicio o al final.  
    @Override
    public void agregarAlMedio(T valor,int posicion) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if(posicion == 0){
            nuevoNodo.siguiente = cabeza;
            if(cabeza != null){
                cabeza.anterior = nuevoNodo;
            }
            cabeza = nuevoNodo;
        }else{
            Nodo<T> actual = cabeza;
            int contador = 0;
            while(contador < posicion -1 && actual != null){
                actual = actual.siguiente;
                contador++;
            }
            if(actual != null){
                nuevoNodo.siguiente = actual.siguiente;
                if(actual.siguiente != null){
                    actual.siguiente.anterior = nuevoNodo;
                }
                actual.siguiente = nuevoNodo;
                nuevoNodo.anterior = actual;
            }else{
                System.out.println("Posicion fuera de rango");
            }
        }
    }

    //Verifica si la lista no tiene elementos y retorna un valor booleano.
    @Override
    public boolean estaVacia() {
        return tamano == 0;
    }

    //Retorna el tamaño de la lista
    @Override
    public int tamano() {
        return tamano;
    }

    //Remueve el primer elemento de la lista,ajustando las referencias del siguiente nodo para que sea la nueva cabeza.
    @Override
    public T eliminarDelInicio() {             
        if(cabeza != null){                     //Valida que la lista no este vacia,si no,se guarda el elemento en "valor"
            T valor = cabeza.getValor();        
            cabeza = cabeza.getSiguiente();     //Si hay un nuevo nodo,establecemos su referencia anterior como nula,ya que sera la nueva cabeza
            if(cabeza != null){
               cabeza.setAnterior(null);
            }else{
                cola=null;
            }
            return valor;  // retorna el valor del nodo eliminado
        }else{
            return null;
        }
    }

    //Elimina el último elemento de la lista,modificando la referencia del penúltimo nodo.
    @Override
    public T eliminarDelFinal() {
        if(cabeza == null){ //Valida si la cabeza es nula,si es asi,retorna null
            return null;
        }else if (cabeza.getSiguiente() == null){ //Valida si la lista tiene un solo nodo,si esa asi
            T valor = cabeza.getValor();          //guardamos el contenido de ese unico nodo en "valor"
            cabeza = null;                        //y hacemos la cabeza nula,lo cual significa que la lista esta vacia
            return valor;
        }else{                                                    //Cuando tiene mas de uno,recorre la lista hasta el penultimo elemento
            Nodo<T> actual = cabeza;                              //se guarda el valor del ultimo elemento y se establece nulo el ultimo
            while(actual.getSiguiente().getSiguiente() !=null){   
                actual = actual.getSiguiente();
            }
            T valor = actual.getSiguiente().getValor();
            actual.setSiguiente(null);
            return valor;        //retorna el valor del nodo eliminado
        }      
    }
    
    //Remueve un nodo en una posición específica que no es ni el inicio ni el final.
    @Override
    public T eliminarDelMedio(int posicion){
        if(cabeza == null){
            return null;
        }
        if(posicion == 0){
            cabeza = cabeza.siguiente;
            if(cabeza != null){
                cabeza.anterior = null;
            }else{
                Nodo<T> actual = cabeza;
                int contador = 0;
                while(contador < posicion && actual != null){
                actual = actual.siguiente;
                contador++;
            }	
                if(actual != null){
                    if(actual.anterior != null){
                        actual.anterior.siguiente = actual.siguiente;
                    }
                    if(actual.siguiente != null){
                        actual.siguiente.anterior = actual.anterior;
                    }
                }else{
                    System.out.println("Posicion fuera de rango");
                }
            }
        }
        return null;
    }
     
    //Encuentra la primera ocurrencia de un valor y devuelve su posición o un indicador de no encontrado.
    @Override
    public T BuscarElemento(int indice) {
        if (indice < 0 || indice >= tamano()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Nodo<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getValor();
    }  
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = cabeza;
        while (actual != null) {
            sb.append(actual.getValor());
            if (actual.getSiguiente() != null) {
                sb.append(" -> ");
            }
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }

    public T buscarPorIndiceIterar(int indice) {
        if (indice < 0 || indice >= tamano()) { // Verificar si el índice está fuera de los límites de la lista
            return null; // Retornar null si el índice no es válido
        }

        Nodo<T> actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getValor(); // Retornar el valor del nodo actual después de iterar hasta el índice deseado
    }

    public T[] toArray() {
        T[] arreglo = (T[]) new Object[tamano];
        Nodo<T> actual = cabeza;
        for (int i = 0; i < tamano; i++) {
            arreglo[i] = actual.getValor();
            actual = actual.getSiguiente();
        }
        return arreglo;
    }

    public T buscarObjeto(T valor) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.getValor().equals(valor)) {
                return actual.getValor();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    //get cabeza
    public Nodo<T> getCabeza() {
        return cabeza;
    }

    //Eliminar un elemento
    public void eliminarElemento(T valor) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.getValor().equals(valor)) {
                if (actual == cabeza) {
                    cabeza = actual.getSiguiente();
                    if (cabeza != null) {
                        cabeza.setAnterior(null);
                    }
                } else if (actual == cola) {
                    cola = actual.getAnterior();
                    if (cola != null) {
                        cola.setSiguiente(null);
                    }
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                tamano--;
                return;
            }
            actual = actual.getSiguiente();
        }
    }

    //metodo para imprimir toda la lista
    public void imprimirLista(){
        Nodo<T> actual = cabeza;
        while(actual != null){
            System.out.println(actual.getValor());
            actual = actual.siguiente;
        }
    }

    //metodo para añadir una lista a otra lista
    public void agregarLista(ListaDobleEnlazada<T> lista){
        Nodo<T> actual = lista.getCabeza();
        while(actual != null){
            agregarAlFinal(actual.getValor());
            actual = actual.siguiente;
        }
    }
   
    // Clase interna Nodo
    public static class Nodo<T> {
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
