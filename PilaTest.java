import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


/**
 * Clase de pruebas para la clase Pila.
 */
public class PilaTest {

// Objeto Pila para las pruebas
    private Pila pila;


     /**
     * Método de configuración que se ejecuta antes de cada prueba.
     */
    @Before
    public void setUp() {
        // Inicializa una nueva pila antes de cada prueba
        pila = new Pila();
    }


   /**
     * Prueba el método isEmpty cuando la pila contiene elementos.
     */

    @Test
    public void testIsEmpty() {
    // Inserta un elemento en la pila
        pila.push(5);
        assertFalse(pila.isEmpty());
    }


     /**
     * Prueba el método push al insertar un elemento en la pila.
     */
    @Test
    
    public void testPush() {
         // Inserta un elemento en la pila
        pila.push(10);
        assertFalse(pila.isEmpty());
    }

    @Test
    public void testPop() {
         // Inserta dos elementos en la pila
        pila.push(20);
        pila.push(30);
        // Al llamar a pop, debería devolver el último elemento insertado (30)
        assertEquals(Integer.valueOf(30), pila.pop());
    }


    /**
     * Prueba el método top al obtener el elemento en la cima de la pila sin eliminarlo.
     */
    @Test
    public void testTop() {
        // Inserta dos elementos en la pila
        pila.push(40);
        pila.push(50);
        assertEquals(Integer.valueOf(50), pila.top());
    }
}
