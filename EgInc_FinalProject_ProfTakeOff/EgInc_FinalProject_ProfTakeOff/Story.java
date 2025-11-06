import processing.core.*;

public class Story {
  protected int xpos ;
  protected float ypos;
  protected int top = 0;
  protected int delay10 = 10000;
  protected PImage space;
  private PApplet p;
  protected boolean b;
  protected boolean a;

  Story(PApplet p) {
    this.p=p;
    xpos = (p.width*5)/11;
    ypos = p.height+300;
  }

  public void setupstory() {
    p.size(500, 600);
  }

  public void drawstory() {
    space = p.loadImage("space2.png");
    //imageMode(CENTER);
    //image(space, xpos, ypos,400,400);
    space.resize(500, 600);
    p.background(space);
    ypos = ypos-1.75f;
    storywords();
    if (ypos <= 90) {
      a= true;
    } else {
      a= false;
    }
  }

  public boolean drawstory2(boolean f) {
    if(f==false){
      a=f;
    }
    if (a) {
      return true;
    } else {
      return false;
    }
  }


  public void storywords() {
    p.fill(255);
    p.textSize(20);
    p.text("Once upon a time Prof was working", xpos-175, ypos-280);
    p.text("on the ultimate code when suddenly", xpos-175, ypos-260);
    p.text("there was a crash and the servers", xpos-175, ypos-240);
    p.text("for Processing got launched far", xpos-175, ypos-220);
    p.text("out into space. Now, Prof is on", xpos-175, ypos-200);
    p.text("the mission to retrieve them so", xpos-175, ypos-180);
    p.text("that he is able to teach his favorite", xpos-175, ypos-160);
    p.text("computer science class. The only", xpos-175, ypos-140);
    p.text("way to save the day is by bouncing", xpos-175, ypos-120);
    p.text("on asteroids. Prof to the rescue!", xpos-175, ypos-100);
    //text("the rescue!", xpos-175, ypos-80);
    //if (millis() >= delay10) {
    //  instructionpage = true;
    //if (ypos == 0) {
    //  instructionpage = true;
  }
}
