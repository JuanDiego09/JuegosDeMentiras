package com.example.juan.juegosdementiras.adapter;

import android.icu.util.ValueIterator;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.juan.juegosdementiras.R;
import com.example.juan.juegosdementiras.entidades.PuntajesVo;

import java.util.ArrayList;

public class PuntajesAdater extends RecyclerView.Adapter<PuntajesAdater.PuntajesHolder>{

    ArrayList<PuntajesVo> listaPuntajes;

    public PuntajesAdater(ArrayList<PuntajesVo> listaPuntajes) {
        this.listaPuntajes = listaPuntajes;
    }

    @Override
    public PuntajesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.modelo_puntajes_adapter,null,false);
        return new PuntajesHolder(view);
    }

    @Override
    public void onBindViewHolder(PuntajesHolder holder, int position) {

        holder.campoNombre.setText("Jugador: "+listaPuntajes.get(position).getPlayer1());
        holder.campoPuntaje.setText("Puntaje: "+listaPuntajes.get(position).getPuntaje1());
        holder.campoMensaje.setText("Mensaje: "+listaPuntajes.get(position).getMensaje());
    }

    @Override
    public int getItemCount() {
        return listaPuntajes.size();
    }

    public class PuntajesHolder extends RecyclerView.ViewHolder {
        TextView campoNombre,campoPuntaje,campoMensaje;
        public PuntajesHolder(View itemView) {
            super(itemView);

            campoNombre = itemView.findViewById(R.id.campoNombreJugadorM);
            campoPuntaje = itemView.findViewById(R.id.campoPuntajeJugadorM);
            campoMensaje = itemView.findViewById(R.id.campoMensajeJugadorM);
        }
    }
}
