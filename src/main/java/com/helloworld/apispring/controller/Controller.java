package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.entity.personas;
import com.helloworld.apispring.model.entity.historia;
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
    private personaServicio Ciudadano_Servicio;
    @Autowired
    private historiaServicio registroSituacionesServicio;

// Servicio No.1 Mostrar todos los personas creados en la database
    @RequestMapping(value = "/Ciudadanos", method = RequestMethod.GET)
    public ResponseEntity<List<personas>> obtenerCiudadanos() {
        List<personas> ciudadanos = Ciudadano_Servicio.getCiudadanos();
        return new ResponseEntity<List<personas>>(ciudadanos, HttpStatus.OK);
    }
//Servicio No. 2 Crear un ciudadano en la database

    @RequestMapping(value = "/ciudadanos", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearPersona(@RequestBody personas Ciudadano) {
        String resultado = "Se creo persona con ID: " + Ciudadano_Servicio.crearPersona(Ciudadano);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);
    }

    @Autowired
    private eventoServicio Situaciones_Servicio;

//Servicio No 3 . Mostrar todas las eventos de los personas
    @RequestMapping(value = "/eventos", method = RequestMethod.GET)
    public ResponseEntity<List<eventos>> obtenerSituaciones() {
        List<eventos> situaciones = Situaciones_Servicio.getSituaciones();
        return new ResponseEntity<List<eventos>>(situaciones, HttpStatus.OK);
    }
    //Servicio No. 4 buscar ciudadano por id

    @RequestMapping(value = "/personas", method = RequestMethod.GET)
    public ResponseEntity<List<personas>> ciudadanoPorId(@RequestParam(value = "IdCiudadano") int id) {
        List<personas> ciudadnosId = (List<personas>) Ciudadano_Servicio.getCiudadanoPorId(id);
        return new ResponseEntity<List<personas>>(ciudadnosId, HttpStatus.OK);
    }
//Servicio No 5 registrar un evento por personas
    @RequestMapping(value = "/eventos", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> crearEventoCiudadano(@RequestBody historia registroEvento) {
        String resultado = "Se creo el evento : " + registroSituacionesServicio.registroEvento(registroEvento);
        return new ResponseEntity<String>(resultado, HttpStatus.OK);
    }
    
    //Servicio No. 6 Listar Eventos por ciudadano
    
    @RequestMapping(value = "/eventos_persona", method = RequestMethod.GET)
    public ResponseEntity<List<historia>> eventosCiudadanoPorId(@RequestParam(value = "IdCiudadano") int id) {
        List<historia> eventosCiudadanosId = (List<historia>) registroSituacionesServicio.getEventosId(id); 
                
        return new ResponseEntity<List<historia>>(eventosCiudadanosId, HttpStatus.OK);
    }
    
    
}
