//Bryan Alberto Martínez Orellana 23542
//Adriana Sophia Palacios Contreras 23044
//Fecha de Creación: 28/01/2024
//Fecha de Última Modificacion: 30/01/2024
//Hoja de Trabajo 2 - Calculadora de Operaciones PostFix

import java.util.Vector;
import java.io.*;
import java.util.StringTokenizer;

public class PostfixCalc {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        //Mensaje de inicio al usuario
        System.out.println("-------------------------------------------");
        System.out.println("Hola querido usuario.\n" + "A continuación, estaremos calculando su operación ingresada.");
        System.out.println("-------------------------------------------");

        // Leemos el archivo y obtenemos un vector con los elementos
        int resultadoOperacion = calcular("datos.txt");
        //Mensaje Final
        System.out.println("***********************************************");
        System.out.println("--- El resultado de su operación es: " + resultadoOperacion + ". ---");
        System.out.println("***********************************************");
        System.out.println();

    }
    

    
    /** 
     * @param archivo
     * @return int
     */
    public static int calcular(String archivo){
        Vector<String> texto = leerTexto(archivo);
        //Se crean las variables ha implementar
        int resultado = 0;
        boolean operadorValido = true;
        int contadorDigitos = 0;
        int contadorOperandos = 0;

        // Inicializamos la pila
        Pila pila = new Pila(); 
        // Contamos la cantidad de dígitos y operandos
        for(String elemento: texto){
            for(char c: elemento.toCharArray()){
                if(esDigito(c)){
                    contadorDigitos++;
                } else{
                    contadorOperandos++;
                }
            }
        }
    // Verificamos si la cantidad de dígitos es uno más que la de operandos
        if(contadorDigitos - contadorOperandos == 1){
            for(String elemento: texto){
                //Verifica que no se encuentre un operador que no sea válido
                if(!operadorValido){
                    break;
                }
                //Se recorren todos los elementos una vez más para hacer las operaciones
                for(char caracter: elemento.toCharArray()){
                    //Si es un dígito lo pushea al Vector de la clase Pila
                    if(esDigito(caracter)){
                        pila.push(Integer.parseInt(String.valueOf(caracter)));
                    } else{ //De lo contrario, si se topa con una operador, llama a los 2 números de encima, y hace la operación
                        System.out.println("--------------------");
                        int val1 = pila.pop();
                        System.out.println("Primer valor tomado: " + val1);
                        int val2 = pila.pop();
                        System.out.println("Segundo valor tomado: " + val2);
                        System.out.println("Operacion a Hacer: " + caracter);
                        System.out.println("--------------------");
                        //Decide la operación correcta a emplear
                        if(caracter == '+'){
                            resultado = val2 + val1;
                            pila.push(resultado);
                        } else if(caracter == '-'){
                            resultado = val2 - val1;
                            pila.push(resultado);
                        } else if(caracter == '*'){
                            resultado = val2 * val1;
                            pila.push(resultado);
                        } else if(caracter == '/'){
                            //Validación para división por 0
                            if(val1 == 0){
                                System.out.println("Se reemplazará el 0 por un 1, ya que no se puede dividir por 0.");
                                val1 = 1;
                            }
                            resultado = val2/val1;
                            pila.push(resultado);
                        } else{ //Validación si se encuentra un signo no válido
                            System.out.println("Ha ingresado un operador no válido :(");
                            System.out.println("Se procederá a darle el resultado actual, revise su expresión.");
                            operadorValido = false;
                        }
                        System.out.println("RESULTADO: " + resultado);
                        System.out.println("--------------------");
                        System.out.println();
                    }
                }
            }
        } else{
            System.out.println("No se cuenta con la cantidad adecuada de dígitos u operadores.");
        }
        return resultado;
    }
    /** 
     * @param archivo
     * @return Vector<String>
     */
    //Método para extraer los elementos de la primera línea
    public static Vector<String> leerTexto(String archivo){
        Vector<String> texto = new Vector<String>();
        //Se intenta leer el archivo
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            String linea;
            //Se empieza a leer cada una de las líneas
            while((linea = br.readLine()) != null){
                //Dividir el String de manera separada
                StringTokenizer st = new StringTokenizer(linea);
                while(st.hasMoreTokens()){
                    //Guardar cada elemento en el vector
                    texto.add(st.nextToken());
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return texto;
    }

    
    /** 
     * @param caracter
     * @return boolean
     */
    // Método para verificar si un carácter es un dígito
    public static boolean esDigito(char caracter) {
        return Character.isDigit(caracter);
    }

}

