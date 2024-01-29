import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PilaTest {

    private Pila pila;

    @Before
    public void setUp() {
        pila = new Pila();
    }


    @Test
    public void testIsEmpty() {
        pila.push(5);
        assertFalse(pila.isEmpty());
    }

    @Test
    public void testPush() {
        pila.push(10);
        assertFalse(pila.isEmpty());
    }

    @Test
    public void testPop() {
        pila.push(20);
        pila.push(30);
        assertEquals(Integer.valueOf(30), pila.pop());
    }

    @Test
    public void testTop() {
        pila.push(40);
        pila.push(50);
        assertEquals(Integer.valueOf(50), pila.top());
    }
}
