int iterations = 10;

int circleSize = 20;
int spacing = 20;

int lineStartX = 10;
int lineStartY = 10;
int lineEndX = 150;
int lineEndY = 100;

size(500, 500);

for (int i = 0; i < iterations; i++) {
  line(lineStartX, lineStartY, lineEndX, lineEndY);
  for (int j = 0; j < iterations; j++) {
    ellipse(lineEndX + (j * spacing), lineEndY, circleSize, circleSize);
  }
  lineEndY += spacing;
}
