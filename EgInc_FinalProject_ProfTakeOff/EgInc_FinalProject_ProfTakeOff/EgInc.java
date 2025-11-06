import processing.core.*;
import processing.sound.*;

public class EgInc {
  private int xpos;
  private int ypos;
  protected PFont font1;
  protected int delay = 2000;
  protected int delay2 = 3000;
  protected int delay3 = 4000;
  protected int delay4 = 5000;
  protected int delay5 = 6000;
  protected int delay6 = 7000;
  protected int delay7 = 8000;
  protected int delay8 = 9000;
  //int delay9 = 12000;
  //import processing.sound.*;
  private SoundFile cracksong;
  private SoundFile chicksong;
  protected boolean done = false;
  protected boolean done2 = false;
  protected boolean done3 = false;
  protected boolean done4 = false;
  protected boolean done5 = false;
  protected boolean done6 = false;
  protected boolean profpage = false;
  private PApplet p;


  EgInc (PApplet p, SoundFile cracksong, SoundFile chicksong, PFont font1) {
    this.p=p;
    xpos = p.width/2;
    ypos = p.height/2;
    this.cracksong = cracksong;
    this.chicksong = chicksong;
    this.font1 = font1;
  }

  public void setup() {
    p.size(500, 600);
    font1 = p.createFont("BM Jua", 16);
  }

  public void draw() {
    p.background(225, 236, 250);
    //call methods
    display1();
    if (p.millis() >= delay) {
      crack1();
    }
    if (p.millis() >= delay2) {
      crack2();
    }
    if (p.millis() >= delay3) {
      crack3();
    }
    if (p.millis() >= delay4) {
      crack4();
    }
    if (p.millis() >= delay5) {
      display2();
    }
    if (p.millis() >= delay6) {
      chick();
    }
    if (p.millis() >= delay7) {
      eg();
    }
    if (p.millis() >= delay8) {
      inc();
    }
  }

  public void display1() {
    p.stroke(2);
    p.fill(255);
    p.ellipse(xpos, ypos, 100, 150);
  }

  public void crack1() {
    p.stroke(2);
    p.line(xpos-50, ypos, xpos-25, ypos+15);
    if (!done) {
      cracksong.play();
    }
    done = true;
  }

  public void crack2() {
    p.line(xpos-25, ypos+15, xpos, ypos);
    if (!done2) {

      cracksong.play();
    }
    done2 = true;
  }

  public void crack3() {
    p.line(xpos, ypos, xpos+25, ypos+15);
    if (!done3) {
      cracksong.play();
    }
    done3 = true;
  }

  public void crack4() {
    p.line(xpos+25, ypos+15, xpos+50, ypos);
    if (!done4) {
      cracksong.play();
    }
    done4 = true;
  }

  public void display2() {
    p.fill(255);
    p.ellipse(xpos, ypos, 100, 150);
    p.noStroke();
    p.fill(225, 236, 250);
    p.rectMode(p.CENTER);
    p.rect(xpos, ypos-50, 200, 100);
    p.stroke(2);
    p.line(xpos-50, ypos, xpos-25, ypos+15);
    p.line(xpos-25, ypos+15, xpos, ypos);
    p.line(xpos, ypos, xpos+25, ypos+15);
    p.line(xpos+25, ypos+15, xpos+50, ypos);
    p.noStroke();
    p.fill(225, 236, 250);
    p.triangle(xpos-50, ypos, xpos-25, ypos+15, xpos, ypos);
    p.triangle(xpos, ypos, xpos+25, ypos+15, xpos+50, ypos);
    if (!done5) {
      cracksong.play();
    }
    done5 = true;
  }


  public void chick() {
    p.fill(250, 225, 96);
    p.stroke(0);
    p.ellipse(xpos-25, ypos, 25, 10);
    p.ellipse(xpos+25, ypos, 25, 10);
    p.ellipse(xpos, ypos, 50, 75);
    p.noStroke();
    p.fill(255);
    p.rectMode(p.CENTER);
    p.rect(xpos, ypos+30, 50, 30);
    p.noStroke();
    p.fill(255);
    p.triangle(xpos-25, ypos+15, xpos, ypos, xpos+25, ypos+15);
    p.stroke(2);
    p.line(xpos-25, ypos+15, xpos, ypos);
    p.line(xpos, ypos, xpos+25, ypos+15);
    p.fill(245, 173, 119);
    p.triangle(xpos-10, ypos-15, xpos+10, ypos-15, xpos, ypos-8);
    p.circle(xpos-8, ypos-20, 2);
    p.circle(xpos+8, ypos-20, 2);
    if (!done6) {
      chicksong.play();
    }
    done6 = true;
  }

  public void eg() {
    p.fill(250, 225, 96);
    p.textFont(font1);
    p.textSize(75);
    p.text("Eg.", xpos-120, ypos-80);
  }

  public void inc() {
    p.fill(250, 225, 96);
    p.textSize(75);
    p.text("Inc.", xpos+20, ypos-80);
  }
}
