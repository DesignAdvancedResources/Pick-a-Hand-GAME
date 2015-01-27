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
  void display(float xpos, float ypos, float larg, float alt, boolean loop) {
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
  
    void displayInv(float xpos, float ypos, float larg, float alt, boolean loop) {
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
