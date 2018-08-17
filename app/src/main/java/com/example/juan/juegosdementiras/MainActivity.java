package com.example.juan.juegosdementiras;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ventanaOne();
    }

    private void ventanaOne() {
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.modelo_dialog, (ViewGroup) findViewById(R.id.modelo));

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(layout);
        builder.setCancelable(false);

        final EditText player1 = (EditText) layout.findViewById(R.id.player1);

        final EditText player2 = (EditText) layout.findViewById(R.id.player1);

        builder.setPositiveButton("Registrar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.jugar:
                break;
            case R.id.lista:
                break;
            case R.id.ajuste:
                break;
        }
    }
}
