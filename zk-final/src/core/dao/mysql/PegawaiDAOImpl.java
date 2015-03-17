/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao.mysql;

import core.dao.PegawaiDAO;
import core.entity.Pegawai;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Repository("pegawaiDAO")
@Transactional
public class PegawaiDAOImpl extends GeneralDAOImpl implements PegawaiDAO {

    @Override
    public Pegawai getByNip(String nip) {
        return (Pegawai) em.createQuery("SELECT p FROM Pegawai p WHERE p.nip=:param")
                .setParameter("param", nip).getSingleResult();
    }

    @Override
    public List<Pegawai> getAll() {
        return em.createQuery("SELECT p FROM Pegawai p")
                .getResultList();
    }
}
