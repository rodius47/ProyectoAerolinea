package pio.daw.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pio.daw.models.Aerolinea;
import pio.daw.services.ServicioGeneral;

@Controller
@RequestMapping("/web")
public class WebController {

    @Autowired
    private ServicioGeneral servicioGeneral;

    @GetMapping
    public String lista(
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) String pais,
        @RequestParam(required = false) String IATA,
        @RequestParam(required = false) Date fecha,
        Model model) {
        String filtronombre = (nombre != null) ? nombre : "";
        String filtroPais = (pais != null) ? pais : "";
        String filtroIATA = (IATA != null) ? IATA : "";
        Date filtroFecha = (fecha != null) ? fecha : null;

        List<Aerolinea> aerolineas = servicioGeneral.buscarAerolineas(filtronombre, filtroPais, filtroIATA, filtroFecha);
        model.addAttribute("aerolineas", aerolineas);
        model.addAttribute("filtroNombre", filtronombre);
        model.addAttribute("filtroPais", filtroPais);
        model.addAttribute("filtroIATA", filtroIATA);
        model.addAttribute("filtroFecha", filtroFecha);
        return "aerolineas/lista";
    }

    @GetMapping("/nueva")
    public String nuevaAerolinea(Model model) {
        model.addAttribute("aerolinea", new Aerolinea("", "", "", new Date()));
        return "aerolineas/nueva"; 
    }

    @PostMapping("/nueva")
    public String crearAerolinea(
        @RequestParam String nombre,
        @RequestParam String pais,
        @RequestParam String IATA,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fundacion) {
    Aerolinea a = new Aerolinea(nombre, pais, IATA, fundacion);
    servicioGeneral.crearAerolineaSiNoExiste(a);
    return "redirect:/web";
    }

    @GetMapping("/borrar/{IATA}")
    public String borrarAerolinea(
        @PathVariable String IATA) {
        servicioGeneral.borrarAerolinea(IATA);
        return "redirect:/web";
    }
}
