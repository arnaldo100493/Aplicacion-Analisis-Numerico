
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Darwin
 */
public class SumaVectores {

    public SumaVectores() {

    }

    public void sumaVectores(String vector1, String vector2) {
        String[] numerosComoArray1 = vector1.split(",");//recibe la primera cadena de caracteres y a almacena en un arreglo
        double a[] = new double[numerosComoArray1.length];
        boolean regreso = true;

        String[] numerosComoArray2 = vector2.split(",");
        double b[] = new double[numerosComoArray2.length];

        double v1_v2[] = new double[a.length];
        try {// si los datos ingresados no son numeros el arreglo toma el valor por defecto
            for (int i = 0; i < a.length; i++) {
                a[i] = Double.parseDouble(numerosComoArray1[i]);
            }
            for (int i = 0; i < b.length || i < a.length; i++) {
                b[i] = Double.parseDouble(numerosComoArray2[i]);
            }
            for (int i = 0; i < b.length; i++) {
                v1_v2[i] = b[i] + a[i];
            }
            String s[] = new String[a.length];
            for (int i = 0; i < a.length; i++) {
                s[i] = Double.toString(v1_v2[i]);
            }
            JTextArea areaSalida = new JTextArea();
            areaSalida.setText("v1+v2=( ");
            for (int i = 0; i < v1_v2.length; i++) {
                String coma = "";
                if (i < v1_v2.length - 1) {
                    coma = "  ;  ";
                }
                areaSalida.append(v1_v2[i] + coma);
            }
            areaSalida.append(" )");
            JOptionPane.showMessageDialog(null, areaSalida);

        }// fin try
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "error en el ingreso de datos ");

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "error en el ingreso de datos ");

        }

    }// fin metodo sumaVectores

    public void escalar(String vector1, String escalar) {
        String[] numerosComoArray1 = vector1.split(",");
        double a[] = new double[numerosComoArray1.length];
        boolean regreso = true;
        double n = 0;
        try {
            n = Double.parseDouble(escalar);
            for (int i = 0; i < a.length; i++) {
                a[i] = Double.parseDouble(numerosComoArray1[i]);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "error ingreso de datos");
            regreso = false;
        }

        if (regreso) {

            double v1_[] = new double[a.length];

            for (int i = 0; i < v1_.length; i++) {

                v1_[i] = n * a[i];

            }

            String s1[] = new String[a.length];
            for (int i = 0; i < a.length; i++) {
                s1[i] = Double.toString(v1_[i]);
            }
            JTextArea areaSalida1 = new JTextArea();
            areaSalida1.setText("Escalar*v1=( ");
            for (int i = 0; i < a.length; i++) {
                String coma = "";
                if (i < a.length - 1) {
                    coma = "  ;  ";
                }
                areaSalida1.append(s1[i] + coma);
            }
            areaSalida1.append(" )");
            JOptionPane.showMessageDialog(null, areaSalida1);

        }

    }// fin metodo escalar

}
