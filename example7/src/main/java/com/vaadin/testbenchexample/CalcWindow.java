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
	  private VerticalLayout rootLayout;

	  /*
	   * (non-Javadoc)
	   * 
	   * @see com.vaadin.ui.UI#init(com.vaadin.server.VaadinRequest)
	   */
	  @Override
	  protected void init(VaadinRequest request) {

	    rootLayout = new VerticalLayout();
	    rootLayout.setSizeUndefined();
	    setContent(rootLayout);

	    Button btn = new Button("Get more data now");
	    btn.setId("getmore");
	    btn.addClickListener(new Button.ClickListener() {

	      @Override
	      public void buttonClick(ClickEvent event) {
	        onGetMoreDataClick();
	      }
	    });
	    rootLayout.addComponent(btn);

	  }

	  private void onGetMoreDataClick() {

	    CssLayout dataRows = new CssLayout();
	    dataRows.setSizeUndefined();

	    for (int i = 0; i < 50; ++i) {
	      dataRows.addComponent(initDataRow());
	    }

	    rootLayout.addComponent(dataRows);
	  }

	  private Component initDataRow() {
	    CssLayout rowLayout = new CssLayout();
	    rowLayout.addStyleName("cd-fileepisodepanel");
	    rowLayout.setSizeUndefined();

	    Button btn = new Button("Program title");
	    btn.addStyleName("cd-link cd-program");
	    rowLayout.addComponent(btn);

	    CssLayout episodeLayout = new CssLayout();
	    episodeLayout.setSizeUndefined();
	    episodeLayout.addStyleName("cd-episode");
	    rowLayout.addComponent(episodeLayout);

	    btn = new Button("Data sub title");
	    btn.addStyleName("cd-link strong");
	    episodeLayout.addComponent(btn);

	    Label lbl = new Label("Some more information about the file.");
	    episodeLayout.addComponent(lbl);

	    btn = new Button("Expand data details...");
	    btn.setSizeUndefined();
	    btn.addStyleName("cd-mini cd-fileinfo-expand");
	    rowLayout.addComponent(btn);

	    lbl = new Label("<hr>", ContentMode.HTML);
	    lbl.addStyleName("cd-divider");
	    rowLayout.addComponent(lbl);

	    return rowLayout;
	  }

}