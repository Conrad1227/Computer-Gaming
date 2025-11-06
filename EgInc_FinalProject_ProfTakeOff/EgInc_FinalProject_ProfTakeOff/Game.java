import processing.core.*;
import processing.sound.*;

public class Game {
  protected boolean run;
  protected float xpos;
  protected float ypos;
  protected float speed;
  protected float diry;
  protected float dirx;
  protected PImage doodle;
  protected float count=0;
  protected float speedset;
  protected float[] asx= new float[8];
  protected float[] asy= new float[8];
  protected float[] starx= new float[20];
  protected float[] stary= new float[20];
  protected float[] stsize= new float[20];
  protected int score;
  protected PImage ast;
  protected PImage suit;
  protected int spot;
  protected double dif;
  protected int[] jetchance= new int[8];
  protected int hyper;
  protected float[] packx= new float[8];
  protected float[] packy= new float[8];
  protected PImage pack;
  protected boolean boost;
  protected int[] breakchance= new int[8];
  protected PImage astbreak;
  protected boolean leaderboard;
  protected int[] movechance= new int[8];
  //protected Table table= p.loadTable("Names_scores.csv", "header");
  protected int astdirx;
  protected boolean username;
  protected boolean b;
  //protected Soundfile jump;
  private PApplet p;
  private SoundFile jump;
  private SoundFile jet;

  public Game(PApplet p,SoundFile jump,SoundFile jet) {
    this.p=p;
    p.rectMode(p.CENTER);
    this.jump=jump;
    this.jet=jet;
    astbreak = p.loadImage("blackast.png");
    pack = p.loadImage("pack.png");
    suit = p.loadImage("suit.png");
    ast = p.loadImage("ast.png");
    doodle = p.loadImage("doodle.png");
    ypos=20;
    speedset=8;
    dirx=1;
    diry=1;
    speed=-1*(speedset);
    count=0;
    dif=0.018;
    hyper=1;
    astdirx=3;
    xpos=p.width/2;
    ypos=50;
    username=true;
    leaderboard=false;
    run=true;
  }

  void display() {
    if(run){
      if (ypos>p.height) {
        leaderboard=true;
      }
      p.background(52, 26, 71);
      p.imageMode(p.CENTER);

      //this has to reset when bounce on a platform
      ypos= ypos + speed;
      speed=speed+count;
      count+=dif;

      for (int i=0; i<asx.length; i++) {
        p.fill(255);
        p.noStroke();
        p.image(pack, packx[i], packy[i], 30, 30);
        p.ellipse(starx[i], stary[i], stsize[i], stsize[i]);
        if (breakchance[i]==2) {
          p.image(astbreak, asx[i], asy[i], 80, 30);
        } else {
          p.image(ast, asx[i], asy[i], 80, 30);
        }
        if (movechance[i]==2) {
          asx[i]+=astdirx;
          if (asx[i]>p.width-30 || asx[i]<30) {
            astdirx= astdirx*-1;
          }
        }

        if (speed<0 && ypos<p.height/2+p.height/8) {
          asy[i]= asy[i]-(speed*hyper);
          stary[i]=stary[i]-(speed);
          score= score+(1*hyper);
        }

        if (asy[i]>=p.height) {
          asx[i]=p.random(50, p.width-50);
          jetchance[i]=(int) p.random(0, 20);
          if (score>40000) {
            breakchance[i] = (int) p.random(0, 5);
            movechance[i] = (int) p.random(0, 5);
          } else  if (score>30000) {
            breakchance[i] = (int) p.random(0, 10);
            movechance[i] = (int) p.random(0, 10);
          } else  if (score>20000) {
            breakchance[i] = (int) p.random(0, 20);
            movechance[i] = (int) p.random(0, 20);
          } else if (score>10000) {
            breakchance[i] = (int) p.random(0, 25);
            movechance[i] = (int) p.random(0, 25);
          } else
            breakchance[i] = (int) p.random(0, 30);
          movechance[i] = (int) p.random(0, 30);


          if (i==0) {
            asy[i]=p.random(-50, 0);
          } else if (asy[i-1]<0) {
            asy[i]=asy[i-1]-p.random((score/500), (score/500)+200);
          } else {
            asy[i]=p.random(-50, 0);
          }
        }

        if (boost) {
          hyper=10;
          jet.play();
          boost=false;
        }

        if (jetchance[i]==10) {
          packx[i]=asx[i];
          packy[i]=asy[i]-30;
          if (p.dist(xpos, ypos+30, packx[i], packy[i])<=20) {
            boost=true;
            packx[i]=-50;
          }
        } else {
          packx[i]=-50;
          packy[i]=-50;
        }

        if (stary[i]>p.height) {
          starx[i]=p.random(50, p.width-50);
          stary[i]=0;
          stsize[i]=p.random(10);
        }

        if ((ypos>=asy[i]-80 && xpos>=asx[i]-60 && xpos<=asx[i]+60 && ypos<=asy[i]-40 && speed>=0)) {
          
          if (breakchance[i]==2) {
            speed = -speedset;
            jump.play();
            count=0;
            hyper=1;
            asx[i]=-50;
          } else {
            speed = -speedset;
            count=0;
            hyper=1;
          }
        }

        p.fill(255);
        p.text(score, 50, 50);
      }

      xpos+=dirx;

      if (xpos>=p.width+21) {
        xpos=-20;
      } else if (xpos<=-21) {
        xpos=p.width+20;
      }

      if (p.keyPressed) {
        if (p.keyCode==p.LEFT) {
          dirx=-5;
        } else if (p.keyCode==p.RIGHT) {
          dirx=5;
        }
      } else {
        dirx=0;
      }


      if (asy.length>=4) {
        if (score%10000<=10 && score>10) {
          asy=p.shorten(asy);
          asx=p.shorten(asx);
          packx= p.shorten(packx);
          packy= p.shorten(packy);
          speedset=speedset+1;
          dif= dif+0.005;

          score=score+10;
        }
      }
      //jetpack image
      p.image(suit, xpos, ypos+28, 80, 100);
      prof();
  
    }
  }

  void setast() {


    for (int i=0; i<asx.length; i++) {
      asx[i]=p.random(50, p.width-50);
      p.fill(255);
      p.noStroke();
      starx[i]=p.random(50, p.width-50);
      stary[i]=p.random(0, p.height);
      stsize[i]=p.random(0, 10);
      if (i>=1) {
        asy[i]=asy[i-1]-p.random(50, 200);
      } else {
        asy[i]=p.random(p.height/2, p.height);
      }
    }
  }

  void prof() {
    p.strokeWeight(1);
    p.fill(222, 207, 181);
    p.stroke(0);
    p.ellipse(xpos-20, ypos, 5, 10);
    p.ellipse(xpos+21, ypos, 5, 10);
    p.ellipse(xpos, ypos, 40, 55);
    p.fill(57, 38, 4);
    p.noStroke();
    p.ellipse(xpos, ypos-21, 25.50f, 12.0f);
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
  

public boolean lose(boolean a){
  if(ypos>p.height){
    b=true;
  }else if(a==false){
      b=a;
    }
  
  if(b){
    return true;
  }else{
    return false;
  }
}

public int score(){
  return score;
}

void reset(){
  run=false;
  ypos=0;
  score=0;
}

void run(){
 run=true; 
}


}
