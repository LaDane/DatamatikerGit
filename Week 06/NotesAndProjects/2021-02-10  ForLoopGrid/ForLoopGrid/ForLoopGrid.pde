int offset = 0;
int increment = 50;

void setup() {
  size(800, 800);
  background(255);
  strokeWeight(2);
}

void draw() {
  while (offset <= width) {
    line(offset, 0, offset, height);
    line(0, offset, width, offset);
    offset += increment;
  }
}
