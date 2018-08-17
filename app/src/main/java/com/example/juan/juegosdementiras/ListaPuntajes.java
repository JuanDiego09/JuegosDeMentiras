package com.example.juan.juegosdementiras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.juan.juegosdementiras.adapter.PuntajesAdater;
import com.example.juan.juegosdementiras.entidades.PuntajesVo;

import java.util.ArrayList;

public class ListaPuntajes extends AppCompatActivity {

    Spinner listaTipoJuego,listaNiveles;
    RecyclerView recyclerView;


    ArrayList arrayTipoJuego;
    ArrayList arrayNivelJuego;

    String nivel;
    String tipo;

    PuntajesAdater adater;
    ArrayList<PuntajesVo>listaVo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_puntajes);

        ///////////////////////////////////////////////////////////////////
        arrayTipoJuego = new ArrayList();
        arrayTipoJuego.add("Seleccione un tipo de juego");
        arrayTipoJuego.add("Tiempo");
        arrayTipoJuego.add("Movimientos");

        arrayNivelJuego = new ArrayList();
        arrayNivelJuego.add("Seleccione un nivel de juego");
        arrayNivelJuego.add("Facil");
        arrayNivelJuego.add("Medio");
        arrayNivelJuego.add("Dificil");
        ///////////////////////////////////////////////////////////////////


        listaTipoJuego = findViewById(R.id.spinnerTipoJuego);
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


        listaNiveles = findViewById(R.id.spinnerNivelJuego);
        ArrayAdapter<CharSequence>adapterNivel = new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,arrayNivelJuego);
        listaNiveles.setAdapter(adapterNivel);
        listaNiveles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        ///////////////////////////////////////////////////////////////////
        PuntajesVo puntajesVo= new PuntajesVo();
        listaVo = new ArrayList<>();
        for (int i = 0; i<5; i++){
            puntajesVo.setPlayer1("pepe");
            puntajesVo.setPuntaje1(100);
            puntajesVo.setMensaje("hola mundo");
            listaVo.add(puntajesVo);
        }

        adater = new PuntajesAdater(listaVo);
        recyclerView = findViewById(R.id.recyclerPuntajes);
        recyclerView.setAdapter(adater);
        //////////////////////////////////////////////////////////////////

    }

    private void seleccionaNivel(int position) {

        switch (position){
            case 1:
                nivel = "facil";
                break;

            case 2:
                nivel = "medio";
                break;

            case 3:
                nivel = "dificil";

                break;
        }

        Toast.makeText(getApplicationContext(),"Nivel: " + nivel,Toast.LENGTH_SHORT).show();
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

        Toast.makeText(getApplicationContext(),"Tipo: " + tipo,Toast.LENGTH_SHORT).show();
    }
}
