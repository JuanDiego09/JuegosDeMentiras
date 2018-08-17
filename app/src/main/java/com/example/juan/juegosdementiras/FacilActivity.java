package com.example.juan.juegosdementiras;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class FacilActivity extends AppCompatActivity {

    ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    TextView player1, player2, puntaje2, puntaje1;
    ImageView imagenActuan, imagenAnterior;
    Drawable parejas[] = new Drawable[4], defecto;
    int Onclick;
    int asignados, asignados1, asignados2, asignados3, asignados4;
    int n, num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facil);

        defecto = getResources().getDrawable(R.drawable.pregunta);
        btn1 = findViewById(R.id.btn1f);
        btn2 = findViewById(R.id.btn2f);
        btn3 = findViewById(R.id.btn3f);
        btn4 = findViewById(R.id.btn4f);
        btn5 = findViewById(R.id.btn5f);
        btn6 = findViewById(R.id.btn6f);
        btn7 = findViewById(R.id.btn7f);
        btn8 = findViewById(R.id.btn8f);
        player1 = findViewById(R.id.txtplayer1);
        player2 = findViewById(R.id.txtplayer2);
        puntaje1 = findViewById(R.id.txtpuntaje1);
        puntaje2 = findViewById(R.id.txtpuntaje2);

        generarParejas();
    }

    private void generarParejas() {
        while (asignados < 4) {
            n = new Random().nextInt(4);
            switch (n + 1) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
        }
    }
}
