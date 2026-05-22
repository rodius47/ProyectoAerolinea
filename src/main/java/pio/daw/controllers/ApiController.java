package pio.daw.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pio.daw.models.Aerolinea;
import pio.daw.models.Vuelo;
import pio.daw.services.ServicioGeneral;



@RestController
@RequestMapping("api/aerolinea")
public class ApiController {
    // hay que crear en docker un contenedor que se llame proyectoSpringAerolinea

    @Autowired
    private ServicioGeneral servicioGeneral;

    public ApiController(ServicioGeneral servicioGeneral){
        this.servicioGeneral = servicioGeneral;
    }

    @GetMapping("/fechas")
    public List<Vuelo> buscarEntreFechas(
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate inicio,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate fin) {
        return servicioGeneral.buscarEntreFechas(inicio, fin);
    }

    @GetMapping("/vuelos")
    public List<Vuelo> buscarVuelosConPlazasDisponibles(@RequestParam(required = true) int plazas){
        return servicioGeneral.buscarVuelosConPlazasDisponibles(plazas);
    }

    @GetMapping("/origen")
    public List<Vuelo> filtrarPorOrigen(@RequestParam(required = true) String origen){
        return servicioGeneral.filtrarPorOrigen(origen);
    }
    
    @GetMapping("/destino")
    public List<Vuelo> filtrarPorDestiny(@RequestParam(required = true) String destino){
        return servicioGeneral.filtrarPorDestiny(destino);
    }

    @GetMapping("/media")
    public List<Aerolinea> calcularMediaVueloPorAerolinea(double duracionMin, String NombreAerolinea){
        return servicioGeneral.calcularMediaVueloPorAerolinea(duracionMin, NombreAerolinea);
    }

    @PostMapping("")
    public Aerolinea añadirPersona(@RequestBody Aerolinea entity) {
        return servicioGeneral.crearAerolineaSiNoExiste(entity);
    }


}
