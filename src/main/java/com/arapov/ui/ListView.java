package com.arapov.ui;

import com.vaadin.ui.VerticalSplitPanel;

public class ListView extends VerticalSplitPanel {
	
	public ListView( PersonList list, PersonForm form ) {
		setFirstComponent( list );
		setSecondComponent( form );
		setSplitPosition(40);
	}
}
