package com.example.juan.juegosdementiras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.juan.juegosdementiras.entidades.User;

public class Ajustes extends AppCompatActivity {

    EditText campoTiempo;
    Button btnCapturaTiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        campoTiempo = findViewById(R.id.campoTiempoAjuste);


    }

    public void onClick(View view) {
        User.tipo = 2;
        User.tiempoJuego = Integer.parseInt(campoTiempo.getText().toString());
        finish();
    }

    public void onClick2(View view) {
        User.tipo = 2;
        finish();
    }
}
