package com.rapidftr.screens;

import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.Menu;

import net.rim.device.api.ui.component.SeparatorField;

import com.rapidftr.controllers.ViewChildrenController;
import com.rapidftr.model.Child;
import com.rapidftr.model.ChildrenListField;

public class ViewChildrenScreen extends CustomScreen {
  

	  
    private ChildrenListField childrenListField;
    private Child[] childrenArray;

    public ViewChildrenScreen() {
        super();
        layoutScreen();
    }

    private void layoutScreen() {
        add(new LabelField("All children"));
        add(new SeparatorField());
        childrenListField = new ChildrenListField() {
            protected boolean navigationClick(int i, int i1) {
                Child child = (Child) this.get(this, this.getSelectedIndex());
                ((ViewChildrenController) controller).showChild(child);
                return super.navigationClick(i, i1);   
            }
            
        };
        add(childrenListField);
    }

    public void setChildren(Child[] children) {
    	
    	childrenArray=children;
    	childrenListField.set(children);
    
    }

	public void cleanUp() {
		// TODO Auto-generated method stub
		
	}

	public void setUp() {
		// TODO Auto-generated method stub
		
	}
	protected void makeMenu(Menu menu, int instance) {
		MenuItem editChildMenu = new MenuItem("Open Record", 1, 1) {
			public void run() {
				int selectedIndex = childrenListField.getSelectedIndex();
				Child child = (Child) childrenListField.get(childrenListField, selectedIndex);
				((ViewChildrenController) controller).viewChild(child);
			}
		};
		menu.add(editChildMenu);
	}
	
	protected void onExposed()
	{
	//	Child[] children=((ViewChildrenController)controller).getAllStoredChildren();
		setChildren(childrenArray);
	}
}
