package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.historiaRepositorio;
import com.helloworld.apispring.model.entity.historia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroSituaciones_Servicio {
    
     @Autowired
    private historiaRepositorio RegistroSituaciones_Repositorio;

    public RegistroSituaciones_Servicio() {
    }

    public List<historia> getRegistro() {
        return RegistroSituaciones_Repositorio.getRegistroSituaciones();
    }
    
    
}
