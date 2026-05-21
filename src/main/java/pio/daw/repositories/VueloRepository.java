package pio.daw.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pio.daw.models.Vuelo;

public interface VueloRepository extends CrudRepository<Vuelo,Long> {
    List<Vuelo> searchByOrigin(String origen);
    List<Vuelo> searchByDestiny(String destino);
    List<Vuelo> findByTripBetween(LocalDate inicio, LocalDate fin);
    List<Vuelo> searchByPlazas(int plazas);
    // List<Vuelo> calculateFligtMed(double duracionMin); ->no creo que se utilice aquí 
}
