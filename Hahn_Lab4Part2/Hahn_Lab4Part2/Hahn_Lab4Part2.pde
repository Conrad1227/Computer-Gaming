import processing.sound.*;

//create arrays
int[] xpos = new int[1];
int[] ypos = new int[1];

//declare variables
int dirx=15;
int diry=0;
int points;
int appx, appy;
PImage apple;
SoundFile hiss;
SoundFile eat;
SoundFile lose;
boolean eating=false; 
boolean hissing=false;
boolean lost=false;
int x,y;
 boolean strtscrn;
 boolean gameover=false;


void setup() {
  //import sound files
  hiss = new SoundFile(this,"hiss.mp3");
  eat = new SoundFile(this,"eat.mp3");
  lose = new SoundFile(this,"lose.mp3");
 points=0;
 //set size
  size(500, 500);
  //load apple
  apple = loadImage("Apple.png");
  //set the arrays back to length 1
  for(int i=xpos.length;i>1;i--){
  xpos=shorten(xpos);
  ypos=shorten(ypos);
  }
  //reset pos of snake head
  xpos[0]=width/2;
  ypos[0]=height/2;
  //change modes to center
  rectMode(CENTER);
  imageMode(CENTER);
  //apple spawn
  apple.resize(20, 20);
  //randomize location
  appx=(int)random(width);
  appy=(int)random(height);
  //enable start screen
 strtscrn=true;
 //disable game over
 gameover=false;
}


