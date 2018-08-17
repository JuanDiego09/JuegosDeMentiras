package com.example.juan.juegosdementiras;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.juan.juegosdementiras.entidades.User;

public class MainActivity extends AppCompatActivity {

    Button jugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User.puntaje1=0;
        User.puntaje2=0;
        ventanaOne();
    }

    private void ventanaOne() {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.modelo_dialog, (ViewGroup) findViewById(R.id.modelo));

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(layout);
        builder.setCancelable(false);

        final EditText player1 = (EditText) layout.findViewById(R.id.player1);

        final EditText player2 = (EditText) layout.findViewById(R.id.player2);

        builder.setPositiveButton("Registrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                User.player1=player1.getText().toString();
                User.player2=player2.getText().toString();
            }
        });

        builder.show();
    }

    public void onClick(View view) {
        Intent miIntent=null;
        switch (view.getId()) {
            case R.id.jugar:
                ventanaDialogoNivel();
                break;
            case R.id.lista:
                miIntent = new Intent(MainActivity.this, ListaPuntajes.class);
                startActivity(miIntent);
                break;
            case R.id.ajuste:
                miIntent = new Intent(MainActivity.this, Ajustes.class);
                startActivity(miIntent);
                break;
        }
    }

    private void ventanaDialogoNivel() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final CharSequence[] items = new CharSequence[3];

        items[0] = "Facil";
        items[1] = "Medio";
        items[2] = "Dificil";

        builder.setTitle("Seleccione Nivel")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent miIntent=null;
                        if (items[which]=="Facil") {
                            miIntent=new Intent(getApplicationContext(),FacilActivity.class);
                        }else {
                            if (items[which]=="Medio"){
                                miIntent=new Intent(getApplicationContext(),MedioActivity.class);
                            }else{
                                miIntent=new Intent(getApplicationContext(),DificilActivity.class);
                            }
                        }

                        startActivity(miIntent);
                    }
                });
        Dialog dialog = builder.create();
        dialog.show();

    }
}
