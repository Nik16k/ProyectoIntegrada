
package com.helloworld.apispring.model.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import com.helloworld.apispring.model.entity.historia;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RegistroSituaciones_Repositorio {
    
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<historia> getRegistroSituaciones() {
        Criteria criteria = getSessionFactory().getCurrentSession().createCriteria(historia.class);
        return criteria.list();
    }
    
}
