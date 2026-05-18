package pio.daw.models;

import java.util.Date;

public class Aerolinea {
    
    private String nombre;
    private String pais;
    private String IATA; //viene a ser el id de los aviones (segun lo que he leido: estan compuestos por 3 ó 2 letras(solo letras, y en mallusculas) )
    private Date fundacion;// hay que ponerlo que tenga una forma especifica de escrivirlo, en el proyecto del RA8 tubimos que hacerlo
    
    public Aerolinea(String nombre, String pais, String iATA, Date fundacion) {
        this.nombre = nombre;
        this.pais = pais;
        IATA = iATA;
        this.fundacion = fundacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getIATA() {
        return IATA;
    }

    public void setIATA(String iATA) { // En principio este se podria vorrar porque no se deveria cambiar los IATA.
        IATA = iATA;
    }

    public Date getFundacion() {
        return fundacion;
    }

    public void setFundacion(Date fundacion) {
        this.fundacion = fundacion;
    }


}
