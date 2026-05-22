package pio.daw.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import pio.daw.models.Aerolinea;

public interface AerolineaRepository extends CrudRepository<Aerolinea, Long>{
    Optional<Aerolinea> findFirstByName(String name);
    // List<Aerolinea> searchByOrigin(String origen);
    // List<Aerolinea> searchByDestiny(String destino); CREO QUE VAN EN VUELO
    List<Aerolinea> calculateFligtMedPerAerolinea(double duracionMin, String NombreAerolinea);
    List<Aerolinea> findByNameStartingWithAndPaisAndIataAndFundacion(String nombre, String pais, String IATA, Date fundacion);

    public List<Aerolinea> findByNameStartingWithAndPais(String name, String pais);

    public List<Aerolinea> findByNameStartingWithAndIata(String name, String IATA);

    public List<Aerolinea> findByNameStartingWithAndFundacion(String name, Date fundacion);



    public List<Aerolinea> findByIataAndFundacion(String IATA, Date fundacion);

    public List<Aerolinea> findByPaisAndFundacion(String pais, Date fundacion);

    public List<Aerolinea> findByPaisAndIata(String pais, String IATA);

    public List<Aerolinea> findByFundacion(Date fundacion);

    public List<Aerolinea> findByIata(String IATA);

    public List<Aerolinea> findByPais(String pais);

    public List<Aerolinea> findByNameStartingWith(String name);


}
