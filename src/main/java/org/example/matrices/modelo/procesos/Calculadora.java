package org.example.matrices.modelo.procesos;

import org.example.matrices.modelo.beans.Matriz;

public class Calculadora {
    public Matriz sumar(Matriz matriz1, Matriz matriz2) throws IllegalArgumentException {
        // Validamos que las dos matrices tengan las mismas dimensiones
        if (matriz1.getFilas() != matriz2.getFilas() || matriz1.getColumnas() != matriz2.getColumnas()) {
            throw new IllegalArgumentException("Las matrices tienen distinta dimensión");
        }

        Double[][] matrizResultado = new Double[matriz1.getFilas()][matriz1.getColumnas()];

        for (int x = 0; x < matriz1.getFilas(); x++) {
            for (int y = 0; y < matriz1.getColumnas(); y++) {
                matrizResultado[x][y] = matriz1.obtenerElemento(x, y) + matriz2.obtenerElemento(x, y);
            }
        }

        return new Matriz(matrizResultado);
    }

    public Matriz multiplicar(Matriz matriz1, Matriz matriz2) throws IllegalArgumentException{
        if (matriz1.getColumnas() != matriz2.getFilas()) {
            throw new IllegalArgumentException("Las matrices no se pueden multiplicar por sus dimensiones");
        }

        Double[][] matrizResultado = new Double[matriz1.getFilas()][matriz2.getColumnas()];

        Double[] filaActual = new Double[matriz1.getFilas()];
        Double[] columnaActual  = new Double[matriz1.getColumnas()];
        Double elementoActual;

        for (int x = 0; x < matriz1.getFilas(); x++) {
            for (int y = 0; y < matriz2.getColumnas(); y++) {
                filaActual = matriz1.obtenerFila(x);
                columnaActual = matriz2.obtenerColumna(y);
                elementoActual = 0.0;

                for (int i = 0; i < filaActual.length; i++) {
                    elementoActual += filaActual[i] * columnaActual[i];
                }

                // Double necesita redondearse porque si no da problemas
                matrizResultado[x][y] = Math.round(elementoActual * 1000.0) / 1000.0;

            }
        }

        return new Matriz(matrizResultado);
    }

    public boolean comprobarSiEsInversa(Matriz matriz1, Matriz matriz2){
        if (
                multiplicar(matriz1, matriz2)
                        .equals(Matriz.matrizIdentidad(matriz1.getColumnas()))
        ) {
            return true;
        }
        return false;
    }


}
