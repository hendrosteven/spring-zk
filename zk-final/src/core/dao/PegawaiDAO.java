/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import java.util.List;

import core.entity.Pegawai;

/**
 *
 * @author user
 */
public interface PegawaiDAO extends GeneralDAO {

    public Pegawai getByNip(String nip);

    public List<Pegawai> getAll();
}
