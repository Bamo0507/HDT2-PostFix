import java.util.Vector;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PostfixCalc {
    public static void main(String[] args){
        System.out.println("Hola querido usuario.\n" + "A continuación, estaremos calculando su operación ingresada.");
        int resultado = 0;
        boolean valido1 = false;
        boolean valido2 = false;
        Vector<String> texto = leerTexto("datos.txt");
        Pila pila = new Pila(); 
        for(String elemento: texto){
            for(char caracter: elemento.toCharArray()){
                if(esDigito(caracter)){
                    pila.push(Integer.parseInt(String.valueOf(caracter)));
                } else{
                    System.out.println("--------------------");
                    int val1 = pila.pop();
                    System.out.println("Primer valor tomado: " + val1);
                    int val2 = pila.pop();
                    System.out.println("Segundo valor tomado: " + val2);
                    System.out.println("Operacion a Hacer: " + caracter);
                    System.out.println("--------------------");
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
                        if(val1 == 0){
                            System.out.println("Se reemplazará el 0 por un 1, ya que no se puede dividir por 0.");
                            val1 = 1;
                        }
                        resultado = val2/val1;
                        pila.push(resultado);
                    } else{
                        System.out.println("Ha ingresado un operador no válido :(");
                        System.out.println("Se omitirá esta operación.");
                    }
                    System.out.println("RESULTADO: " + resultado);
                    System.out.println("--------------------");
                    System.out.println();
                }
            }
        }
        System.out.println("***********************************************");
        System.out.println("--- El resultado de su operación es: " + resultado + ". ---");
        System.out.println("***********************************************");
        System.out.println();

    }
    
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

    // Método para verificar si un carácter es un dígito
    public static boolean esDigito(char caracter) {
        return Character.isDigit(caracter);
    }

}
