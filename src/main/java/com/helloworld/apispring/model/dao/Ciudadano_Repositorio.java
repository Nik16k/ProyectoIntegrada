package com.helloworld.apispring.model.dao;
import com.helloworld.apispring.model.entity.personas;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class Ciudadano_Repositorio {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

  
     
    public List<personas> getCiudadanos() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(personas.class);
        return criteria.list();
    }
    
    public long crearPersona(personas Ciudadano) {
        getSessionFactory().getCurrentSession().save(Ciudadano);
        return Ciudadano.getIdCiudadano();
    }

  

}
