import processing.core.*;

public class Instructions {
  protected int xpos;
  protected int ypos;
  protected int ry;
  protected int rw = 250;
  protected int rh = 70;
  protected int rx2 = xpos-130;
  protected PImage space;
  protected PFont font1;
  private PApplet p;
  protected boolean b;

  Instructions(PApplet p, PFont font1) {
    this.p=p;
    xpos = p.width/2;
    ypos = p.height/2;
    ry = ypos+80;
    this.font1 = font1;
  }

  public void setupinstructions() {
    p.size(500, 600);
  }

  public void drawinstructions() {
    p.background(225, 236, 250);
    //storypage = false;
    additional();
    instructionstext();
    //additional();
    //call methods
  }

  public void instructionstext() {
    p.fill(0);
    p.textFont(font1);
    p.textSize(30);
    p.text("Instructions:", xpos-175, ypos-120);
    p.textSize(20);
    p.text("Use the arrow buttons on your keyboard", xpos-175, ypos-60);
    p.text("to move Prof right and left. Use the", xpos-175, ypos-40);
    p.text("asteroids to bounce up Prof as high into", xpos-175, ypos-20);
    p.text("space as possible. If Prof misses an", xpos-175, ypos);
    p.text("asteroid he will fall out of space.", xpos-175, ypos+20);
  }

  public void additional() {
    //space = loadImage("space2.png");
    //imageMode(CENTER);
    //image(space, rx2+130, ry+30);
    //space.resize(20, 30);
    p.fill(67, 61, 167);
    p.rect(rx2+370, ry+30, rw, rh);
    p.fill(255);
    p.textFont(font1);
    p.textSize(15);
    p.text("Additonal Instructions", (rx2+245+(rw/4.5f)), (ry+(rh/2f)));
  }

  public boolean addinstrucpage(boolean c) {
    if ((p.dist(p.mouseX, p.mouseY, rx2+180+(rw/2), ry+30+(rh/2)))<= (rw/2)) {
      if (p.mousePressed) {
        b=true;
      }
    }else if(c==false) {
      b=c;
    }
    if (b) {
      return true;
    } else {
      return false;
    }
  }
}
