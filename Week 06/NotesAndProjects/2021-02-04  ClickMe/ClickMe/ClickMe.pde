color white = color(255);
color black = color(0);

float textX;
float textY;

void setup() {
  size(500, 500);
  GenerateRandom();
}

void ClickMe() {
  String textString = "Click me!";
  stroke(black);
  background(white);
  
  fill(white);
  rectMode(CENTER);
  rect(textX, textY, 70, 30);
  
  fill(black);
  textSize(15);
  text(textString, textX - 33, textY + 5, 5);
}

void GenerateRandom() {
  boolean generating = true;
  
  while(generating) {
  
    textX = random(50, 450);
    textY = random(50, 450);
    
    if (dist(mouseX, mouseY, textX, textY) > 250) {
      generating = false;
      ClickMe();
      return;
    }
  }
}

void MeasureDist() {
  if (dist(mouseX, mouseY, textX, textY) < 70) {
    GenerateRandom();
  }
}

void draw() {
  MeasureDist();  
}
