package com.helloworld.apispring.controller;

import com.helloworld.apispring.model.dao.RegistroSituaciones_Repositorio;
import com.helloworld.apispring.model.entity.historia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroSituaciones_Servicio {
    
     @Autowired
    private RegistroSituaciones_Repositorio RegistroSituaciones_Repositorio;

    public RegistroSituaciones_Servicio() {
    }

    public List<historia> getRegistro() {
        return RegistroSituaciones_Repositorio.getRegistroSituaciones();
    }
    
    
}
