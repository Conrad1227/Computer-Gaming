import processing.core.*;

public class Addin {
  private int xpos;
  private int ypos;
  protected int ry ;//height*2;
  protected int rw = 350;
  protected int rh = 100;
  protected int rx2;//width*5/2;
  protected PImage arrow;
  protected PImage space;
  protected PFont font1;
  private PApplet p;
  protected boolean c;

  Addin(PApplet p, PFont font1) {
    this.p=p;
    ry = ypos+80;
    xpos = p.width/2;
    ypos = p.height/2;
    rx2 = xpos-130;
    this.font1 = font1;
  }

  public void setupaddin() {
    p.size(500, 600);
  }

  public void drawaddin() {
    space = p.loadImage("space2.png");
    //imageMode(CENTER);
    //image(space, xpos, ypos,400,400);
    space.resize(500, 600);
    p.background(space);
    //instructionpage = false;
    addintext();
    continuel();
    p.fill(255);
    p.rectMode(p.CENTER);
    p.rect(xpos+155, ypos-225, 120, 70);
    arrow = p.loadImage("arrow.png");
    arrow.resize(100, 50);
    p.imageMode(p.CENTER);
    p.image(arrow, xpos+155, ypos-225);
    p.noFill();
    p.stroke(156, 245, 177);
    p.strokeWeight(3);
    p.circle(xpos+120, ypos-212, 30);
    p.circle(xpos+190, ypos-212, 30);
  }

  public void addintext() {
    p.fill(255);
    p.textFont(font1);
    p.textSize(20);
    p.text("How to play:", xpos-210, ypos-240);
    p.textSize(14);
    p.text("1. Press the arrow keys on your keyboard", xpos-210, ypos-210);
    p.text("to move Prof right and left.", xpos-200, ypos-195);
    p.text("2. Bounce on the asteroids", xpos+50, ypos-75);
    p.text("to earn as many", xpos+65, ypos-60);
    p.text("points as possible.", xpos+65, ypos-45);
    p.text("Use jetpacks for boost!", xpos+65, ypos-30);
    p.text("Finally, beware of black", xpos+65, ypos-15);
    p.text("asteroids as they break", xpos+65, ypos);
    p.text("after one jump.", xpos+65, ypos+15);
    p.text("3. Try not to miss the asteroids", xpos-210, ypos+115);
    p.text("or Prof will fall to the ground", xpos-200, ypos+130);
    p.text("and you will lose the game.", xpos-200, ypos+145);
  }

  public void continuel() {
    p.fill(255);
    p.rect(rx2-30, ry+450, rw/4, rh/2);
    p.fill(0);
    p.textFont(font1);
    p.textSize(15);
    p.text("Continue", (rx2+20.5f-(rw/4.5f)), ry+405+(rh/2f));
  }
  public boolean continuec(boolean b) {
    if ((p.dist(p.mouseX, p.mouseY, rx2-30-(rw/4), ry+450+(rh/2)))<= (rw/2)) {
      if (p.mousePressed) {
        c=true;
      }
    }else if(b==false){
      c=b;
    }
    if (c) {
      return true;
    } else {
      return false;
    }
  }
}
