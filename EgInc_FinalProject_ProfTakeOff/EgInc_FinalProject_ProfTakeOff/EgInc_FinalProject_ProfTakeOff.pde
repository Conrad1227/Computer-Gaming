EgInc eginc;
Prof prof;
Story story;
Instructions instructions;
Addin addin;
Game game1;
Username user1;
boolean game, display;
int score;
SoundFile jump;
SoundFile jet;

import processing.sound.*;
SoundFile cracksong;
SoundFile chicksong;
PFont font1;
PFont font2;
boolean storypage = false;
boolean instructionpage = false;
boolean additinstrucpage = false;
int delay9 = 10000;
boolean a;
boolean b;
boolean d;
boolean e;
boolean c;
boolean f;
boolean g;
boolean h;

void setup() {
  size(500, 600);
  cracksong = new SoundFile(this, "egg-crack5-104555.mp3");
  chicksong = new SoundFile(this, "short-chick-sound-171389.mp3");
  font1 = createFont("BM Jua", 16);
  font2 = createFont("Copperplate", 16);
  addin = new Addin(this, font1);
  eginc = new EgInc(this, cracksong, chicksong, font1);
  prof = new Prof(this, font2);
  story = new Story(this);
  instructions = new Instructions(this, font1);
  jump = new SoundFile(this, "rock.mp3");
  jet = new SoundFile(this, "jetpack.mp3");
  a=false;
  user1= new Username();
  game1= new Game(this, jump, jet);
  game1.setast();
  game=false;
  b=true;
  a=true;
  c=true;
  d=true;
  e=true;
  f=true;
  g=true;
  h=true;
}

void draw() {
  if(h){
  eginc.draw();
  }
  if (millis() >= delay9) {
    h=false;
    prof.drawprof();
  }
  if (prof.storypage() == true) {
    story.drawstory();
  }
  if (story.drawstory2(f) == true) {
    instructions.drawinstructions();
  }
  if (user1.goback(c)==true) {
    a=false;
    instructions.drawinstructions();
    b=true;
    d=true;
    e=true;
  }
  if (instructions.addinstrucpage(d) == true) {
    println("aadinst");
    a=false;
    c=false;
    f=false;
    addin.drawaddin();
  }
  if (addin.continuec(b) == true) {
    a=true;
    d=false;
    c=true;
    d=true;
    user1.inputusername();
  
  }
  if (user1.userin(e)==true) {
    g=true;
    b=false;
    d=false;
    game1.run();
    game1.display();
  
  }
  if (game1.lose(a)==true) {
    b=false;
    d=false;
    e=false;
    user1.goback(c);
    score=game1.score();
    game1.reset();
    
    user1.leaderboard(score);
  
    
  }
    
  
}
