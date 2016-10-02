/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;

/**
 *
 * @author FAMILY
 */
public class ProductoPuntoDeDosVectores {

    public ProductoPuntoDeDosVectores() {

    }

    public void productoPunto(String vector1, String vector2) {
        String[] numerosComoArray1 = vector1.split(",");// almacena la cadena ingresada en un arreglo ,  la "," sirve para indicar que se almacene en otra pocicion del arreglo
        double a[] = new double[numerosComoArray1.length];// arreglo que almacenara el primer vector

        String[] numerosComoArray2 = vector2.split(",");
        double b[] = new double[numerosComoArray2.length];
        try {// si los datos ingresados no son numeros el arreglo toma el valor por defecto
            for (int i = 0; i < a.length; i++) {
                a[i] = Double.parseDouble(numerosComoArray1[i]);// convierte el arrelo numerosComoArray1  a un arreglo de doubles
            }
            for (int i = 0; i < b.length; i++) {
                b[i] = Double.parseDouble(numerosComoArray2[i]);// convierte el arrelo numerosComoArray2  a un arreglo de doubles
            }

            double p = 0;// contador para alacenar el valor del producto punto

            for (int i = 0; i < b.length || i < a.length; i++) {
                p = p + (a[i] * b[i]);// calcula el producto punto entre los vectores v1 y v2

            }// fin for
            JOptionPane.showMessageDialog(null, "Producto Punto=" + p);// muestra en la pantalla el valor del producto punto
        }// fin try
        catch (Exception e) {// se ejecuta el buble catch si se produce algun error en el ingreso de dstos  o en calcular el producto punto
            JOptionPane.showMessageDialog(null, "error en el ingreso de datos ");
        }

    }// fin metodo sumaVectores

}
