package pio.daw.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pio.daw.models.Aerolinea;

public interface AerolineaRepository extends CrudRepository<Aerolinea, Long>{
    List<Aerolinea> searchByOrigin(String origen);
    List<Aerolinea> searchByDestiny(String destino);
    List<Aerolinea> calculateFligtMedPerAerolinea(double duracionMin, String NombreAerolinea);
}
