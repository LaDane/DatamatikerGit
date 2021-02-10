/*
3.a Draw a traffic light using colors stored in variables - one for each of the 4 colors (background is the 4th).
3.b add a gray color for the turned off effect
3.c have the light turn on/off (green or red) automatically.
*/

color green = color(0, 255, 0);
color yellow = color(255, 255, 0);
color red = color(255, 0, 0);
color grey = color(80);
color bg = color(10);

int border = 10;
int circleSize = 90;
int circleSpacing = 100;
int lightStage = 0;

void setup() {
  size(200, 400);
}

void draw() {
  frameRate(1);    // cheesy way of delaying light updates

  rectMode(CORNERS);
  fill(bg);
  rect(border, border, width - border, height - border);                      // background

  fill(grey);
  for (int i = circleSpacing; i <= circleSpacing * 3; i += circleSpacing) {   // 3 grey circles that can light up
    ellipse(width / 2, i, circleSize, circleSize);
  }

  ChangeLights();
}

void ChangeLights() {
  if (lightStage == 0) {              // all lights are off, turn on green light
    fill(green);
  } else if (lightStage == 1) {       // green light is active, turn off green, turn on yellow
    fill(yellow);
  } else if (lightStage == 2) {       // yellow light is active, turn off yellow, turn on red
    fill(red);
  } 

  lightStage++;
  
  if (lightStage > 3) {               // we only have 3 stages, reset counter
    lightStage = 0;
    return;
  }
  
  ellipse(width / 2, circleSpacing * lightStage, circleSize, circleSize);
}
