/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Darwin
 */
public class Lectura {

    public Lectura() {

    }

    public void generarMatriz(String m1, String n1, String ruta) throws FileNotFoundException {

        Scanner leer;
        int matrizA[][];
        int matrizB[][];
        int matrizC[][];
        int n, m, o, p;

        try {
            leer = new Scanner(new File(ruta));

            m = Integer.parseInt(m1);

            n = Integer.parseInt(n1);

            /**
             * el bucle while compara que las dimensiones de las matrices sean
             * compatibles para realizar la multiplicacion, Caso contrario
             * vuelve a pedir las dimensiones
             */
            if (m <= 0 || n <= 0) {
                JOptionPane.showMessageDialog(null, " Dimensiones no compatibles ");
            } else {

                //System.out.println("************MAtriz A************");
                matrizA = new int[m][n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        matrizA[i][j] = leer.nextInt();

                    }

                }

                //System.out.println("************MAtriz B************");
                matrizB = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        matrizB[i][j] = matrizA[j][i];
                    }
                }

                JTextArea areaSalida1 = new JTextArea();
                areaSalida1.setText("     matriza A \n");

                for (int i = 0; i < m; i++) {
                    for (int k = 0; k < n; k++) {
                        areaSalida1.append(matrizA[i][k] + "\t");
                    }
                    areaSalida1.append("\n");

                }

                areaSalida1.append("\n     Matriz B\n");

                for (int i = 0; i < n; i++) {
                    for (int k = 0; k < m; k++) {
                        areaSalida1.append(matrizB[i][k] + "\t");
                    }
                    areaSalida1.append("\n");

                }

                areaSalida1.append("\n     Matriz AB\n");

                JOptionPane.showMessageDialog(null, areaSalida1);

            }// fin else

        }//fin try
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, " Error ingreso de datos ");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, " Archivo no encontrado ");
        } catch (NegativeArraySizeException e) {
            JOptionPane.showMessageDialog(null, " ha ingresado dimensiones negativas ");
        } catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(null, " error lectura del archivo ");
        }

    }// fin metodo generar matriz

}// fin de la clase

