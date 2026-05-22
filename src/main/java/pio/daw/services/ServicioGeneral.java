package pio.daw.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    private AerolineaRepository repoAero;

    public List<Aerolinea> buscarPersonas(String name, String pais, String IATA, Date fundacion) {
        boolean hasNombre = name != null;
        boolean hasPais = pais != null;
        boolean hasIATA = IATA != null;
        boolean hasFundacion = fundacion != null;

        if (hasNombre && hasPais && hasIATA && hasFundacion)
            return repoAero.findByNameStartingWithAndPaisAndIataAndFundacion(name, pais, IATA, fundacion);
        if (hasNombre && hasPais)
            return repoAero.findByNameStartingWithAndPais(name, pais);
        if (hasNombre && hasIATA)
            return repoAero.findByNameStartingWithAndIata(name, IATA);
        if (hasNombre && hasFundacion)
            return repoAero.findByNameStartingWithAndFundacion(name, fundacion);
        if (hasPais && hasIATA)
            return repoAero.findByPaisAndIata(pais, IATA);
        if (hasPais && hasFundacion)
            return repoAero.findByPaisAndFundacion(pais, fundacion);
        if (hasIATA && hasFundacion)
            return repoAero.findByIataAndFundacion(IATA, fundacion);
        if (hasNombre)
            return repoAero.findByNameStartingWith(name);
        if (hasPais)
            return repoAero.findByPais(pais);
        if (hasIATA)
            return repoAero.findByIata(IATA);
        if (hasFundacion)
            return repoAero.findByFundacion(fundacion);

        List<Aerolinea> todas = new ArrayList<>();
        repoAero.findAll().forEach(todas::add);
        return todas;
    }

    public Aerolinea crearAerolineaSiNoExiste(Aerolinea a) {
        return repoAero.findFirstByName(a.getNombre())
                .orElse(repoAero.save(a));
    }

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
