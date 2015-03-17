/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao.mysql;

import core.dao.GeneralDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Repository("generalDAO")
@Transactional
public class GeneralDAOImpl implements GeneralDAO {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public void insert(Object obj) {
        em.persist(obj);
    }

    @Override
    public void update(Object obj) {
        em.merge(obj);
    }

    @Override
    public void delete(Object obj) {
        em.remove(em.merge(obj));
    }
}
