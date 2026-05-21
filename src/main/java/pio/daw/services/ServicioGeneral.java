package pio.daw.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pio.daw.models.Aerolinea;
import pio.daw.models.Vuelo;
import pio.daw.repositories.AerolineaRepository;
import pio.daw.repositories.VueloRepository;

@Service
public class ServicioGeneral {
    @Autowired
    private VueloRepository repoVuelo;
    private AerolineaRepository repoAero;

    public List<Vuelo> buscarEntreFechas(LocalDate inicio, LocalDate fin){
        return repoVuelo.findByTripBetween(inicio, fin);
    }

    public List<Vuelo> buscarVuelosConPlazasDisponibles(int plazas){
        return repoVuelo.searchByPlazas(plazas);
    }

    public List<Vuelo> filtrarPorOrigen(String origen){
        return repoVuelo.searchByOrigin(origen);
    }

    public List<Vuelo> filtrarPorDestiny(String destino){
        return repoVuelo.searchByDestiny(destino);
    }

    public List<Aerolinea> calcularMediaVueloPorAerolinea(double duracionMin, String NombreAerolinea){
        return repoAero.calculateFligtMedPerAerolinea(duracionMin, NombreAerolinea);
    }


}
