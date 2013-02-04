package com.vaadin.testbenchexample;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class CalcWindow extends UI {
	  private CssLayout rootLayout;
	  
	  
	  private CssLayout stuff;
	  int count = 0;
	  
	  private void increment() {
		  if(stuff != null) {
			  rootLayout.removeComponent(stuff);
		  }
		  
		  stuff = new CssLayout();
		  for(int i =0 ; i < 1000; i++) {
			  Label label = new Label("TExt" + i);
			  label.setSizeUndefined();
			  stuff.addComponent(label);
		  }
		  rootLayout.addComponent(stuff);
	  }


	  @Override
	  protected void init(VaadinRequest request) {
		    rootLayout = new CssLayout();
		    rootLayout.setSizeUndefined();
		    setContent(rootLayout);

		    Button btn = new Button("Click");
		    btn.setDebugId("getmore");
		    btn.addListener(new Button.ClickListener() {

		      @Override
		      public void buttonClick(ClickEvent event) {
		        increment();
		      }
		    });
		    rootLayout.addComponent(btn);
	  }

}