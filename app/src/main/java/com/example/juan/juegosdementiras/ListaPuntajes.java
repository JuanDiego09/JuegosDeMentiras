package com.example.juan.juegosdementiras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.juan.juegosdementiras.entidades.PuntajesVo;

import java.util.ArrayList;

public class ListaPuntajes extends AppCompatActivity {

    Spinner listaTipoJuego,listaNiveles;
    RecyclerView recyclerView;

    ArrayList<PuntajesVo>listaVo;
    ArrayList arrayTipoJuego;
    ArrayList arrayNivelJuego;

    String nivel;
    String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_puntajes);

        listaTipoJuego = findViewById(R.id.spinnerTipoJuego);
        listaNiveles = findViewById(R.id.spinnerNivelJuego);
        recyclerView = findViewById(R.id.recyclerPuntajes);

        arrayTipoJuego = new ArrayList();
        arrayTipoJuego.add("Seleccione un tipo de juego");
        arrayTipoJuego.add("Tiempo");
        arrayTipoJuego.add("Movimientos");

        ArrayAdapter<CharSequence> adapterTipo = new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,arrayTipoJuego);
        listaTipoJuego.setAdapter(adapterTipo);
        listaTipoJuego.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0){
                    seleccionaTipo(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        arrayNivelJuego = new ArrayList();
        arrayNivelJuego.add("Seleccione un nivel de juego");
        arrayNivelJuego.add("Facil");
        arrayNivelJuego.add("Medio");
        arrayNivelJuego.add("Dificil");
        ArrayAdapter<CharSequence>adapterNivel = new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,arrayNivelJuego);
        listaTipoJuego.setAdapter(adapterNivel);
        listaTipoJuego.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0){
                    seleccionaNivel(position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







    }

    private void seleccionaNivel(int position) {

        switch (position){
            case 1:
                tipo = "facil";
                break;

            case 2:
                tipo = "medio";
                break;

            case 3:
                tipo = "dificil";
                break;

        }
    }

    private void seleccionaTipo(int position) {

        switch (position){
            case 1:
                tipo = "tiempo";
                break;

            case 2:
                tipo = "movimientos";
                break;

        }
    }
}
