
import org.nfunk.jep.JEP;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Darwin
 */
public class DiferenciasRetrasadas {

    public DiferenciasRetrasadas() {

    }

    public String derivacionDe(String funcionRecibida, String x1, String h1) {
        // crea una nueva instancia de JEP con la configuraci´on por defecto
        String expresion = funcionRecibida;
        double fx2h, fx, fxh, x, h;
        String mensaje;

        try {

            // 
            JEP x2 = new JEP();
            x2.addStandardFunctions(); // adiciona las funciones matem´aticas
            x2.addStandardConstants();
            x2.parseExpression(x1); // paso de la expresi´on a evaluar
            x = x2.getValue();// almacena el valor del punto a evaluar

            h = Double.parseDouble(h1);// valor que tiende h

            JEP funcionx_h = new JEP();
            funcionx_h.addStandardFunctions(); // adiciona las funciones matem´aticas
            funcionx_h.addStandardConstants(); // adiciona las constantes matem´aticas
            funcionx_h.setImplicitMul(true);
            funcionx_h.addVariable("x", x + h);
            // obtener el resultado de evaluar la expresi´on
            funcionx_h.parseExpression(expresion); // paso de la expresi´on a evaluar
            fxh = funcionx_h.getValue();

            JEP funcion = new JEP();
            funcion.addStandardFunctions(); // adiciona las funciones matem´aticas
            funcion.addStandardConstants(); // adiciona las constantes matem´aticas
            funcion.setImplicitMul(true);
            funcion.addVariable("x", x);
            // obtener el resultado de evaluar la expresi´on
            funcion.parseExpression(expresion); // paso de la expresi´on a evaluar
            fx = funcion.getValue();

            JEP funcionx_2h = new JEP();
            funcionx_2h.addStandardFunctions(); // adiciona las funciones matem´aticas
            funcionx_2h.addStandardConstants(); // adiciona las constantes matem´aticas
            funcionx_2h.setImplicitMul(true);
            funcionx_2h.addVariable("x", x + (2 * h));// obtener el resultado de evaluar la expresi´on
            funcionx_2h.parseExpression(expresion); // paso de la expresi´on a evaluar
            fx2h = funcionx_2h.getValue();

            double derivada = ((4 * fxh) - fx2h - (3 * fx)) / (2 * h);

            mensaje = Double.toString(derivada);
        } catch (NumberFormatException e) {

            mensaje = "error ingreso datos";
        }

        return mensaje;
    }// fin metodo derivacionDerecha

}
