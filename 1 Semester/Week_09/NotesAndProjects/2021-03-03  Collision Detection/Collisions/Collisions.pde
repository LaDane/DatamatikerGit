float cx = 250;
float cy = 250;
float cr = 50;

float speed = 5;
float xForce = 1;
float yForce = 1;

float random1;
float random2;
float randomSize = 50;

void setup() {
    size(600, 450);
    smooth();
    
    random1 = random(height - randomSize);
    random2 = random(height - randomSize);
}

void draw() {
    background(255);
    
    cx += speed * xForce;
    cy += (speed-random(0.5f)) * yForce;
    
    
    if (cx > width-cr || cx < cr) xForce *= -1;            // edge collision
    if (cy > height-cr || cy < cr) yForce *= -1;           // edge collision
    
    
    if (dist(mouseX, mouseY, cx, cy) < cr) fill(150);      // mouse collision
    else fill(240);
    
    ellipse(cx, cy, cr*2, cr*2);
    
    
    fill(0);
    rect(random1, random2, randomSize, randomSize);
    
    if (dist(random1, random2, cx, cy) < cr) {
        xForce *= -1;
        yForce *= -1;
    } 
    else if (dist(random1+randomSize, random2, cx, cy) < cr) {
        xForce *= -1;
        yForce *= -1;    
    }
    else if (dist(random1, random2+randomSize, cx, cy) < cr) {
        xForce *= -1;
        yForce *= -1;    
    }    
    else if (dist(random1+randomSize, random2+randomSize, cx, cy) < cr) {
        xForce *= -1;
        yForce *= -1;    
    }       
}
