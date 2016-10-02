/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Darwin
 */
public class LecturaArchivos {

    public LecturaArchivos() {

    }

    public void generarMatriz(String m1, String n1, String o1, String p1, String ruta) throws FileNotFoundException, IOException {
        Scanner leer;
        int matrizA[][];
        int matrizB[][];
        int matrizC[][];
        int n, m, o, p;

        try {
            leer = new Scanner(new File(ruta));

            m = Integer.parseInt(m1);

            n = Integer.parseInt(n1);

            o = Integer.parseInt(o1);

            p = Integer.parseInt(p1);

            /**
             * el bucle while compara que las dimensiones de las matrices sean
             * compatibles para realizar la multiplicacion, Caso contrario
             * vuelve a pedir las dimensiones
             */
            if (m <= 0 || n <= 0 || o <= 0 || p <= 0 || n != o) {
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
                matrizB = new int[o][p];
                for (int i = 0; i < o; i++) {
                    for (int j = 0; j < p; j++) {
                        matrizB[i][j] = leer.nextInt();
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

                for (int i = 0; i < o; i++) {
                    for (int k = 0; k < p; k++) {
                        areaSalida1.append(matrizB[i][k] + "\t");
                    }
                    areaSalida1.append("\n");

                }

                areaSalida1.append("\n     Matriz AB\n");

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < p; j++) {
                        double s = 0;// acumulador para la posicion de AB
                        for (int k = 0; k < n; k++) {
                            s = s + matrizA[i][k] * matrizB[k][j];

                        }

                        areaSalida1.append("  " + s + "\t");
                    }
                    areaSalida1.append("\n");
                }
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

    }
}
