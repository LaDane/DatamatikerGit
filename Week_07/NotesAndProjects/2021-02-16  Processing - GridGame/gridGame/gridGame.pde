int offset = 0;
int increment = 50;
Player p = new Player(400, 400);
    
void setup() {
  size(800, 800);
  background(255);
  strokeWeight(2);
}

void draw() {
  fill(255);
  for (int i = 0; i < width; i+=increment) {
    for (int j = 0; j < height; j+=increment) {
      rect(i, j, increment, increment);
    }
  }
  fill(100, 0, 0);
  ellipseMode(CORNER);
  ellipse(p.x, p.y, increment, increment);
}

void keyPressed() {
  
  if(key == 'a') {
    p.moveLeft();
  }
  
  if(key == 'w') {
    p.moveUp();
  }
  if(key == 'd') {
    p.moveRight();
  }
  if(key == 's') {
    p.moveDown();
  }
}
