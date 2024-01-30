import java.util.Vector;

/**
 * Implementación de una pila (stack) utilizando un Vector en Java.
 *
 * @param <Integer> Tipo de elementos que la pila contendrá.
 */

public class Pila implements InterfazUVGStack<Integer>{
   
 // Vector que almacena los elementos de la pila
    private Vector<Integer> numeros; 


    /**
     * Constructor de la clase Pila. Inicializa el Vector para almacenar los elementos.
     */
    public Pila(){
        this.numeros = new Vector();
    }

    //Verificar si está llenó o vacío
    
    public boolean isEmpty(){
        if(numeros == null){
            return true; //Devuelve verdadero si sí está vacío
        } else {
            return false; //Devuelve falso si no está vacío
        }
    }

    //Método para meter valores al Vector
    /**
     * Inserta un elemento en la cima de la pila.
     *
     * @param numero Elemento a ser insertado en la pila.
     */

    public void push(Integer numero){
        numeros.add(numero);
    }


   /**
     * Elimina y devuelve el elemento en la cima de la pila.
     *
     * @return Elemento en la cima de la pila, o null si la pila está vacía.
     */ 
    public Integer pop() {
        if (!isEmpty()) {
            // Obtiene el último elemento
            Integer poppedValue = numeros.lastElement();
            // Elimina el último elemento
            numeros.remove(numeros.size() - 1);
            return poppedValue;
        }
        // Pila vacía
        return null;
    }

    /**
     * Obtiene el elemento en la cima de la pila sin eliminarlo.
     *
     * @return Elemento en la cima de la pila, o null si la pila está vacía.
     */
    public Integer top() {
        if (!isEmpty()) {
            // Obtiene el último elemento sin eliminarlo
            return numeros.lastElement();
        } else{
            return null;
        }
    }
}
