package com.example.juan.juegosdementiras;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import com.example.juan.juegosdementiras.utilidades.Conexion;
import com.example.juan.juegosdementiras.utilidades.Utilidades;

import java.util.ArrayList;

public class ListaPuntajes extends AppCompatActivity {

    Spinner listaTipoJuego, listaNiveles;
    RecyclerView recyclerView;
    PuntajesVo miPuntajesVo;

    ArrayList arrayTipoJuego;
    ArrayList arrayNivelJuego;

    int nivel = 1;
    int tipo = 1;
    PuntajesAdater miAdater;

    PuntajesAdater adater;
    ArrayList<PuntajesVo> listaVo = new ArrayList<>();

    Conexion conn;
    SQLiteDatabase bd;
    PuntajesVo puntajesVo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_puntajes);

        conn = new Conexion(this, "puntaje", null, 1);
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

        recyclerView = findViewById(R.id.recyclerPuntajes);

        listaTipoJuego = findViewById(R.id.spinnerTipoJuego);
        ArrayAdapter<CharSequence> adapterTipo = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, arrayTipoJuego);
        listaTipoJuego.setAdapter(adapterTipo);
        listaTipoJuego.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    seleccionaTipo(position);
                    consultar();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        listaNiveles = findViewById(R.id.spinnerNivelJuego);
        ArrayAdapter<CharSequence> adapterNivel = new ArrayAdapter(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, arrayNivelJuego);
        listaNiveles.setAdapter(adapterNivel);
        listaNiveles.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    seleccionaNivel(position);
                    consultar();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ///////////////////////////////////////////////////////////////////

        //////////////////////////////////////////////////////////////////

    }

    private void consultar() {
        bd = conn.getReadableDatabase();
        listaVo.clear();
        adater=null;

        Cursor cursor = bd.rawQuery("SELECT * FROM "
                + Utilidades.TABLA_PUNTAJE + " WHERE "
                + Utilidades.NIVEL + " = " + nivel+ " AND "
                + Utilidades.TIPO + " = " + tipo + " ORDER BY  "
                + Utilidades.PUNTAJE + " DESC ", null);

        while (cursor.moveToNext()) {
            miPuntajesVo = new PuntajesVo();
            miPuntajesVo.setPlayer1(cursor.getString(0));
            miPuntajesVo.setPuntaje1(cursor.getInt(3));
            if (tipo==1){
                miPuntajesVo.setMensaje("Tiempo");
            }else{
                miPuntajesVo.setMensaje("Movimientos");
            }


            listaVo.add(miPuntajesVo);
        }

        miAdater = new PuntajesAdater(listaVo);
        recyclerView.setAdapter(miAdater);

    }

    private void seleccionaNivel(int position) {

        switch (position) {
            case 1:
                nivel = 1;
                break;

            case 2:
                nivel = 2;
                break;

            case 3:
                nivel = 3;

                break;
        }

    }

    private void seleccionaTipo(int position) {

        switch (position) {
            case 1:
                tipo = 1;
                break;

            case 2:
                tipo = 2;
                break;
        }

    }
}
