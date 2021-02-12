/* Moelle game */

color white = color(255);
color black = color(0);

int boardSize;
int centerX;
int centerY;
int smallX;
int bigX;
int lineWeight = 10;
int circleSize = 40;

ArrayList<StoredCoords> coords = new ArrayList<StoredCoords>();
ArrayList<StoredColors> colors = new ArrayList<StoredColors>();

void setup() {
  size(600, 600);
  frameRate(1);
  
  boardSize = 500;
  centerX = width/2;
  centerY = height/2;
  smallX = (width-boardSize)/2;    // 50
  bigX = boardSize+smallX;         // 550
  
  strokeWeight(lineWeight);
  stroke(black);
  fill(white);
  
  rectMode(CENTER);
  rect(centerX,  centerY, boardSize, boardSize);
  rect(centerX, centerY, boardSize/2, boardSize/2);
  line(centerX, smallX, centerX, bigX);
  line(smallX, centerY, bigX, centerY);
  rect(centerX, centerY, boardSize/6, boardSize/6);  
  
  FillCoords();
  FillColors();
}

void draw() {
  try {
    PlayGame();
  }
  catch (Exception exceptions) {
    println("Game Over!");
    noLoop();
  }
}

void FillCoords() {
  StoredCoords sc1 = new StoredCoords(smallX, smallX);    // 1. coord
  coords.add(sc1);
  StoredCoords sc2 = new StoredCoords(smallX, centerX);    // 2. coord
  coords.add(sc2);  
  StoredCoords sc3 = new StoredCoords(smallX, bigX);    // 3. coord
  coords.add(sc3);
  
  StoredCoords sc4 = new StoredCoords(centerX, smallX);    // 4. coord
  coords.add(sc4);
  StoredCoords sc5 = new StoredCoords(centerX, centerY);    // 5. coord
  coords.add(sc5);
  StoredCoords sc6 = new StoredCoords(centerX, bigX);    // 6. coord
  coords.add(sc6);
  
  StoredCoords sc7 = new StoredCoords(bigX, smallX);    // 7. coord
  coords.add(sc7);
  StoredCoords sc8 = new StoredCoords(bigX, centerX);    // 8. coord
  coords.add(sc8);
  StoredCoords sc9 = new StoredCoords(bigX, bigX);    // 9. coord
  coords.add(sc9);
}

void FillColors() {
  StoredColors sc1 = new StoredColors(255, 0, 0);
  colors.add(sc1);
  StoredColors sc2 = new StoredColors(0, 255, 0);
  colors.add(sc2);
  StoredColors sc3 = new StoredColors(255, 0, 0);
  colors.add(sc3);

  StoredColors sc4 = new StoredColors(0, 255, 0);
  colors.add(sc4);
  StoredColors sc5 = new StoredColors(255, 0, 0);
  colors.add(sc5);
  StoredColors sc6 = new StoredColors(0, 255, 0);
  colors.add(sc6);
  
  StoredColors sc7 = new StoredColors(255, 0, 0);
  colors.add(sc7);
  StoredColors sc8 = new StoredColors(0, 255, 0);
  colors.add(sc8);
  StoredColors sc9 = new StoredColors(255, 0, 0);
  colors.add(sc9);
}

void PlayGame() {
  int randIndex = (int)random(coords.size());
  
  StoredCoords currentIndex = coords.get(randIndex);
  StoredColors currentColor = colors.get(0);
  
  coords.remove(currentIndex);
  colors.remove(0);
  
  color circleColor = color(currentColor.r, currentColor.g, currentColor.b);
  fill(circleColor);
  
  ellipseMode(CENTER);
  strokeWeight(1);
  ellipse(currentIndex.x, currentIndex.y, circleSize, circleSize);
}
 
