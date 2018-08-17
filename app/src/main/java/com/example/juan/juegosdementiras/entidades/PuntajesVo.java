package com.example.juan.juegosdementiras.entidades;

public class PuntajesVo {

    private String  player1;
    private String player2;

    private String nivel;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    private String mensaje;

    private int puntaje1;
    private int puntaje2;

    private int puntajes;

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getPuntaje1() {
        return puntaje1;
    }

    public void setPuntaje1(int puntaje1) {
        this.puntaje1 = puntaje1;
    }

    public int getPuntaje2() {
        return puntaje2;
    }

    public void setPuntaje2(int puntaje2) {
        this.puntaje2 = puntaje2;
    }

    public int getPuntajes() {
        return puntajes;
    }

    public void setPuntajes(int puntajes) {
        this.puntajes = puntajes;
    }

    public int getTiempoJuego() {
        return tiempoJuego;
    }

    public void setTiempoJuego(int tiempoJuego) {
        this.tiempoJuego = tiempoJuego;
    }

    private int tiempoJuego;
}
