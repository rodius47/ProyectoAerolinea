package pio.daw.controllers;

import org.springframework.web.bind.annotation.RestController;

import pio.daw.services.ServicioGeneral;


@RestController
public class ApiController {
    // hay que crear en docker un contenedor que se llame proyectoSpringAerolinea

    private final ServicioGeneral servicioGeneral;

    public ApiController(ServicioGeneral servicioGeneral){
        this.servicioGeneral = servicioGeneral;
    }

    // @GetMapping
    // public List<Aerolinea> listarTodos() {
    //     return servicioGeneral.listarTodos();
    // }

    // @GetMapping("/{id}")
    // public Aerolinea buscarPorId(@PathVariable Long id) {
    //     return servicioGeneral.buscarPorId(id);
    // }
    
}
