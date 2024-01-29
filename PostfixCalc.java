import java.util.Vector;
import java.io.*;
import java.util.StringTokenizer;

public class PostfixCalc {
    public static void main(String[] args){
        System.out.println("-------------------------------------------");
        System.out.println("Hola querido usuario.\n" + "A continuación, estaremos calculando su operación ingresada.");
        System.out.println("-------------------------------------------");
        int resultado = 0;
        boolean valido1 = false;
        boolean valido2 = false;
        boolean operadorValido = true;
        int contadorDigitos = 0;
        int contadorOperandos = 0;
        Vector<String> texto = leerTexto("datos.txt");
        Pila pila = new Pila(); 
        for(String elemento: texto){
            for(char c: elemento.toCharArray()){
                if(esDigito(c)){
                    contadorDigitos++;
                } else{
                    contadorOperandos++;
                }
            }
        }
        if(contadorDigitos - contadorOperandos == 1){
            for(String elemento: texto){
                if(!operadorValido){
                    break;
                }
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
