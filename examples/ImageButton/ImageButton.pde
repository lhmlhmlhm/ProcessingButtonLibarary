import HaomingsGUI.library.*;
PImage img;
//
//Step 1:
GUIMaker.ImageButton maker;
//
int num = 10;
boolean move = false;

void setup() {
  size(400, 400);
  img = loadImage("img.png");
  
  //
  //Step 2:
  //new ImageButtonMaker.ImageButton(this, PImage, X position, Y position);
  maker = new GUIMaker.ImageButton(this, img, 150, 150);
  
  //maker.setAutoDraw(true); //you do not need to call display() and it is default
  //maker.setAutoDraw(false); //you need to call display() in draw() by yourself
  //
  
  //Step 3(Optional): add click function (call when mouse release)
  //  maker.addClickAction(new ButtonAction() {
  //  void action() {
  //     write code here
  //  }
  //}
  //);
  maker.addClickAction(new ButtonAction() {
    void action() {
      move = !move;
      if (move) maker.setPosition(100, 150);
      else maker.setPosition(150, 150);
    }
  }
  );
  
  //
  //Step 4(Optional): add hover function (call when hovering the button)
  //  maker.addHoverStartAction(new ButtonAction() {
  //  void action() {
  //     write code here
  //  }
  //}
  maker.addHoverStartAction(new ButtonAction() {
    void action() {
      num = 100;
    }
  }
  );
  
  //
  //Step 5(Optional): add click end function (call when cursor leaving the button)
  //  maker.addHoverEndAction(new ButtonAction() {
  //  void action() {
  //     write code here
  //  }
  //}
  //);
  maker.addHoverEndAction(new ButtonAction() {
    void action() {
      num = 10;
    }
  }
  );
}

void draw() {
  background(num);
  //you can decide which layar you want to put it, but you have to set maker.setAutoDraw(false);
  //maker.display();
}

//other functions
//maker.setPosition(int, int) //set postion X and Y
//maker.getPosition() return int[]{x, y}//get postion X and Y
//maker.setVisible(boolean) //set visible
//maker.getVisible() return boolean//get visible
