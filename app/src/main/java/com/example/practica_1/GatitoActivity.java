package com.example.practica_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class GatitoActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView ImageView1;
    ImageView ImageView2;
    ImageView ImageView3;
    ImageView ImageView4;
    ImageView ImageView5;
    ImageView ImageView6;
    ImageView ImageView7;
    ImageView ImageView8;
    ImageView ImageView9;
    int partidasJugadas = 0;
    int[][] matrizGanadora = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9},
            {1, 5, 9},
            {3, 5, 7}
    };

    int[] posicionesX = new int[5];
    int[] posicionesO = new int[5];
    int contadorX = 0;
    int contadorO = 0;

    private int contadorVictoriasX = 0;
    private int contadorVictoriasO = 0;
    private TextView textViewX;
    private TextView textViewO;



    String turno = "x";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gatito);

        ImageView1 = findViewById(R.id.imageView1);
        ImageView2 = findViewById(R.id.imageView2);
        ImageView3 = findViewById(R.id.imageView3);
        ImageView4 = findViewById(R.id.imageView4);
        ImageView5 = findViewById(R.id.imageView5);
        ImageView6 = findViewById(R.id.imageView6);
        ImageView7 = findViewById(R.id.imageView7);
        ImageView8 = findViewById(R.id.imageView8);
        ImageView9 = findViewById(R.id.imageView9);

        textViewX = findViewById(R.id.textViewX);
        textViewO = findViewById(R.id.textViewO);

        ImageView1.setOnClickListener(this);
        ImageView2.setOnClickListener(this);
        ImageView3.setOnClickListener(this);
        ImageView4.setOnClickListener(this);
        ImageView5.setOnClickListener(this);
        ImageView6.setOnClickListener(this);
        ImageView7.setOnClickListener(this);
        ImageView8.setOnClickListener(this);
        ImageView9.setOnClickListener(this);

        actualizarContadores();
    }

    @Override
    public void onClick(View view) {
        int posicion = obtenerPosicion(view);

        if (posicionOcupada(posicion)) {
            return;
        }

        if (turno.equals("x")) {
            ((ImageView) view).setImageResource(R.drawable.descarga);
            posicionesX[contadorX] = posicion;
            contadorX++;
            turno = "o";
        } else {
            ((ImageView) view).setImageResource(R.drawable.letra0);
            posicionesO[contadorO] = posicion;
            contadorO++;
            turno = "x";
        }
        view.setEnabled(false);
        partidasJugadas++;
        if (hayGanador()) {
            // Actualiza los contadores de victorias según el ganador
            if (turno.equals("x")) {
            } else {

            }

            Toast.makeText(this, "¡Jugador " + turno + " ha ganado!", Toast.LENGTH_SHORT).show();
            actualizarContadores();

            reiniciarTablero();
        } else if (partidasJugadas == 9) {
            Toast.makeText(this, "¡Empate!", Toast.LENGTH_SHORT).show();
            actualizarContadores();
            reiniciarTablero();
        }

    }

    private int obtenerPosicion(View view) {
        int id = view.getId();
        if (id == R.id.imageView1) {
            return 1;
        } else if (id == R.id.imageView2) {
            return 2;
        } else if (id == R.id.imageView3) {
            return 3;
        } else if (id == R.id.imageView4) {
            return 4;
        } else if (id == R.id.imageView5) {
            return 5;
        } else if (id == R.id.imageView6) {
            return 6;
        } else if (id == R.id.imageView7) {
            return 7;
        } else if (id == R.id.imageView8) {
            return 8;
        } else if (id == R.id.imageView9) {
            return 9;
        } else {
            return -1; // Valor inválido
        }
    }

    private boolean posicionOcupada(int posicion) {
        for (int i = 0; i < contadorX; i++) {
            if (posicionesX[i] == posicion) {
                return true;
            }
        }
        for (int i = 0; i < contadorO; i++) {
            if (posicionesO[i] == posicion) {
                return true;
            }
        }
        return false;
    }

    private boolean hayGanador() {
        boolean hayGanador = false; // Variable para verificar si hay un ganador

        for (int[] combinacion : matrizGanadora) {
            int a = combinacion[0];
            int b = combinacion[1];
            int c = combinacion[2];

            if (contiene(posicionesX, a) && contiene(posicionesX, b) && contiene(posicionesX, c)) {
                hayGanador = true; // Jugador "X" ganó
            } else if (contiene(posicionesO, a) && contiene(posicionesO, b) && contiene(posicionesO, c)) {
                hayGanador = true; // Jugador "O" ganó
            }
        }

        if (hayGanador) {
            // Actualiza los contadores de victorias según el ganador
            if (turno.equals("x")) {
                contadorVictoriasX++;
                textViewO.setText("Victorias de O: " + contadorVictoriasX);
            } else {
                contadorVictoriasO++;
                textViewX.setText("Victorias de X: " + contadorVictoriasO);
            }
        }

        return hayGanador;
    }


    private boolean contiene(int[] arreglo, int valor) {
        for (int elemento : arreglo) {
            if (elemento == valor) {
                return true;
            }
        }
        return false;
    }

    private void actualizarContadores() {

    }

    private void reiniciarTablero() {
        for (int i = 0; i < posicionesX.length; i++) {
            posicionesX[i] = 0;
            posicionesO[i] = 0;
        }
        contadorX = 0;
        contadorO = 0;
        partidasJugadas = 0;
        turno = "x";

        ImageView1.setImageResource(R.drawable.cuadro);
        ImageView2.setImageResource(R.drawable.cuadro);
        ImageView3.setImageResource(R.drawable.cuadro);
        ImageView4.setImageResource(R.drawable.cuadro);
        ImageView5.setImageResource(R.drawable.cuadro);
        ImageView6.setImageResource(R.drawable.cuadro);
        ImageView7.setImageResource(R.drawable.cuadro);
        ImageView8.setImageResource(R.drawable.cuadro);
        ImageView9.setImageResource(R.drawable.cuadro);

        ImageView1.setEnabled(true);
        ImageView2.setEnabled(true);
        ImageView3.setEnabled(true);
        ImageView4.setEnabled(true);
        ImageView5.setEnabled(true);
        ImageView6.setEnabled(true);
        ImageView7.setEnabled(true);
        ImageView8.setEnabled(true);
        ImageView9.setEnabled(true);
    }



}