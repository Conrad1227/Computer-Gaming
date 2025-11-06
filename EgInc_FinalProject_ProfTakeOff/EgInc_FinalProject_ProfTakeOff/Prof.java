import processing.core.*;

public class Prof {
  private int xpos;
  private int ypos;
  protected PImage space;
  private PApplet p;
  protected PFont font2;
  protected boolean a;
  //boolean storypage = false;

  Prof(PApplet p, PFont font2) {
    this.p=p;
    xpos = (p.width*7)/10;
    ypos = (p.height*5)/11;
    this.font2 = font2;
  }

  public void setupprof() {
    p.size(500, 600);
    //font2 = createFont("Copperplate", 16);
  }

  public void drawprof() {
    space = p.loadImage("space2.png");
    //imageMode(CENTER);
    //image(space, xpos, ypos,400,400);
    space.resize(500, 600);
    p.background(space);
    //background(254, 255, 201);
    //if (p.keyPressed) {
    //  storypage = true;
    //}
    rocket();
    prof();
    textprof();
    takeoff();
    cs();
    presstext();
    storypage();
  }

  public boolean storypage() {
    
    if (p.keyPressed) {
      a=true;
    }
    if(a){
      return true;
    }else{
    return false;
    }
  }

  public void prof() {
    p.strokeWeight(1);
    p.fill(222, 207, 181);
    p.stroke(0);
    p.ellipse(xpos-20, ypos, 5, 10);
    p.ellipse(xpos+21, ypos, 5, 10);
    p.ellipse(xpos, ypos, 40, 55);
    p.fill(57, 38, 4);
    p.noStroke();
    p.ellipse(xpos, ypos-21f, 25.5f, 12f);
    p.stroke(57, 38, 4);
    p.strokeWeight(5);
    p.line(xpos-18, ypos-5, xpos-12, ypos-18);
    p.line(xpos+18, ypos-5, xpos+12, ypos-18);
    p.strokeWeight(1);
    p.fill(222, 207, 181);
    p.rectMode(p.CENTER);
    p.rect(xpos-7, ypos, 10, 6, 2);
    p.rect(xpos+7, ypos, 10, 6, 2);
    p.line(xpos-20, ypos-1, xpos-12, ypos-1);
    p.line(xpos+20, ypos-1, xpos+12, ypos-1);
    p.line(xpos-2, ypos-1, xpos+2, ypos-1);
    p.circle(xpos-6, ypos, 1);
    p.circle(xpos+6, ypos, 1);
    p.stroke(219, 113, 141);
    p.line(xpos-4, ypos+14, xpos+4, ypos+14);
    p.noStroke();
    p.fill(103, 97, 88, 130);
    p.ellipse(xpos, ypos+23, 20, 10);
    p.stroke(103, 97, 88, 130);
    p.strokeWeight(5);
    p.line(xpos-16, ypos+12, xpos-10, ypos+20);
    p.line(xpos+16, ypos+12, xpos+10, ypos+20);
    p.strokeWeight(3);
    p.line(xpos-8, ypos+11, xpos-3, ypos+10);
    p.line(xpos+8, ypos+11, xpos+3, ypos+10);
    p.stroke(0);
    p.strokeWeight(1);
    p.line(xpos, ypos+3, xpos-1, ypos+7);
    p.line(xpos-1, ypos+7, xpos+1, ypos+7);
  }

  public void rocket() {
    p.fill(247, 48, 17);
    p.beginShape();
    p.vertex(xpos-40, ypos+68);
    p.vertex(xpos-25, ypos+90);
    p.vertex(xpos-50, ypos+140);
    p.vertex(xpos-50, ypos+100);
    p.endShape(p.CENTER);

    p.beginShape();
    p.vertex(xpos+40, ypos+68);
    p.vertex(xpos+25, ypos+90);
    p.vertex(xpos+50, ypos+140);
    p.vertex(xpos+50, ypos+95);
    p.endShape(p.CENTER);

    p.noStroke();
    p.ellipse(xpos, ypos+150, 18, 60);
    p.ellipse(xpos-12, ypos+140, 10, 40);
    p.ellipse(xpos+12, ypos+140, 10, 40);
    p.fill(242, 145, 71);
    p.ellipse(xpos, ypos+130, 11, 70);
    p.ellipse(xpos-8, ypos+130, 10, 40);
    p.ellipse(xpos+8, ypos+130, 10, 40);
    p.fill(245, 242, 153);
    p.ellipse(xpos, ypos+130, 9, 40);
    p.ellipse(xpos-6, ypos+130, 6, 20);
    p.ellipse(xpos+6, ypos+130, 6, 20);

    p.stroke(0);
    p.fill(200);
    p.triangle(xpos, ypos+90, xpos-20, ypos+130, xpos+20, ypos+130);

    p.fill(247, 48, 17);
    p.ellipse(xpos, ypos-10, 100, 250);
    p.fill(200);
    p.ellipse(xpos, ypos-10, 75, 85);
    p.fill(255);
    p.ellipse(xpos, ypos-10, 65, 75);
    p.fill(200);
    p.triangle(xpos-30, ypos-110, xpos+30, ypos-110, xpos, ypos-160);
  }

  public void textprof() {
    p.fill(255);
    p.textFont(font2);
    p.textSize(73);
    p.text("PROF", xpos-279, ypos-60);//-30);
  }

  public void takeoff() {
    p.fill(255);
    p.textSize(40);
    p.text("TAKE-OFF", xpos-280, ypos-10); //+20);
  }

  public void cs() {
    p.fill(255);
    p.textSize(10);
    p.text("CS-104 Final Project Spring 2024", xpos-178, ypos+200);
  }

  public void presstext() {
    p.fill(255);
    p.textSize(10);
    p.text("(Press any key to continue!)", xpos-226, ypos+14);
  }
}
