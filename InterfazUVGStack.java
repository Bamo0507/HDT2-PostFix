//Bryan Alberto Martínez Orellana 23542
//Adriana Sophia Palacios Contreras 23044
//Fecha de Creación: 28/01/2024
//Fecha de Última Modificacion: 28/01/2024
//Hoja de Trabajo 2 - Calculadora de Operaciones PostFix

public interface InterfazUVGStack<E> {
    // Métodos a utilizar para las clases que sirvan como Stack
    public void push(E x); //Inserta un elemento en la parte superior del Stack
    public E pop(); //Elimna y devuelve el elemento de la parte superior del Stack
    public E top(); //Devuelve el elemento de encima sin eliminarlo
    public boolean isEmpty(); //Verifica que el Stack no esté vacío
}
