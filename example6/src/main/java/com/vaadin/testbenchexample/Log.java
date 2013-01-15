package com.vaadin.testbenchexample;

import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;

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
		label.setSizeUndefined();
		content.addComponent(label);
		getWindow().scrollIntoView(label);
	}

}