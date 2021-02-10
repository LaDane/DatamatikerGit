/* Pirate Mario */

color white = color(255, 255, 255);
color black = color(0, 0, 0);
color red = color(250, 0, 0);
color redDark = color(204, 0, 0);
color blue = color(0, 128, 255);
color brown = color(102, 51, 0);
color skin = color(255, 204, 153);
color gold = color(204, 204, 0);

void setup() {
  size(450,700);
  background(255);
  
  // print a message to console
  println("Itsa me, Mario!");  
}


void draw() {
  noStroke();
  
  // define corners
  ellipseMode(CORNERS);
  rectMode(CORNERS);
  
  // HAT
  fill(red);
  
  ellipse(175, 50, 225, 100); // top left of hat
  ellipse(169, 55, 220, 110);
  
  rotate(PI/8.0);
  rect(207, -32, 320, 50);    // top of hat
  rotate(PI/-8.0);
  
  ellipse(270, 90, 320, 140); // top right of hat
  
  rotate(50);
  rect(150, 190, 280, 240);   // right side of hat
  rotate(-50);
  
  fill(white);
  rect(325, 100, 500, 300);   // fix right side of hat
  
  fill(redDark);           
  ellipse(125, 75, 200, 170); // cap circle 
  
  rotate(PI/6);
  rect(190, -20, 350, 100);   // cap long part
  rotate(PI/-6);
  
  fill(white);
  rect(10, 151, 133, 200);    // fix left side of cap
  
  // FACE UPPER
  fill(skin);
  ellipse(20, 145, 400, 250); // top of face covering cap
  
  fill(white);
  rect(10, 150, 132, 400);    // fix left side of top of face
  rect(325, 100, 500, 300);   // fix right side of top of face
  
  fill(skin);
  ellipse(122, 150, 150, 350); // left side of face
  ellipse(312, 155, 330, 330); // right side of face
  rect(130, 160, 320, 330);    // middle face fill
  
  // EYES
  fill(black);
  ellipse(130, 170, 180, 210); // left eyebrow
  ellipse(180, 170, 230, 210); // right eyebrow
  
  fill(skin);
  ellipse(124, 175, 184, 220); // left eyebrow fix
  ellipse(174, 175, 234, 220); // right eyebrow fix
  ellipse(172, 160, 188, 220); // eyebrow middle fix
  
  stroke(black); 
  fill(white); 
  ellipse(130, 180, 190, 250); // left eye white
  noStroke();
  
  // GLOVES
  stroke(black);
  fill(white);
  ellipse(322, 525, 363, 565);  // right glove
  ellipse(80, 525, 120, 562);  // left glove
  noStroke();
  
  // SHIRT
  fill(red);
  rect(180, 400, 270, 480);   // shirt middle under jaw
  ellipse(135, 400, 215, 480); // left shoulder
  ellipse(240, 400, 313, 480); // right shoulder
  
  rotate(-270.6);
  rect(70, 500, 107.5, 630);    // right arm
  rotate(270.6);
  
  rotate(-269.7);
  rect(319, 300, 360, 430);    // left arm
  rotate(269.7);
  
  
  // OVERALLS
  fill(blue);
  rect(250, 400, 280, 480);    // overalls right strap
  rect(170, 350, 200, 480);    // overalls left strap
  rect(150, 470, 300, 560);    // overalls stomach
  
  
  // PANTS
  rect(150, 550, 220, 650);    // left leg
  rect(230, 550, 300, 650);    // right leg
  
  
  // SHOES
  fill(brown);
  ellipse(150, 635, 220, 665);
  ellipse(230, 635, 300, 665);
  
  
  // JAW
  fill(skin);
  ellipse(130, 350, 250, 430); // jaw bottom
  ellipse(130, 250, 323, 400); // jaw upper (back of jaw)
  
  fill(white);
  ellipse(110, 300, 250, 380); // mouth fill white
  
  
  // TEETH
  stroke(black);
  fill(white);
  rotate(-270);
  rect(210, 300, 230, 330);    // left tooth
  rotate(270);
  
  fill(gold);
  rotate(-270.3);
  rect(130, 300, 150, 384);    // right tooth
  rotate(270.3);
  noStroke();
  
  // MOUTH TOP
  fill(skin);
  ellipse(110, 280, 260, 350); // top of mouth
  
  // MUSTACHE
  fill(brown);
  rotate(270);
  rect(60, 300, 190, 350);    // mustache background
  rotate(-270);
  
  ellipse(213, 262, 261, 330); // mustache right circle
  ellipse(180, 270, 230, 335); // mustache second from right circle
  ellipse(140, 270, 190, 340); // mustache second from left circle
  ellipse(110, 270, 150, 340); // mustache left circle
  
  // NOSE
  fill(black); 
  ellipse(59, 232, 210, 302);  // nose long shadow
  
  fill(skin); 
  ellipse(60, 230, 210, 300); // nose long
  
  fill(black);
  ellipse(170, 260, 220, 310); // nose lump shadow
  
  fill(skin);
  ellipse(170, 259, 218, 308); // nose lump
  
  // EYES (RIGHT)
  stroke(black); 
  fill(white); 
  ellipse(170, 180, 230, 250); // right eye white
  
  noStroke();
  fill(blue);
  ellipse(145, 200, 165, 230); // left eye pupil blue
  ellipse(185, 200, 205, 230); // right eye pupil blue
  
  fill(black);
  ellipse(150, 205, 160, 225); // left eye pupil black
  ellipse(190, 205, 200, 225); // right eye pupil black
  
  // EARS
  fill(black);
  ellipse(280, 170, 340, 250); // ear shadow
  
  fill(skin);
  ellipse(278, 172, 338, 248); // ear
  
  fill(black);
  ellipse(305, 205, 310, 215); // ear hole
  
  
  fill(gold);
  rectMode(CENTER);
  rect(mouseX, mouseY, 50, 50);  // draw a rect with mouse
}
