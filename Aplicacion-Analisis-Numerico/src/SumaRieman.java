
import org.nfunk.jep.JEP;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Darwin
 */
public class SumaRieman {

    public SumaRieman() {

    }

    public String sumasDeRieman(String funcion1, String a1, String b1, String n1) {
        String mensaje;

        try {
            String expresion = funcion1;

            JEP a2 = new JEP();
            a2.addStandardFunctions(); // adiciona las funciones matem´aticas
            a2.addStandardConstants();// adiciona las constantes matematicas como  e , pi
            a2.parseExpression(a1); // paso de la expresi´on a evaluar
            double a = a2.getValue(); //[a,b] almacena el valor del limite inferior a

            JEP b2 = new JEP();
            b2.addStandardFunctions(); // adiciona las funciones matem´aticas
            b2.addStandardConstants();// adiciona las constantes matematicas como  e , pi
            b2.parseExpression(b1); // paso de la expresi´on a evaluar
            double b = b2.getValue();//[a,b] almacena el valor del limite superior b

            double n = Double.parseDouble(n1);// numero de particiones
            double h = (b - a) / n;
            int m = (int) n;

            double x[] = new double[m + 1];
            x[0] = a;
            for (int i = 1; i < x.length; i++) {

                x[i] = x[0] + (i * h);// calcula el termino Xi
            }

            JEP funcion = new JEP();
            funcion.addStandardFunctions(); // adiciona las funciones matem´aticas
            funcion.addStandardConstants(); // adiciona las constantes matem´aticas e , pi, etc.
            funcion.setImplicitMul(true);

            double fi[] = new double[m + 1];
            /**
             * calcula el valor de el polinomio en el punto Xi
             */
            for (int i = m; i >= 0; i--) {

                for (int j = fi.length - 1; j > 0; j--) {
                    fi[i] = funcion.addVariable("x", x[i]);
                    funcion.parseExpression(expresion); // paso de la expresi´on a evaluar
                    fi[i] = funcion.getValue();
                }

            }

            double integral = 0;
            for (int i = 0; i < fi.length; i++) {
                integral = integral + fi[i];
            }
            integral = h * integral;
            mensaje = Double.toString(integral);
        } catch (NumberFormatException e) {
            mensaje = "error ingreso de datos";
        }

        return mensaje;
    }
}