void draw() {
  background(65);
//instructions for game
  if (strtscrn) {
    fill(255);
    stroke(0);
    textSize(20);
    text("Move the snake to collect apples and score points", 20, 100);
    text("Use the arrow keys to choose direction", 20, 120);
    text("Each apple you eat grows your snake", 20, 140);
    text("Select Your Difficulty", width/2-75, height/2);
    //easy button
    textSize(15);
    fill(255);
    ellipse(width/2-100, height/2+100, 75, 75);
    fill(0);
    text("Easy", width/2-110, height/2+100);
    //medium button
    fill(255);
    ellipse(width/2, height/2+100, 75, 75);
    fill(0);
    text("Medium", width/2-25, height/2+100);
    //hard button
    fill(255);
    ellipse(width/2+100, height/2+100, 75, 75);
    fill(0);
    text("Hard", width/2+90, height/2+100);
   //if buttons are pressed
    if (dist(mouseX, mouseY, width/2-100, height/2+100)<=150) {
      if (mousePressed) {
        frameRate(5);
        strtscrn= false;
      }
    }
    if (dist(mouseX, mouseY, width/2+100, height/2+100)<=150) {
      if (mousePressed) {
        frameRate(20);
        strtscrn =false;
      }
    }
    if (dist(mouseX, mouseY, width/2, height/2+100)<=150) {
      if (mousePressed) {
        frameRate(10);
        strtscrn= false;
      }
    }
  } else if(gameover){
    //gameover screen
    textSize(30);
    fill(255);
    
    text("GAME OVER",width/2-60,height/2-60);
    text("Points " + points,width/2-60,height/2-20);
    rect(width/2,height/2+150,100,100);
    fill(0);
    textSize(15);
    text("Restart",width/2-30,height/2+150);
    //restart button
    if(mouseX>=(width/2-50) && mouseX<=(width/2+50) && mouseY>=(height/2)+100 && mouseY<=(height/2)+200){
    //if the button is pressed run setup
    if(mousePressed){
      setup();
    }   
    }
    
  }else {
    //run rest of code
    //bring in image of apple
    image(apple, appx, appy);
    fill(255);
    text("Points " + points, 40, 40);

    for (int i=0; i < xpos.length-1; i++) {
      xpos[i]= xpos[i+1];
      ypos[i]= ypos[i+1];
    }
//set last index of both arrays to itself +direction
    xpos[xpos.length-1]+=dirx;
    ypos[ypos.length-1]+=diry;

//draw each part of snake
    for (int i=0; i < xpos.length; i++) {
      if (i==xpos.length-1) {
       //draw head of snake
       fill(#11D63D);
       stroke(#11D63D);
       ellipse(xpos[i]-(diry/2),ypos[i]-(dirx/2),20,20);
       ellipse(xpos[i]+(diry/2),ypos[i]+(dirx/2),20,20);
       fill(255);
       ellipse(xpos[i]-(diry/2),ypos[i]-(dirx/2),15,15);
       ellipse(xpos[i]+(diry/2),ypos[i]+(dirx/2),15,15);
       fill(0);
       stroke(0);
       ellipse(xpos[i]-(diry/2),ypos[i]-(dirx/2),5,5);
       ellipse(xpos[i]+(diry/2),ypos[i]+(dirx/2),5,5);
       stroke(0);
      } else {
        //draw body of snake
        stroke(0);
        fill(xpos[i]/2,255,ypos[i]/2);
        ellipse((xpos[i]), (ypos[i]), 20, 20);
      }
    }
    //call lose and points functions in draw
  eatapp(points);
    lose();
  }
}

void keyPressed() {
//turn snake up if its moving in x
  if (keyCode==UP && diry==0) {
    dirx=0;
    diry=-15;
    //turn snake down if its moving in x
  } else if (keyCode==DOWN && diry==0) {
    dirx=0;
    diry=15;
     //turn snake left if its moving in y
  } else if (keyCode==LEFT && dirx==0) {
    //play snake sound when it moves left
     if (hissing) {
    hiss.stop();
    hissing = false;
  } else {
    hiss.play();
    hissing = true;
  }
    dirx=-15;
    diry=0;
     //turn snake right if its moving in y
  } else if (keyCode==RIGHT && dirx==0) {
   
    dirx=15;
    diry=0;
  }
}

void lose() {
  
  //return to instructions if snake hits wall
  if(xpos[xpos.length-1]>=width){
 ypos[ypos.length-1]=height/2;
xpos[xpos.length-1]=width/2;
//play sound effect
  lose.play();
  //return to setup
    gameover=true;
//left wall
  }else if(xpos[xpos.length-1]<=0){
  ypos[ypos.length-1]=height/2;
xpos[xpos.length-1]=width/2;
lose.play();
    gameover=true;
//top
  }else if(ypos[ypos.length-1]<=0){
    ypos[ypos.length-1]=height/2;
   xpos[xpos.length-1]=width/2;
   lose.play();
 gameover=true;
//bottom
  }else if(ypos[ypos.length-1]>=height){
    ypos[ypos.length-1]=height/2;
xpos[xpos.length-1]=width/2;
lose.play();
 gameover=true;

  }
  
  // lose if the snake hits itself
for(int i=0;i<xpos.length-1;i++){
 if (xpos[i]==xpos[xpos.length-1] && ypos[i]==ypos[ypos.length-1] ){
ypos[ypos.length-1]=height/2;
xpos[xpos.length-1]=width/2;
//play lose sound
lose.play();
 gameover=true;
   

 }
}

}

int eatapp(int points) {
  //add point if snake eats apple
  if (dist(xpos[xpos.length-1], ypos[ypos.length-1], appx, appy)<=80) {
  //draw toungue when snake gets close
  fill(#FC0011);
  stroke(#FC0011);
  if(dirx==-15){
    x=5;
  }else if(dirx==15){
    x=5;
  }else{
    x=0;
  }
  if(diry==-15){
    y=5;
  }else if(diry==15){
   y=5;
  }else{
    y=0;
  }
  rect(xpos[xpos.length-1]+(18*dirx/15), ypos[ypos.length-1]+(18*diry/15),10+x,10+y);
  
  
  if (dist(xpos[xpos.length-1], ypos[ypos.length-1], appx, appy)<=30) {
    //play eat sound effect    
    eat.play();
   
    //move apple to a random location
    appx=(int)random(20,width-20);
    appy=(int)random(20,height-20);
    //extend snake by 1
    xpos = (int[]) append(xpos, xpos[xpos.length-1]+1);
    ypos = (int[]) append(ypos, ypos[ypos.length-1]+1);
    return points+1;
  }
  }
 return points;
}
