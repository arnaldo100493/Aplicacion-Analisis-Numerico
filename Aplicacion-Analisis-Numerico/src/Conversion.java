
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Darwin
 */
public class Conversion {

    public Conversion() {

    }

    public String conversion(String bO, String bC, String nC) {
        String mensaje = null;

        try {
            int x = Integer.parseInt(bO);// almacena el valor de la base original del numero ingresado

            String numero = nC;// almacena el valor del numero a covertir
            String numerosComoArray[] = numero.split(" ");

            int a[] = new int[numerosComoArray.length];
            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(numerosComoArray[i]);//convierte el numero a convertir en un arreglo de enteros
            }

            int resultado = 0;//contador q almacena el valor del polinomio asosiado en el punto x para clacular el nuemro en base 10
            int k;
            for (k = 0; k < a.length - 1; k++) {
                resultado = resultado + a[k];
                resultado = resultado * x;
            }// fin de for
            resultado = resultado + a[k];
            int decimal = resultado;// almacena el valor del nuemro a convertir pero en base 10

            int m = Integer.parseInt(bC);// almacena el valor de la base a convetir

            mensaje = Integer.toString(decimal, m);// convierte el numero en base 10 a la base que se desea obtener el numero original
            mensaje = mensaje.toUpperCase();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error ingreso de datos");// si se produce el error imprime el mensaje "Error ingreso de datos"
        }
        return mensaje;
    }// fin del metodo conversion
}// finde la clase Conversion
