/* GAME LOGIC */

void playGame() {
    clearBoard();                // reset board
    updateEntities();            // update player board GFX
    updateEnemies();             // update enemy positions and enemy board GFX
    updateFoods();               // update food positions and food GFX
    resolveCollisions();         // check for player collisions
    drawBoard();                 // draw the board
}


void clearBoard() {
    for (int x = 0; x < grid.length; x++) {
        for (int y = 0; y < grid[0].length; y++) {
            grid[x][y] = 0;
        }
    }
}


void updateEntities() {
    grid[player.x][player.y] = player.type;
}


void updateEnemies() {
    for (int i = 0; i < enemies.length; i++) {
        enemies[i].moveEnemy();
        grid[enemies[i].x][enemies[i].y] = enemies[i].type;
    }
}


void updateFoods() {
    for (int i = 0; i < foods.length; i++) {
        foods[i].moveFood();
        grid[foods[i].x][foods[i].y] = foods[i].type;
    }
}


void drawBoard() {
    for (int x = 0; x < grid.length; x++) {
        for (int y = 0; y < grid[0].length; y++) {
            fill(getColorFromType(grid[x][y]));
            stroke(200);
            rectMode(CORNER);
            rect(x * gridSquareSize, y * gridSquareSize, gridSquareSize, gridSquareSize);
        }
    }
}


void resolveCollisions() {
    for (int i = 0; i < enemies.length; i++) {                                            
        if (player.x == enemies[i].x && player.y == enemies[i].y) {                   // check for enemy collisions
            player.takeDamage();                                                          // an enemy has collided with the player!
            enemies[i].spawnEnemy();                                                      // spawn new enemy
        } else continue;
    }

    for (int i = 0; i < foods.length; i++) {                                              
        if (player.x == foods[i].x && player.y == foods[i].y) {                       // check for food collisions
            player.increaseScore();                                                       // the player collided with food!
            foods[i].spawnFood();                                                         // spawn new food
        } else continue;
    }
}
