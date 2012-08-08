package com.arapov.ui;

import com.vaadin.ui.Tree;

public class NavigationTree extends Tree {

	public static final Object SHOW_ALL = "Show All";
	public static final Object SEARCH = "Search";
	
	public NavigationTree() {
		addItem( SHOW_ALL );
		addItem( SEARCH );
	}
}
