
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Darwin Morocho
 */
public class SumaMatrices {

    public SumaMatrices() {

    }

    public void sumar_matrices(String m1, String n1, String ruta) throws FileNotFoundException {
        Scanner leer;
        int matrizA[][];
        int matrizB[][];
        int matrizC[][];
        int n, m;
        try {
            leer = new Scanner(new File(ruta));
            m = Integer.parseInt(m1);
            n = Integer.parseInt(n1);
            matrizA = new int[m][n];
            matrizB = new int[m][n];

            //System.out.println("************MAtriz A************");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrizA[i][j] = leer.nextInt();

                }

            }// fin for

            //System.out.println("************MAtriz B************");
            matrizB = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrizB[i][j] = leer.nextInt();
                }
            }

            //System.out.println("************MAtriz B************");
            matrizC = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrizC[i][j] = matrizA[i][j] + matrizB[i][j];
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

            for (int i = 0; i < m; i++) {
                for (int k = 0; k < n; k++) {
                    areaSalida1.append(matrizB[i][k] + "\t");
                }
                areaSalida1.append("\n");

            }

            areaSalida1.append("\n     Matriz (A+B)\n");

            for (int i = 0; i < m; i++) {
                for (int k = 0; k < n; k++) {
                    areaSalida1.append(matrizC[i][k] + "\t");
                }
                areaSalida1.append("\n");

            }

            JOptionPane.showMessageDialog(null, areaSalida1);

        }// fin tryNoSuchElementException
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, " error ingreso de datos ");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, " archivo no encontrado ");
        } catch (NegativeArraySizeException e) {
            JOptionPane.showMessageDialog(null, " ha ingresado dimensiones negativas ");
        } catch (NoSuchElementException e) {
            JOptionPane.showMessageDialog(null, " error lectura del archivo ");
        }

    }// fin metodo sumar_matrices
}
