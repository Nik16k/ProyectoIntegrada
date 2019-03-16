package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.entity.ciudadanos;
import com.helloworld.apispring.model.entity.situaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/conf")
public class Controller {

    @Autowired
    private Ciudadano_Servicio Ciudadano_Servicio;

// TRAER TODOS LOS CIUDADANOS DE LA BD
    @RequestMapping(value = "/Ciudadanos", method = RequestMethod.GET)
    public ResponseEntity<List<ciudadanos>> obtenerCiudadanos() {
        List<ciudadanos> ciudadanos = Ciudadano_Servicio.getCiudadanos();
        return new ResponseEntity<List<ciudadanos>>(ciudadanos, HttpStatus.OK);
    }

    @RequestMapping(value = "/login/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearPersona(@RequestBody ciudadanos Ciudadano) {
        String resultado = "Se creo persona con ID: " + Ciudadano_Servicio.crearPersona(Ciudadano);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);
    }
    
    // VALIDAR EVENTOS POR CIUDADANO    
    @Autowired
    private Situaciones_Servicio Situaciones_Servicio;

    @RequestMapping(value = "/Eventos_Ciudadano", method = RequestMethod.GET)
    public ResponseEntity<List<situaciones>> obtenerSituaciones() {
        List<situaciones> situaciones = Situaciones_Servicio.getSituaciones();
        return new ResponseEntity<List<situaciones>>(situaciones, HttpStatus.OK);
    }
}
