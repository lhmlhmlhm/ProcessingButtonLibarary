package HaomingsGUI.library;
import processing.core.*;

public class GUIMaker extends PImage {
	public static class ImageButton extends GUIComponent {
	private PImage myImage;
	
	public ImageButton(PApplet newParent, PImage newImage, int newX, int newY, boolean newVisible) {
		this(newParent, newImage, newX, newY, newImage.width, newImage.height, newVisible);
	}
	
	public ImageButton(PApplet newParent, PImage newImage, int newX, int newY) {
		this(newParent, newImage, newX, newY, newImage.width, newImage.height, true);
	}

	public ImageButton(PApplet newParent, PImage newImage, int newX, int newY, int newW, int newH, boolean newVisible) {
		parent = newParent;
		myImage = newImage;
		setVisible(newVisible);
		setSize(newW, newH);
		setPosition(newX, newY);
		setAutoDraw(true);
		parent.registerMethod("mouseEvent", this);
	}
	
	public void display() {
		if(visible) {
			parent.image(myImage, x, y);
		}
	}
	
	public void setAutoDraw(boolean set) {
		if(set) {
			if(!setAutoDraw)parent.registerMethod("draw", this);
		} else parent.unregisterMethod("draw", this);
		setAutoDraw = set;
	}
	
	public void draw() {
		if(visible) {
			if(setAutoDraw) {
				parent.image(myImage, x, y);
			}
		}
	}
}
/////////----------------------------------------------------------------------
	public static class GIF extends GUIComponent {
	private PImage[] myImage;
	private int frameInterval;
	private int frameCount;
	private boolean isOn = false;
	private int myIndex = 0;
	
	public GIF(PApplet newParent, PImage[] newImages, int newX, int newY, int newFrameInterval) {
		this(newParent, newImages, newX, newY, newImages[0].width, newImages[0].height, newFrameInterval, true);
	}
	public GIF(PApplet newParent, PImage[] newImages, int newX, int newY, int newW, int newH, int newFrameInterval, boolean newVisible) {
		parent = newParent;
		myImage = newImages;
		frameInterval = newFrameInterval;
		setVisible(newVisible);
		setSize(newW, newH);
		setPosition(newX, newY);
		setAutoDraw(true);
		parent.registerMethod("mouseEvent", this);
	}
	
	public void display() {
		if(visible) {
			timer();
		}
	}
	
	public void draw() {
		if(visible) {
			if(setAutoDraw) {
				timer();
			}
		}
	}
	
	private void timer() {
		if(!isOn) {
			startTimer(parent.frameCount);
		}
		
		if(finish()) {
			myIndex ++;
			if(myIndex >= myImage.length) myIndex = 0;
		}
		
		parent.image(myImage[myIndex], x, y);
	}
	
	private void startTimer(int newFrameCount) {
		frameCount = newFrameCount;
		isOn = true;
	}
	
	private boolean finish() {
		if(parent.frameCount - frameCount > frameInterval) {
			isOn = false;
			return true;
		}else return false;
	}
	
	public void setFrameInterval(int newFrameInterval) {
		frameInterval = newFrameInterval;
	}
	
	public int getFrameInterval() {
		return frameInterval;
	}
	
	public void setAutoDraw(boolean set) {
		if(set) {
			if(!setAutoDraw)parent.registerMethod("draw", this);
		}else parent.unregisterMethod("draw", this);
		setAutoDraw = set;
	}
}
}
