package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.Ciudadano_Repositorio;
import com.helloworld.apispring.model.entity.personas;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class personaServicio {

    @Autowired
    private Ciudadano_Repositorio Ciudadano_Repositorio;

    public personaServicio() {
    }

    // TRAER TODOS LOS CIUDADANOS
    public List<personas> getCiudadanos() {
        return Ciudadano_Repositorio.getCiudadanos();
    }

    public long crearPersona(personas Ciudadano) {
        return Ciudadano_Repositorio.crearPersona(Ciudadano);
    }
}
