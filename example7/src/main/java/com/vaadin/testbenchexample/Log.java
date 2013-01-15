package com.vaadin.testbenchexample;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

class Log extends Panel {

	private int row;
	CssLayout content = new CssLayout();

	public Log() {
		setWidth("200px");
		setHeight("500px");
		setContent(content);
	}

	public void addRow(String rowStr) {
		Label label = new Label(row++ + " : " + rowStr);
		// With this lables not made as lines, negligible effect in V7
//		label.setSizeUndefined();
		content.addComponent(label);
		UI.getCurrent().scrollIntoView(label);
	}

}