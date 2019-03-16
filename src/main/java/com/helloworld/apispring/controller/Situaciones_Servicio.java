package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.eventoRepositorio;
import com.helloworld.apispring.model.entity.historia;
import com.helloworld.apispring.model.entity.eventos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Situaciones_Servicio {
    
         @Autowired
    private eventoRepositorio Situaciones_Repositorio;

    public Situaciones_Servicio() {
    }

    public List<eventos> getSituaciones() {
        return Situaciones_Repositorio.getSituaciones();
    }
    
}
