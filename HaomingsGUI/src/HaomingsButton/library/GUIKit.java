package HaomingsGUI.library;
import processing.core.*;

/**
 * This is a template class and can be used to start a new processing Library.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own Library naming convention.
 * 
 * (the tag example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 * @example Hello 
 */

public class GUIKit extends GUIComponent{
	public PApplet parent;
	
	public GUIKit(PApplet newParent) {
		parent = newParent;
	}

}

