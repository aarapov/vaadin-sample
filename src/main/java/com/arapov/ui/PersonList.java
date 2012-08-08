package com.arapov.ui;

import com.arapov.MyVaadinApplication;
import com.arapov.data.PersonContainer;
import com.vaadin.data.Property;
import com.vaadin.ui.Table;

public class PersonList extends Table {

	public PersonList( MyVaadinApplication app ) {
		
//		setVisibleColumns(PersonContainer.NATURAL_COL_ORDER);
//		setColumnHeaders(PersonContainer.COL_HEADERS_ENGLISH);
		
		setSizeFull();		
		setContainerDataSource( app.getDataSource() );
		setSelectable(true);
		setImmediate(true);
//		addListener((Property.ValueChangeListener) app);
		setNullSelectionAllowed(false);
	}
}
