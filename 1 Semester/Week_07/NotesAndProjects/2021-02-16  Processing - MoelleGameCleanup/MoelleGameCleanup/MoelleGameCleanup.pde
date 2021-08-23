float dimension = 500;// game board size
float space = 200; // distance between squares
float margin;
PShape green_piece;
PShape red_piece;
int interval=100;

void setup() {
  size(600, 600);
  margin = (width-dimension)/2; // Distance between sketch border and outer sqaure
  
  Bricks();          // setting up the PShapes used for player representation
  PlayingBoard();    // setting up the game board large square
  BoardSquares();    // setting up the game board smaller squares
}

void Bricks() {
  ellipseMode(CENTER);
  green_piece = createShape(ELLIPSE, 0, 0, 50, 50);
  green_piece.setFill(color(0, 255, 0));
  red_piece = createShape(ELLIPSE, 0, 0, 50, 50);
  red_piece.setFill(color(255, 0, 0));
}

void PlayingBoard() {
  rectMode(CENTER); 
  strokeWeight(10);
}

void BoardSquares() {
  rect(width/2, height/2, dimension, dimension);                        // outer most sqaure 2
  rect(width/2, height/2, dimension-space, dimension-space);            // outer most sqaure 2
  line(width/2, margin, width/2, height-margin);                        // Cross - vertical line
  line(margin, height/2, width-margin, height/2);                       // Cross - horizontal line
  rect(width/2, height/2, dimension-space*2, dimension-space*2);        // Sqaure closest to center
}

void draw() {
  translate(margin, margin);
  if (frameCount%interval==0) DrawPlayers(green_piece);
  else if (frameCount%interval==interval/2) DrawPlayers(red_piece);
}

void DrawPlayers(PShape pShape) {
  int x = (int)random(3);
  int y = (int)random(4);
  shape(pShape, (dimension/2)*x, (dimension/2)*y);
}
