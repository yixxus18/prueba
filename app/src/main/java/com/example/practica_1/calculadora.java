package com.example.practica_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

public class calculadora extends AppCompatActivity implements View.OnClickListener{

    TextView mensaje;
    StringBuilder expresion = new StringBuilder();
    Button botonmover;
    Button B;
    boolean nuevaOperacion = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        mensaje = findViewById(R.id.texto);
        Button btnborrar = findViewById(R.id.borrar);
        Button btnsumar = findViewById(R.id.sumar);
        Button btnrestar = findViewById(R.id.restar);
        Button btnmultiplicar = findViewById(R.id.multiplicar);
        Button btndividir = findViewById(R.id.dividir);
        Button uno = findViewById(R.id.numero1);
        Button cero = findViewById(R.id.numero0);
        Button dos = findViewById(R.id.numero2);
        Button tres = findViewById(R.id.numero3);
        Button cuatro = findViewById(R.id.numero4);
        Button cinco = findViewById(R.id.numero5);
        Button seis = findViewById(R.id.numero6);
        Button siete = findViewById(R.id.numero7);
        Button ocho = findViewById(R.id.numero8);
        Button nueve = findViewById(R.id.numero9);
        Button igual = findViewById(R.id.igual);

        btnborrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expresion.setLength(0);
                mensaje.setText("");
                nuevaOperacion = true;
            }
        });

        btnsumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarOperacion("+");
            }
        });

        btnrestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarOperacion("-");
            }
        });

        btndividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarOperacion("/");
            }
        });

        btnmultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarOperacion("*");
            }
        });

        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNumero("1");
            }
        });

        cero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNumero("0");
            }
        });

        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNumero("2");
            }
        });

        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNumero("3");
            }
        });

        cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNumero("4");
            }
        });

        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNumero("5");
            }
        });

        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNumero("6");
            }
        });

        siete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNumero("7");
            }
        });

        ocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNumero("8");
            }
        });

        nueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarNumero("9");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double resultado = evaluarExpresion(expresion.toString());
                mensaje.setText(String.valueOf(resultado));
                nuevaOperacion = true;
            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    private void agregarNumero(String numero) {
        if (nuevaOperacion) {
            mensaje.setText(numero);
            nuevaOperacion = false;
        } else {
            mensaje.append(numero);
        }
        expresion.append(numero);
    }
    private void agregarOperacion(String operacion) {
        if (!nuevaOperacion) {
            mensaje.append(operacion);
            expresion.append(operacion);
            nuevaOperacion = true;
        }
    }
    private double evaluarExpresion(String expresion) throws ArithmeticException {
        try {
            String[] partes = expresion.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");

            if (partes.length != 3) {
                throw new IllegalArgumentException("Expresión no válida");
            }

            double operando1 = Double.parseDouble(partes[0].trim());
            double operando2 = Double.parseDouble(partes[2].trim());
            String operador = partes[1].trim();

            switch (operador) {
                case "+":
                    return operando1 + operando2;
                case "-":
                    return operando1 - operando2;
                case "*":
                    return operando1 * operando2;
                case "/":
                    return operando1 / operando2;
                default:
                    throw new IllegalArgumentException("Operador no válido");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Expresión no válida");
        }
    }
}