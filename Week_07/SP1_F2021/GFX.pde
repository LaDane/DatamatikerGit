/* GAME GFX */

color getColorFromType(int type) {
    color c = color(255);
    if (type == 0) c = color(230);              // empty sqaures
    if (type == 1) c = color(255, 0, 0);        // enemies
    if (type == 2) c = color(0, 255, 0);        // food
    if (type == 3) c = color(0, 0, 255);        // player
    if (type == 4) c = color(0, 255, 255);      // unknown for now
    return c;
}
