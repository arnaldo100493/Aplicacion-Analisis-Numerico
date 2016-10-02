
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Darwin
 */
public class Norma {

    public Norma() {

    }

    public void calcula_norma(String vector1) {
        double norma = 0; // almacena el   vlor de la norma del vector 

        String[] numerosComoArray1 = vector1.split(",");// almacena el vector ingresado en un arreglo de strings
        double a[] = new double[numerosComoArray1.length];//almacena el vector ingresado en un arreglo de doubles

        try {
            for (int i = 0; i < a.length; i++) {
                a[i] = Integer.parseInt(numerosComoArray1[i]);// conviete el arreglo de Strings a un arreglo de doubles

            }
            for (int i = 0; i < a.length; i++) {
                norma = norma + (a[i] * a[i]);// calcula la norma del vector ingresado

            }
            norma = Math.sqrt(norma);

            String norma_ = Double.toString(norma);// interpreta la norma del vector como un String
            JOptionPane.showMessageDialog(null, "norma=" + norma_);// muestra el valor de la norma del vector
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, " Error ingreso de datos ");
        }

    }// fin del metodo calcula_orma

}// fin de la clase Norma

