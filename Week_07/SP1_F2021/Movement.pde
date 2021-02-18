/* MOVEMENT */

void keyPressed() {
    if (key == 'a') movingLeft = true;     // move left 
    if (key == 'd') movingRight = true;    // move right
    if (key == 'w') movingUp = true;       // move up
    if (key == 's') movingDown = true;     // move down

    if (key == 'z' && debug) printIntArray(grid);
}


void keyReleased() {
    if (key == 'a') movingLeft = false;    // stop move left 
    if (key == 'd') movingRight = false;   // stop move right
    if (key == 'w') movingUp = false;      // stop move up
    if (key == 's') movingDown = false;    // stop move down
}
