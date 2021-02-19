/* GAME LOGIC */

void playGame() {
    clearBoard();                // reset board
    updateEntities();            // update player board GFX
    updateEnemies();             // update enemy positions and enemy board GFX        // FAILING HERE SOMETIMES
    updateFoods();               // update food positions and food GFX
    resolveCollisions();         // check for player collisions
    drawBoard();                 // draw the board
}

void clearBoard() {
    for (int x = 0; x < grid.length; x++) {
        for (int y = 0; y < grid[0].length; y++) {
            if (grid[x][y] != 4)                         // only reset if grid is not walls
                grid[x][y] = 0;
        }
    }
}


void updateEntities() {
    grid[player.x][player.y] = player.type;
}


void updateEnemies() {
    for (int i = 0; i < enemies.length; i++) {
        enemies[i].moveEnemy();                                    // FAILING HERE SOMETIMES
        grid[enemies[i].x][enemies[i].y] = enemies[i].type;
    }
}


void updateFoods() {
    for (int i = 0; i < foods.length; i++) {
        foods[i].checkDistanceToPlayerPos();
        foods[i].checkDistanceToTargetPos();
        
        foods[i].moveFood();
        grid[foods[i].x][foods[i].y] = foods[i].type;
    }
}


void drawBoard() {
    for (int x = 0; x < grid.length; x++) {
        for (int y = 0; y < grid[0].length; y++) {

            if (grid[x][y] == 3) {
                image(groundSpr, x * gridSquareSize, y * gridSquareSize, gridSquareSize, gridSquareSize);        // draw ground under player
            }

            PImage sprite = getSpriteFromType(grid[x][y]);
            image(sprite, x * gridSquareSize, y * gridSquareSize, gridSquareSize, gridSquareSize);
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
