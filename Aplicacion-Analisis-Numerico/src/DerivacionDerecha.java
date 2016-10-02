/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.nfunk.jep.*;

/**
 *
 * @author Darwin
 */
public class DerivacionDerecha {

    public DerivacionDerecha() {

    }

    public String derivacionDerecha(String funcionRecibida, String x1, String h1) {
        // crea una nueva instancia de JEP con la configuraci´on por defecto
        String expresion = funcionRecibida;
        double fx, fxh, x, h = 0;
        String mensaje;

        try {

            // 
            JEP x2 = new JEP();
            x2.addStandardFunctions(); // adiciona las funciones matem´aticas
            x2.addStandardConstants();
            x2.parseExpression(x1); // paso de la expresi´on a evaluar
            x = x2.getValue();

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
            double derivada = (fxh - fx) / h;

            mensaje = Double.toString(derivada);
        } catch (NumberFormatException e) {

            mensaje = "error ingreso datos";
        }

        return mensaje;
    }// fin metodo derivacionDerecha

}
