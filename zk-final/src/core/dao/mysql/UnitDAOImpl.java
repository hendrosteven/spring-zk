/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao.mysql;

import core.dao.UnitDAO;
import core.entity.Unit;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Repository("unitDAO")
@Transactional
public class UnitDAOImpl extends GeneralDAOImpl implements UnitDAO {

    @Override
    public Unit getByKode(String kode) {
        return (Unit) em.createQuery("SELECT u FROM Unit u WHERE u.kode=:param")
                .setParameter("param", kode).getSingleResult();
    }

    @Override
    public List<Unit> getAll() {
        return em.createQuery("SELECT u FROM Unit u")
                .getResultList();
    }
}
