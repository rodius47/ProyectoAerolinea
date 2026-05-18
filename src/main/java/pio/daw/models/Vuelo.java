package pio.daw.models;

import java.util.Date;

public class Vuelo {

    private int numero;
    private String origen;
    private String destino;
    private Date fechaSalida;
    private double duracionMin;
    private int plazas;
    
    public Vuelo(int numero, String origen, String destino, Date fechaSalida, double duracionMin, int plazas) {
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.duracionMin = duracionMin;
        this.plazas = plazas;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(double duracionMin) {
        this.duracionMin = duracionMin;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    
    
}
