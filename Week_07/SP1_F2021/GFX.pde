/* GAME GFX */

PImage groundSpr;
PImage enemySpr;
PImage foodSpr;
PImage playerSpr;
PImage wallSpr;
PImage heartSpr;
PImage bombSpr;
PImage boxSpr;

void assignSprites() {
    groundSpr = loadImage("data/ground.png");
    enemySpr = loadImage("data/enemy.png");
    foodSpr = loadImage("data/food.png");
    playerSpr = loadImage("data/player.png");
    wallSpr = loadImage("data/wall.png");
    heartSpr = loadImage("data/heart.png");
    bombSpr = loadImage("data/bomb.png");
    boxSpr = loadImage("data/box.png");
}


PImage getSpriteFromType(int type) {
    PImage sprite = groundSpr;
    if (type == 0) sprite = groundSpr;
    if (type == 1) sprite = enemySpr;
    if (type == 2) sprite = foodSpr;
    if (type == 3) sprite = playerSpr;
    if (type == 4) sprite = wallSpr;
    return sprite;
}


//color getColorFromType(int type) {
//    color c = color(255);
//    if (type == 0) c = color(230);              // empty sqaures
//    if (type == 1) c = color(255, 0, 0);        // enemies
//    if (type == 2) c = color(0, 255, 0);        // food
//    if (type == 3) c = color(0, 0, 255);        // player
//    if (type == 4) c = color(0, 255, 255);      // unknown for now
//    return c;
//}
