package juli.misEstructuras;

public interface Lista<T> {
    void agregarAlInicio(T valor);//Añade un nuevo elemento al inicio de la lista.Actualiza las referencias del nodo actual de la cabeza y del nuevo nodo.
    void agregarAlFinal(T valor);//Inserta un elemento al final de la lista.Si la lista está vacía,se convierte en el nuevo nodo de la cabeza
    T eliminarDelInicio();//Remueve el primer elemento de la lista,ajustando las referencias del siguiente nodo para que sea la nueva cabeza.
    T eliminarDelFinal();//Elimina el último elemento de la lista,modificando la referencia del penúltimo nodo.
    T eliminarDelMedio(int posicion);//Remueve un nodo en una posición específica que no es ni el inicio ni el final.
    boolean estaVacia();//Verifica si la lista no tiene elementos y retorna un valor booleano.
    int tamano();//Retorna el tamaño de la lista
    T BuscarElemento(int indice);//Encuentra la primera ocurrencia de un valor y devuelve su posición o un indicador de no encontrado.
    void agregarAlMedio(T valor, int posicion);//Inserta un elemento en una posición específica,no solo al inicio o al final.   
}
