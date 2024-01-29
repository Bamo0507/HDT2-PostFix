import java.util.Vector;

public class Pila implements InterfazUVGStack<Integer>{
    private Vector<Integer> numeros; 

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
    public void push(Integer numero){
        numeros.add(numero);
    }

}
