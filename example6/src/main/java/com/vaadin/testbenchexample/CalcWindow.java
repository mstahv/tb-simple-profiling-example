package com.vaadin.testbenchexample;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

class CalcWindow extends Window {
	  private VerticalLayout rootLayout;

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

	    lbl = new Label("<hr>", Label.CONTENT_XHTML);
	    lbl.addStyleName("cd-divider");
	    rowLayout.addComponent(lbl);

	    return rowLayout;
	  }

    public CalcWindow() {
	    rootLayout = new VerticalLayout();
	    rootLayout.setSizeUndefined();
	    setContent(rootLayout);

	    Button btn = new Button("Get more data now");
	    btn.setDebugId("getmore");
	    btn.addListener(new Button.ClickListener() {

	      @Override
	      public void buttonClick(ClickEvent event) {
	        onGetMoreDataClick();
	      }
	    });
	    rootLayout.addComponent(btn);

    }

}