package com.arapov.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

public class PersonForm extends Form {

	private Button save = new Button ( "Save" );
	private Button cancel = new Button ( "Cancel" );
	
	public PersonForm () {
		addField( "First Name", new TextField( "First Name" ) );
		addField( "Second Name", new TextField( "Second Name" ) );
		
		HorizontalLayout footer = new HorizontalLayout();
		footer.setSpacing( true );
		footer.addComponent( save );
		footer.addComponent( cancel );
		setFooter( footer );
	}
}
