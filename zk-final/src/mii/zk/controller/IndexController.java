package mii.zk.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;

public class IndexController extends SelectorComposer<Component>  {

	@Wire
	private Div contentDiv;
	
	@Listen("onClick = #btnUnit")
	public void btnUnitClick(){
		contentDiv.getChildren().clear();
        Executions.createComponents("/units.zul", contentDiv, null);
	}
	
}
