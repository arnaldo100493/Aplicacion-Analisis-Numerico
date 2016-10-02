/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author DESARROLLO
 */
public class BaseOrtogonal {

    public BaseOrtogonal() {

    }

    /**
     * @param args the command line arguments
     */
    /**
     * recuerde que para calcular una base ortogonal de dos vectores en R2 los
     * vectores ingresados no deben ser nulos y tampoco colineales dos vectores
     * son colineales si su determinate es cero
     *
     * @param v1
     * @param v2
     * @throws IOException
     */
    public void baseOrtogonal(String v1, String v2) throws IOException {

        // TODO code application logic here 
        boolean regreso = true;
        String[] numerosComoArray1 = v1.split(",");// almacena la cadena ingresada en un arreglo ,  la "," sirve para indicar que se almacene en otra pocicion del arreglo
        String[] numerosComoArray2 = v2.split(",");// almacena la cadena ingresada en un arreglo ,  la "," sirve para indicar que se almacene en otra pocicion del arreglo

        double arreglo1[] = new double[2];
        double arreglo2[] = new double[2];

        try {
            for (int i = 0; i < arreglo1.length; i++) {
                arreglo1[i] = Double.parseDouble(numerosComoArray1[i]);// conviete el arreglo  numerosComoArray1 a un arreglo de doubles
            }
            for (int i = 0; i < arreglo1.length; i++) {
                arreglo2[i] = Double.parseDouble(numerosComoArray2[i]);// conviete el arreglo  numerosComoArray2 a un arreglo de doubles
            }

            double det = arreglo1[0] * arreglo2[1] - arreglo1[1] * arreglo2[0];// calcula el determinante de los vectores ingresados

            if (arreglo1[0] == 0 && arreglo1[1] == 0 || arreglo2[0] == 0 && arreglo2[1] == 0 || det == 0) {
                /**
                 * si uno de los vectoes ingresados es nulo o los vectores son
                 * colineales se muestra el mensaje " uno de los vectores es
                 * nulo o \n los vectores son colineales "
                 */
                JOptionPane.showMessageDialog(null, " uno de los vectores es nulo o \n los vectores son colineales ");
                regreso = false;
            }

            if (numerosComoArray1.length != 2 || numerosComoArray2.length != 2) {
                /*
             * si el tamaño de los vectores no son el mismo  se muestra el mensaje
             * " los vectores no son del mismo tamaño "
                 */
                JOptionPane.showMessageDialog(null, " los vectores no son del mismo tamaño ");
                regreso = false;// no se calcula la bese ortogonal
            }

            if (regreso) {
                double x_y = 0; // alamacena el producto punto entre  el vector1 y el vector2
                for (int i = 0; i < arreglo1.length; i++) {
                    x_y = x_y + (arreglo1[i] * arreglo2[i]);// calcula el producto punto entre  el vector1 y el vector2
                }// fin for

                double yy = 0;// almacena el producto punto entre  el vector1 y el vector1
                for (int i = 0; i < arreglo1.length; i++) {
                    yy = yy + (arreglo1[i] * arreglo1[i]);//calcula el producto punto entre  el vector1 y el vector1

                }// fin for

                double xx = 0;// almacena el producto punto entre  el vector2 y el vector2
                for (int i = 0; i < arreglo1.length; i++) {
                    xx = xx + (arreglo2[i] * arreglo2[i]);//calcula el producto punto entre  el vector2 y el vector2

                }// fin for

                double angulo = Math.acos(x_y / (Math.sqrt(xx) * Math.sqrt(yy)));//calcula el angulo entre los vecores ingresados
                angulo = Math.toDegrees(angulo);// convierte el angulo de radianes a grados

                double landa = x_y / yy;
                // alamcena el valor de la division de el producto punto con el vector1 y el vector 2
                // con el producto punto con el vector1 y el vector 1
                double landay[] = new double[2];// almacena el valor del vector que reslta de
                // la multiplicacion del escalar landa por el vector 1
                for (int i = 0; i < landay.length; i++) {
                    landay[i] = landa * arreglo1[i];
                }

                double c[] = new double[2];
                for (int i = 0; i < c.length; i++) {
                    c[i] = arreglo2[i] - landay[i];// calcula el nuevo ector qu formara parte de la base ortogonal
                }

                /*
             * se imprime la base ortogonal
                 */
                JTextArea areaSalida = new JTextArea();
                areaSalida.setText("base Ortogonal= { ( ");
                for (int i = 0; i < c.length; i++) {
                    String coma = "";
                    if (i < c.length - 1) {
                        coma = "  ;  ";
                    }
                    areaSalida.append(arreglo1[i] + coma);
                }
                areaSalida.append(" );( ");

                for (int i = 0; i < c.length; i++) {
                    String coma = "";
                    if (i < c.length - 1) {
                        coma = "  ;  ";
                    }
                    areaSalida.append(c[i] + coma);
                }
                areaSalida.append(" ) }\n\nAngulo en grados entre v1 y v2 es \n  @ = " + angulo + " ");

                JOptionPane.showMessageDialog(null, areaSalida);

            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, " Error ingreso de Datos ");
            regreso = false;
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, " Error ingreso de Datos ");
            regreso = false;
        }

    }// fin del metodo baseOrtogonal

}// fin de la clase BaseOrtogonal
