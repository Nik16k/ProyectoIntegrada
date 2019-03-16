package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.entity.personas;
import com.helloworld.apispring.model.entity.eventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/v1")
public class Controller {

    @Autowired
    private personaServicio personaServicio;

// TRAER TODOS LOS CIUDADANOS DE LA BD
    @RequestMapping(value = "/Personas", method = RequestMethod.GET)
    public ResponseEntity<List<personas>> obtenerCiudadanos() {
        List<personas> ciudadanos = personaServicio.getCiudadanos();
        return new ResponseEntity<List<personas>>(ciudadanos, HttpStatus.OK);
    }

    @RequestMapping(value = "/login/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearPersona(@RequestBody personas Ciudadano) {
        String resultado = "Se creo persona con ID: " + personaServicio.crearPersona(Ciudadano);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);
    }
    
    // VALIDAR EVENTOS POR CIUDADANO    
    @Autowired
    private eventoServicio eventosServicio;

    @RequestMapping(value = "/Eventos_Ciudadano", method = RequestMethod.GET)
    public ResponseEntity<List<eventos>> obtenerSituaciones() {
        List<eventos> situaciones = eventosServicio.getSituaciones();
        return new ResponseEntity<List<eventos>>(situaciones, HttpStatus.OK);
    }
}
