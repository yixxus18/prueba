package com.example.practica_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;

public class Actividad2 extends AppCompatActivity implements View.OnClickListener {

    Button reg;
    Button calculadora;
    Button maps;
    Button llamada;
    Button perfil;
    Button x;
    Button google;
    Button tiktok;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        reg = (Button) findViewById(R.id.regresar);
        calculadora = (Button) findViewById(R.id.calculadora);
        llamada = (Button) findViewById(R.id.llamada);
        maps = findViewById(R.id.maps);
        perfil = findViewById(R.id.perfil);
        x = findViewById(R.id.x);
        google = findViewById(R.id.google);
        tiktok = findViewById(R.id.tiktok);

        maps.setOnClickListener(this);
        reg.setOnClickListener(this);
        calculadora.setOnClickListener(this);
        llamada.setOnClickListener(this);
        perfil.setOnClickListener(this);
        x.setOnClickListener(this);
        google.setOnClickListener(this);
        tiktok.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.regresar) {
            Intent i = new Intent(this, GatitoActivity.class);
            startActivity(i);
        } else if (view.getId() == R.id.calculadora) {
            Intent i = new Intent(this, calculadora.class);
            startActivity(i);
        } else if (view.getId() == R.id.llamada) {
            Intent i = new Intent(Intent.ACTION_DIAL);
            startActivity(i);
        } else if (view.getId() == R.id.maps) {
            String ubicacion = "geo:25.438255,-103.449129";
            Uri i = Uri.parse(ubicacion);
            Intent map = new Intent(Intent.ACTION_VIEW, i);
            map.setPackage("com.google.android.apps.maps");
            startActivity(map);
        }
        else if (view.getId() == R.id.perfil) {
            String url = "https://www.facebook.com/jesus.orozco.31105674";
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
        }
        else if (view.getId() == R.id.x) {
            String url = "https://twitter.com/yisuskroom";
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
        }
        else if(view.getId() == R.id.google){
            String url = "https://www.google.com/?hl=es";
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
        } else if (view.getId() == R.id.tiktok) {
            String url = "https://www.tiktok.com";
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
        }
    }
}
