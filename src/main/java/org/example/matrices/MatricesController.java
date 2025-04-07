package org.example.matrices;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.matrices.modelo.procesos.Calculadora;
import org.example.matrices.modelo.procesos.ProcesarDatos;

import java.io.IOException;
import java.util.ArrayList;

public class MatricesController {
    // Matriz 1:
    // 3x3 donde m1_x_y

    @FXML
    private TextField m1_0_0;

    @FXML
    private TextField m1_0_1;

    @FXML
    private TextField m1_0_2;


    @FXML
    private TextField m1_1_0;

    @FXML
    private TextField m1_1_1;

    @FXML
    private TextField m1_1_2;


    @FXML
    private TextField m1_2_0;

    @FXML
    private TextField m1_2_1;

    @FXML
    private TextField m1_2_2;



    // Matriz 2:
    // 3x3 donde m2_x_y

    @FXML
    private TextField m2_0_0;

    @FXML
    private TextField m2_0_1;

    @FXML
    private TextField m2_0_2;


    @FXML
    private TextField m2_1_0;

    @FXML
    private TextField m2_1_1;

    @FXML
    private TextField m2_1_2;


    @FXML
    private TextField m2_2_0;

    @FXML
    private TextField m2_2_1;

    @FXML
    private TextField m2_2_2;


    // Matriz Resultado:
    // 3x3 donde mR_x_y

    @FXML
    private TextField mR_0_0;

    @FXML
    private TextField mR_0_1;

    @FXML
    private TextField mR_0_2;


    @FXML
    private TextField mR_1_0;

    @FXML
    private TextField mR_1_1;

    @FXML
    private TextField mR_1_2;


    @FXML
    private TextField mR_2_0;

    @FXML
    private TextField mR_2_1;

    @FXML
    private TextField mR_2_2;





    @FXML
    private Label mensaje;

    //
    private Calculadora calculadora = new Calculadora();
    private ProcesarDatos procesarDatos = new ProcesarDatos();


    // Botones
    @FXML
    public void Analizar() {
        try {
            TextField[][] matriz1 = obtenerMatriz("1");
            TextField[][] matriz2 = obtenerMatriz("2");

            if (
                    calculadora.comprobarSiEsInversa(
                            procesarDatos.validarMatriz(matriz1),
                            procesarDatos.validarMatriz(matriz2)
                    )
            )
            {
                mensaje.setText("Es identidad");
            } else {
                mensaje.setText("No es identidad");
            }
        } catch (IllegalArgumentException iae) {
            mensaje.setText(iae.getMessage());
        }

    }

    @FXML
    public void Sumar() {
        try {
            TextField[][] matriz1 = obtenerMatriz("1");
            TextField[][] matriz2 = obtenerMatriz("2");


            TextField[][] matrizRespuesta =
            procesarDatos.obtenerMatrizDeTextFields(
                    calculadora.sumar(
                            procesarDatos.validarMatriz(matriz1),
                            procesarDatos.validarMatriz(matriz2)
                    )
            );


            imprimirMatrizResultado(matrizRespuesta);

        } catch (IllegalArgumentException iae) {
            mensaje.setText(iae.getMessage());
        }
    }

    @FXML
    public void Multiplicar() {
        try {
            TextField[][] matriz1 =  obtenerMatriz("1");
            TextField[][] matriz2 =  obtenerMatriz("2");

            TextField[][] matrizRespuesta =
                    procesarDatos.obtenerMatrizDeTextFields(
                            calculadora.multiplicar(
                                    procesarDatos.validarMatriz(matriz1),
                                    procesarDatos.validarMatriz(matriz2)
                            )
                    );

            imprimirMatrizResultado(matrizRespuesta);
        } catch (IllegalArgumentException iae) {
            mensaje.setText(iae.getMessage());
        }
    }

    @FXML
    public void Limpiar() {
        TextField[][] matriz1 =  obtenerMatriz("1");
        TextField[][] matriz2 =  obtenerMatriz("2");
        TextField[][] matrizResultado =  obtenerMatriz("Resultado");

        for (int x = 0; x < matrizResultado.length; x++) {
            for (int y = 0; y < matrizResultado[0].length; y++) {
                // Limpiamos todos los campos de las matrices
                matrizResultado[x][y].setText("");
                matriz1[x][y].setText("");
                matriz2[x][y].setText("");

            }
        }

    }

    private void imprimirMatrizResultado(TextField[][] matriz) {
        TextField[][] matrizResultado =  obtenerMatriz("Resultado");

        for (int x = 0; x < matrizResultado.length; x++) {
            for (int y = 0; y < matrizResultado[0].length; y++) {
                matrizResultado[x][y].setText(matriz[x][y].getText());
            }
        }

    }

    private TextField[][] obtenerMatriz(String matriz) throws IllegalArgumentException {
        switch (matriz) {
            case "1":
                return new TextField[][] {
                    {m1_0_0, m1_0_1, m1_0_2},
                    {m1_1_0, m1_1_1, m1_1_2},
                    {m1_2_0, m1_2_1, m1_2_2}
                };

            case "2":
                return new TextField[][] {
                        {m2_0_0, m2_0_1, m2_0_2},
                        {m2_1_0, m2_1_1, m2_1_2},
                        {m2_2_0, m2_2_1, m2_2_2}
                };

            case "Resultado":
                return new TextField[][] {
                        {mR_0_0, mR_0_1, mR_0_2},
                        {mR_1_0, mR_1_1, mR_1_2},
                        {mR_2_0, mR_2_1, mR_2_2}
                };

            default:
                throw new IllegalArgumentException("La matriz no existe");
        }
    }

}