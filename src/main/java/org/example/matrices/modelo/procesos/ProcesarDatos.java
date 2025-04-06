package org.example.matrices.modelo.procesos;

import javafx.scene.control.TextField;
import org.example.matrices.modelo.beans.Matriz;

public class ProcesarDatos {
    public Matriz validarMatriz(TextField[][] matriz) throws IllegalArgumentException {
        Double[][] nuevaMatriz = new Double[matriz.length][matriz[0].length];

        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[0].length; y++) {
                try {
                    nuevaMatriz[x][y] =
                            Double.parseDouble(
                            matriz[x][y].getText()
                    );

                } catch (NumberFormatException nfe) {
                    throw new IllegalArgumentException("No has ingresado todos los valores");
                } catch (NullPointerException npe) {
                    throw new IllegalArgumentException("No has puesto valores en todos los campos");
                }
            }
        }

        return new Matriz(nuevaMatriz);
    }

    public TextField[][] obtenerMatrizDeTextFields(Matriz matriz) {
        TextField[][] matrizDeTextFields = new TextField[matriz.getFilas()][matriz.getColumnas()];

        for (int x = 0; x < matriz.getFilas(); x++) {
            for (int y = 0; y < matriz.getColumnas(); y++) {
                matrizDeTextFields[x][y] = new TextField(String.valueOf(matriz.obtenerElemento(x,y)));
            }
        }

        return matrizDeTextFields;
    }
}
