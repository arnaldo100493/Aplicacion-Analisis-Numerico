
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
public class EsquemaDeHorner {

    public EsquemaDeHorner() {

    }

    public void horner(String px, String x1) {
        String mensaje = null;
        try {
            int grado = Integer.parseInt(px);
            double x = Double.parseDouble(x1);

            double polinomio[] = new double[grado + 1];// almacena los coeficientes del polinomio
            double k = 0;// almacena el valor del polinomio en el punto x
            for (int i = grado; i >= 0; i--) {
                polinomio[i] = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese coeficiente x^" + i + "  : "));// ingreso de coeficientes de polinomio
            }

            // 
            for (int i = grado; i >= 1; i--) {// evalua el polinomio en el punto dado segun el esquema de horner
                k = k + polinomio[i];
                k = k * x;
            }// fin for
            k = k + polinomio[0];// fin evaluar polinomio en el punto dado segun el esquema de horner

            mensaje = Double.toString(k);// muestra k como un String

            // muestra el polinomio ingresado y el valor del polinomio en el punto dado
            JTextArea areaSalida1 = new JTextArea();
            areaSalida1.setText("\nP(X)= ");

            for (int i = grado; i > 0; i--) {
                String mas = "+";
                if (i == 1) {
                    mas = "";
                }

                areaSalida1.append(polinomio[i] + " x^" + i + "  " + mas + " ");

            }
            areaSalida1.append("+" + polinomio[0]);
            areaSalida1.append("\n\n");
            areaSalida1.append("P(" + x + ") =" + mensaje);

            JOptionPane.showMessageDialog(null, areaSalida1);
            // fin muestra polinomio   ingresado

        }// fin try
        catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, " error ingreso de datos");
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, " error ingreso de datos");
        }

    }// fin del metodo
}
