int amountOfFingers = 5;

int startX = 50;
int startY = -50;

int fingerSize = 100;

int i = 0;

void setup() {
  size(500, 600);
  background(randomColor());
}

void draw() {
  // background(randomColor(), 20, 20);
  
  FingerSong();
  delay(100);

  if (i >= amountOfFingers + 1) {
    i = 0;
    startX += fingerSize;
    startY = -50;
  }
  
  if (startX >= width) startX = 50;
  if (startY >= width) startY = -50;
}

void FingerSong() {
  startY += 100;

  Boolean isEnd = false;

  if (i == 0) FingerFunction("Tommel", startX, startY);
  else if (i == 1) FingerFunction("Pege", startX, startY);
  else if (i == 2) FingerFunction("Lange", startX, startY);
  else if (i == 3) FingerFunction("Ringe", startX, startY);
  else if (i == 4) FingerFunction("Lille", startX, startY);
  else if (i == 5) {
    FingerFunction("alle", startX, startY);
    isEnd = true;
  }
  Chorus(isEnd);
  i++;
}

void FingerFunction(String whichFinger, int x, int y) {
  if (whichFinger.equals("alle")) println("Alle fingre, alle fingre,");
  else println(whichFinger+"finger, "+whichFinger+"finger");

  fill(randomColor());
  ellipse(x, y, fingerSize, fingerSize);
}

void Chorus(boolean isEnd) {
  String a = "du";
  String b = "jeg";
  if (isEnd) {
    a = "i";
    b = "vi";
  } 
  println("hvor er "+a+"?");
  println("Her er "+b+", her er "+b+",");

  for (int i = 0; i < 3; i++) {
    println("go'da'!");
  }
  
  fill(randomColor());
  ellipse(startX, startY, fingerSize/2, fingerSize/2);
}  

color randomColor() {
  color randomC = color((int)random(0, 255), (int)random(0, 255), (int)random(0, 255));
  return randomC;
}
