/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.dao;

import java.util.List;

import core.entity.Unit;

/**
 *
 * @author user
 */
public interface UnitDAO extends GeneralDAO {

    public Unit getByKode(String kode);

    public List<Unit> getAll();
}
