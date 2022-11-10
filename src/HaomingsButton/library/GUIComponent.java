package HaomingsGUI.library;
import processing.core.*;
import processing.event.*;

public abstract class GUIComponent{
	protected int x, y, w, h;
	protected boolean visible;
	protected boolean clicked = false;
	protected boolean hover = false;
	protected ButtonAction myClickAct;
	protected ButtonAction myHoverStartAct;
	protected ButtonAction myHoverEndAct;
	protected boolean setAutoDraw;
	protected PApplet parent;
	//protected GUIKit kit;
	private boolean ifHaveHoverStartAction = false;
	private boolean ifHaveHoverEndAction = false;
	
	public GUIComponent () {
	}
	
	public void setSize(int newWidth, int newHeight) {
		if (newHeight > 0 && newWidth > 0) {
			h = newHeight;
			w = newWidth;
		}
	}
	
	public void setPosition(int newX, int newY) {
		if (newX >= 0 && newY >= 0) {
			x = newX;
			y = newY;
		}
	}
	
//	public void setButtonImage(PImage newImage) {
//		myImage = newImage;
//	}
	
	public void setVisible(boolean newVisible) {
		visible = newVisible;
	}
	
	public int[] getSize() {
		int[] result = {x, y};
		return result;
	}
	
	public int[] getPosition() {
		int[] result = {w, h};
		return result;
	}
	
//	public PImage getButtonImage() {
//		return myImage;
//	}
	
	public boolean getVisible() {
		return visible;
	}
	
	
	public void mouseEvent (MouseEvent e) {
		if (isMouseOver (e.getX(), e.getY())) {
			hover = true;
			if(ifHaveHoverStartAction) FireHoverStartAction();
			if (e.getAction() == MouseEvent.PRESS) {
				clicked = true;
			}
		} else {
			if(hover && ifHaveHoverEndAction) FireHoverEndAction();
			hover = false;
		}
		
		if (e.getAction() == MouseEvent.RELEASE) {
			if (clicked) {
				FireClickAction();
				clicked = false;
			}
		}
	}
	
	public boolean isMouseOver (int mouseX, int mouseY) {
		return ((mouseX >= x) && (mouseY >= y) && (mouseX <= (x + w)) && (mouseY <= (y + h)));
	}
	
	public void addClickAction(ButtonAction newAct) {
		myClickAct = newAct;
	}
	
	public void addHoverStartAction(ButtonAction newAct) {
		myHoverStartAct = newAct;
		ifHaveHoverStartAction = true;
	}
	
	public void addHoverEndAction(ButtonAction newAct) {
		myHoverEndAct = newAct;
		ifHaveHoverEndAction = true;
	}
	
	public void FireClickAction() {
		myClickAct.action();
	}
	
	public void FireHoverStartAction() {
		myHoverStartAct.action();
	}
	
	public void FireHoverEndAction() {
		myHoverEndAct.action();
	}
	
	public void draw() {

	}

}
