package com.example.taller202501;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mensaje;
    Button btnAumentar, btnDisminuir, btnColor, btnFuente;

    float tamañoActual = 24f;

    Typeface[] fuentesSistema = {
            Typeface.DEFAULT,
            Typeface.DEFAULT_BOLD,
            Typeface.SANS_SERIF,
            Typeface.SERIF,
            Typeface.MONOSPACE
    };

    int[] colores = {
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.MAGENTA,
            Color.CYAN,
            Color.DKGRAY,
            Color.BLACK
    };

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mensaje = findViewById(R.id.txtmensaje);
        btnAumentar = findViewById(R.id.btnAumentar);
        btnDisminuir = findViewById(R.id.btnDisminuir);
        btnColor = findViewById(R.id.btnColor);
        btnFuente = findViewById(R.id.btnFuente);

        btnAumentar.setOnClickListener(v -> {
            tamañoActual += 4f;
            mensaje.setTextSize(TypedValue.COMPLEX_UNIT_SP, tamañoActual);
        });

        btnDisminuir.setOnClickListener(v -> {
            tamañoActual = Math.max(8f, tamañoActual - 4f);
            mensaje.setTextSize(TypedValue.COMPLEX_UNIT_SP, tamañoActual);
        });

        btnColor.setOnClickListener(v -> {
            int color = colores[random.nextInt(colores.length)];
            mensaje.setTextColor(color);
        });

        btnFuente.setOnClickListener(v -> {
            Typeface fuente = fuentesSistema[random.nextInt(fuentesSistema.length)];
            mensaje.setTypeface(fuente);
        });
    }
}



