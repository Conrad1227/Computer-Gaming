class Username {
  String saved="";
  int delay;
  PImage space;
  int score;
  Table table= loadTable("Names_scores.csv", "header");
  int[] scores;
  String[] names;
  boolean display;
  PImage restart;
  boolean instruct;
  boolean a;
  boolean c;
  boolean g;

  Username() {
    space = loadImage("space2.png");
    space.resize(500, 600);
    table.setColumnType(1, Table.INT);
    display=true;
    restart= loadImage("earth.png");
  }

  void inputusername() {
    textSize(30);
    fill(255);
    text("Type in username and press enter when finished", 200, 200);
    if (keyPressed && delay>=12) {
      if (key==ENTER || key==RETURN) {
        a=true;
      } else if (key == CODED || key==BACKSPACE) {
      } else {
        saved = saved + key;
        delay=0;
      }
    }
    delay++;
    background(space);
    textSize(30);
    fill(255);
    text("Type in username and", 100, 150);
    text("press enter when finished", 90, 200);
    stroke(255);
    line(110, 310, 390, 310);
    text(saved, width/2-50, height/2);
  }


  boolean userin(boolean b) {
    if(b==false){
      a=b;
      saved="";
    }
    if (a) {
      return true;
    } else {
      return false;
    }
  }

  void leaderboard(int score) {
    g=true;
    if(g){
    background(space);
    imageMode(CENTER);
    image(restart, width/2, 100, 100, 100);
    textSize(25);
    fill(255);
    text("Leaderboard:", width/3+20,height/3);
    textSize(12);
    text("RESTART", width/2-25, 150);
    if (display) {
      TableRow new_row=table.addRow();
      new_row.setString(0, saved);
      new_row.setInt(1, score);
      names=new String[table.getRowCount()];
      scores=new int[table.getRowCount()];
      saveTable(table, "data/New_Names_scores.csv");
      table.sort(1);
      fill(255, 255, 255, 255);

      for (int i=table.getRowCount()-1; i>=0; i--) {
        TableRow row=table.getRow(i);
        names[i]=row.getString(0);
        scores[i]=row.getInt(1);
      }
      display=false;
    }
    for (int i=0; i<table.getRowCount(); i++) {
      text(names[i], width/2-40, height/2-(i*10));
      text(scores[i], width/2, height/2-(i*10));
    }
    }
  }

  boolean goback(boolean b) {
    if (dist(mouseX, mouseY, width/2, 100)<=100) {
      if (mousePressed) {
        c=true;
        g=false;
      }
    }
    if(b==false){
     c=false; 
    }
    if (c) {
      return true;
    } else {
      return false;
    }
  }
}
