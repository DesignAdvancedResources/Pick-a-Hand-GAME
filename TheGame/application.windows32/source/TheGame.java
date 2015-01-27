import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class TheGame extends PApplet {

PFont myFont;     

boolean ganhou;
boolean esperaJogo;
boolean ESQ, DTA;

int dificuldade = 5;


Animation corEsq, vazEsq, loopEsq, corDta, vazDta, loopDta;

public void setup() {
  size(1280, 480);
  frameRate(14);

  myFont = loadFont("BigNoodleTitling-48.vlw"); 
  textFont(myFont, 32);
  textAlign(CENTER, CENTER);


  corEsq = new Animation("corEsq", 21);
  loopEsq = new Animation("loopEsq", 20);
  loopDta = new Animation("loopEsq", 20);
  vazEsq = new Animation("vazEsq", 21);


  //initial states
  background(0);

  fill(155);

  esperaJogo = true;
}

public void draw() {
  textSize(50);
  fill(250);
  
  if (esperaJogo == false) {

    if (ganhou == true) {
      
      if (DTA == true) {

        vazEsq.display(0, 0, width/2, height, false);
        corEsq.displayInv(width, 0, width/2, height, true);
        println("Ganhou com Esq");
      } 
      if (ESQ == true) {

        corEsq.display(0, 0, width/2, height, true);
        vazEsq.displayInv(width, 0, width/2, height, false);
        println("Ganhou com Dta");
      }
    } else if (ganhou == false) {
      if (DTA ==true) {

        corEsq.display(0, 0, width/2, height, true);
        vazEsq.displayInv(width, 0, width/2, height, false);
        println("Perdeu com Esq");
      } else if (ESQ ==true) {

        vazEsq.display(0, 0, width/2, height, false);
        corEsq.displayInv(width, 0, width/2, height, true);
        println("Perdeu com Dta");
      }
    }
  }
  if (esperaJogo == true) {

    background(0);
    text("L or R ?", width/2, height/2);
    joga(); 
    loopEsq.display(0, 0, width/2, height, true);
    loopDta.displayInv(width, 0, width/2, height, true);
  }
}



public void joga() {

  if (keyPressed == true) { 
    if (key == 'r' || key == 'R') {
      sorteia();
      ESQ = true;
      DTA = false;
      esperaJogo = false;
    } else if (key == 'l' || key == 'L') {
      sorteia();
      DTA = true;
      ESQ = false;
      esperaJogo = false;
    } else {
      DTA = false;
      ESQ = false;
      esperaJogo = true;
    }
  }
}


public void sorteia() {

  int decisao = PApplet.parseInt(random(dificuldade));
  if (decisao == 1 || decisao == 3) {
    ganhou = true;
  } else {
    ganhou = false;
  }
}
class Animation {
  PImage[] images;
  int imageCount;
  int frame;

  
  Animation(String imagePrefix, int count) {
    imageCount = count;
    images = new PImage[imageCount];


    for (int i = 0; i < imageCount; i++) {
      // Use nf() to number format 'i' into four digits
      String filename = imagePrefix + nf(i, 4) + ".png";
      images[i] = loadImage(filename);
    }


  }
  public void display(float xpos, float ypos, float larg, float alt, boolean loop) {
    frame = (frame+1) % imageCount;
    image(images[frame], xpos, ypos,larg, alt);
    if (frame == imageCount-1 && loop == false) {
    println ("PUMBAS!");
    ESQ = false;
    DTA = false;
    esperaJogo = true;
    }
    else {
    }
  }
  
    public void displayInv(float xpos, float ypos, float larg, float alt, boolean loop) {
    frame = (frame+1) % imageCount;
    pushMatrix();
    scale(-1, 1);
    image(images[frame], -xpos, ypos,larg, alt);;
    popMatrix();
        if (frame == imageCount-1 && loop == false) {
    println ("PUMBAS!");
    ESQ = false;
    DTA = false;
    esperaJogo = true;
    }
    else {}
    
    
  }  
  

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "TheGame" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
