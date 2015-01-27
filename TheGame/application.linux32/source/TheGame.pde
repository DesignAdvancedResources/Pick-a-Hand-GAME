PFont myFont;     

boolean ganhou;
boolean esperaJogo;
boolean ESQ, DTA;

int dificuldade = 5;


Animation corEsq, vazEsq, loopEsq, corDta, vazDta, loopDta;

void setup() {
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

void draw() {
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



void joga() {

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


void sorteia() {

  int decisao = int(random(dificuldade));
  if (decisao == 1 || decisao == 3) {
    ganhou = true;
  } else {
    ganhou = false;
  }
}
