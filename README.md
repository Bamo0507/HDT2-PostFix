# Calculadora de Operaciones PostFix

Este proyecto implementa una calculadora de operaciones postfix, donde las operaciones se realizan después de los operandos. La calculadora utiliza una interfaz llamada `InterfazUVGStack` para definir las operaciones básicas de una estructura de datos tipo pila (stack), y luego se implementa una clase `Pila` que utiliza un Vector en Java para representar la pila. La clase `PostfixCalc` se encarga de realizar los cálculos de las operaciones postfix leyendo una expresión desde un archivo de texto. Además, se incluye una clase `PilaTest` con pruebas unitarias para verificar el correcto funcionamiento de la clase `Pila`.

## Descripción de las Clases y Métodos

### InterfazUVGStack<E>

- `push(E x)`: Inserta un elemento en la parte superior del stack.
- `pop()`: Elimina y devuelve el elemento de la parte superior del stack.
- `top()`: Devuelve el elemento de encima sin eliminarlo.
- `isEmpty()`: Verifica que el stack no esté vacío.

### Clase Pila

- `isEmpty()`: Verifica si la pila está vacía.
- `push(Integer numero)`: Inserta un elemento en la cima de la pila.
- `pop()`: Elimina y devuelve el elemento en la cima de la pila.
- `top()`: Obtiene el elemento en la cima de la pila sin eliminarlo.

### Clase PostfixCalc

- `main(String[] args)`: Método principal que inicia la calculadora postfix.
- `calcular(String archivo)`: Método que realiza los cálculos de la expresión postfix.
- `leerTexto(String archivo)`: Método que lee el archivo de texto y extrae los elementos de la expresión postfix.
- `esDigito(char caracter)`: Método que verifica si un carácter es un dígito.

### Clase PilaTest

- `setUp()`: Método de configuración que se ejecuta antes de cada prueba para inicializar una nueva pila.
- `testIsEmpty()`: Prueba el método `isEmpty()` para verificar si la pila está vacía.
- `testPush()`: Prueba el método `push()` al insertar un elemento en la pila.
- `testPop()`: Prueba el método `pop()` al eliminar el elemento de la cima de la pila.
- `testTop()`: Prueba el método `top()` al obtener el elemento en la cima de la pila sin eliminarlo.

## Participantes

- Bryan Alberto Martínez Orellana (23542)
- Adriana Sophia Palacios Contreras (23044)

## Fechas

- Fecha de Creación: 28/01/2024
- Fecha de Última Modificacion: 31/01/2024


Participantes:
  - Bryan Alberto Martínez Orellana (23542)
  - Adriana Sophia Palacios Contreras (23044)
