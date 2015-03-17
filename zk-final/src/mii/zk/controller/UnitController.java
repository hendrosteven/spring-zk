package mii.zk.controller;

import java.util.List;
import java.util.Set;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.ext.Selectable;

import core.dao.UnitDAO;
import core.entity.Unit;

@VariableResolver(DelegatingVariableResolver.class)
public class UnitController extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;

	@WireVariable("unitDAO")
	private UnitDAO dao;

	@Wire
	private Listbox listUnit;
	@Wire
	private Textbox txtKode;
	@Wire
	private Textbox txtNama;
	@Wire
	private Textbox txtId;

	@Override
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		loadUnit();
	}

	@Listen("onClick = #btnSimpan")
	public void bntSimpanClick() {
		if (txtId.getValue().isEmpty()) { //insert
			Unit unit = new Unit();
			unit.setKode(txtKode.getValue());
			unit.setNama(txtNama.getValue());
			dao.insert(unit);			
		} else {//update
			Unit unit = new Unit();
			unit.setId(Long.valueOf(txtId.getValue()));
			unit.setKode(txtKode.getValue());
			unit.setNama(txtNama.getValue());
			dao.update(unit);
		}
		loadUnit();
		Messagebox.show("Data tersimpan");
		txtKode.setValue("");
		txtNama.setValue("");
		txtId.setValue("");
	}
	
	@Listen("onClick = #btnBaru")
	public void btnBaruClick(){
		txtKode.setValue("");
		txtNama.setValue("");
		txtId.setValue("");
		txtKode.setFocus(true);
	}
	
	@Listen("onClick = #btnHapus")
	public void btnHapusClick(){
		if(!txtId.getValue().isEmpty()){
			dao.delete(dao.getByKode(txtKode.getValue()));
			txtKode.setValue("");
			txtNama.setValue("");
			txtId.setValue("");
			loadUnit();
		}
	}

	@Listen("onSelect = #listUnit")
	public void selectListPegawai() {
		Set<Unit> selectedUnit = ((Selectable<Unit>) listUnit.getModel())
				.getSelection();
		Unit unit = selectedUnit.iterator().next();
		txtId.setValue(String.valueOf(unit.getId()));
		txtKode.setValue(unit.getKode());
		txtNama.setValue(unit.getNama());
	}

	private void loadUnit() {
		try {
			List<Unit> result = dao.getAll();
			listUnit.setModel(new ListModelList<Unit>(result));
		} catch (Exception ex) {
			ex.printStackTrace();
			Messagebox.show(ex.getMessage());
		}
	}
}
