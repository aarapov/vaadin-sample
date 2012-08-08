/*
 * Copyright 2009 IT Mill Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.arapov;

import com.arapov.data.PersonContainer;
import com.arapov.ui.HelpWindow;
import com.arapov.ui.ListView;
import com.arapov.ui.NavigationTree;
import com.arapov.ui.PersonForm;
import com.arapov.ui.PersonList;
import com.vaadin.Application;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.SplitPanel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class MyVaadinApplication extends Application implements Property.ValueChangeListener {
    private Button newContact = new Button ( "Add contact" );
    private Button search = new Button ( "Search" );
    private Button share = new Button ( "Share" );
    private Button help = new Button ( "Help" );
    private HorizontalSplitPanel horizontalSplit = new HorizontalSplitPanel();
    private NavigationTree tree = new NavigationTree();
    private ListView list = null;
    private PersonList personList = null;
    private PersonForm personForm = null;
    private HelpWindow helpWindow = null;
    private PersonContainer dataSource = PersonContainer.createWithTestData();

    @Override
    public void init()
    {
    	setTheme( "runo" );
    	buildMainLayout();        
    }
    
    private void buildMainLayout() {
    	 setMainWindow(new Window("Address Book Demo application"));
         VerticalLayout layout = new VerticalLayout();
         layout.setSizeFull();
                
         layout.addComponent(createToolBar());
         layout.addComponent(horizontalSplit);

        /* Allocate all available extra space to the horizontal split panel */

        layout.setExpandRatio(horizontalSplit, 1);
        /* Set the initial split position so we can have a 200 pixel menu to the left */

        horizontalSplit.setSplitPosition(200, SplitPanel.UNITS_PIXELS);
        horizontalSplit.setFirstComponent( tree );
        setMainComponent( getListView() );

        getMainWindow().setContent(layout);
        getMainWindow().addWindow( getHelpWindow() );
    }
    
    private HorizontalLayout createToolBar() {
    	HorizontalLayout layout = new HorizontalLayout();
    	
    	layout.addComponent( newContact );
    	layout.addComponent( search );
    	layout.addComponent( share );
    	layout.addComponent( help );
    	
    	return layout;
    }

    private ListView getListView() {
    	if (list == null) {
    		personList = new PersonList( this );
    		personForm = new PersonForm();
    		list = new ListView( personList, personForm );
    	}
    	
    	return list;
    }
    
    private HelpWindow getHelpWindow() {
    	if ( helpWindow == null ) {
    		helpWindow = new HelpWindow();
    	}
    	
    	return helpWindow;
    }
    
    private void setMainComponent( Component c ) {
    	horizontalSplit.setSecondComponent( c );
    }
    
    public PersonContainer getDataSource() {
    	return this.dataSource;
    }

	public void valueChange(ValueChangeEvent event) {
		 Property property = event.getProperty();
         if (property == personList) {
             Item item = personList.getItem(personList.getValue());
             if (item != personForm.getItemDataSource()) {
                 personForm.setItemDataSource(item);
            }
         }
	}
}
