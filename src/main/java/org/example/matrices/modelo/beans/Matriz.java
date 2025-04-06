package org.example.matrices.modelo.beans;

import java.util.Arrays;

public class Matriz {
    private final int filas;
    private final int columnas;

    private final Double[][] matriz;


    public Matriz(Double[][] matriz) {
        this.matriz = matriz;

        this.filas = matriz.length;
        this.columnas = matriz[0].length;
    }

    public int getFilas() {
        return filas;
    }
    public int getColumnas() {
        return columnas;
    }
    public Double[][] getMatriz() {
        return matriz;
    }
    public Double obtenerElemento(int x, int y) {
        return matriz[x][y];
    }

    public Double[] obtenerFila(int fila) {
        return matriz[fila];
    }

    public Double[] obtenerColumna(int columna) {
        // es necesario aquí manejar errores?
        Double[] valoresColumna = new Double[this.filas];

        for (int i = 0; i < this.filas; i++) {
            valoresColumna[i] = matriz[i][columna];
        }

        return valoresColumna;
    }

    /**
     * Convierte en 0 todos los elementos de la matriz
     */
    public void limpiarMatriz() {
        for (int x = 0; x < this.filas; x++) {
            for (int y = 0; y < this.columnas; y++) {
                this.matriz[x][y] = 0.0;
            }
        }
    }


    public static Matriz matrizIdentidad (int tamanno) {
        Double[][] matrizIdentidad = new Double[tamanno][tamanno];

        for (int x = 0; x < tamanno; x++) {
            for (int y = 0; y < tamanno; y++) {
                if (x == y) {
                    matrizIdentidad[x][y] = 1.0;
                }
                else {
                    matrizIdentidad[x][y] = 0.0;
                }
            }
        }

        return new Matriz(matrizIdentidad);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Matriz otra = (Matriz) obj;
        return Arrays.deepEquals(this.matriz, otra.matriz);
    }

    @Override
    public int hashCode() {
        return this.matriz.hashCode();
    }



}