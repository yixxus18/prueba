package com.example.practica_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button B;
    CountDownTimer countDownTimer;
    boolean isCounting = false;
    TextView contadorTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        B = findViewById(R.id.Mover);
        B.setOnClickListener(this);

        contadorTextView = findViewById(R.id.contador);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.Mover) {
            if (!isCounting) {
                startCountdown();
            }
        }
    }

    // Función para iniciar el contador
    private void startCountdown() {
        countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                isCounting = true;
                B.setEnabled(false);
                contadorTextView.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, Actividad2.class);
                startActivity(intent);
                isCounting = false;
                B.setEnabled(true);
                contadorTextView.setText("0"); // Restablece el contador a 0 al finalizar
            }
        }.start();
    }
}

