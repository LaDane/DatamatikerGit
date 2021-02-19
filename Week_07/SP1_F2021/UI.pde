/* All ui stuff goes in here */

int[] playAgainButton = new int[4];



void updateUI() {
    uiBackground();
    displayScore();
    displayLives();
    displayBombs();
    updateHighScore();
    displayHighScore();
}

void gameOverUI() {
    int[] _playAgainButton = {(width / 2) - 200, (height / 2) + 200, (width / 2) + 200, (height / 2) + 300};
    playAgainButton = _playAgainButton;
    
    displayGameOver();
    displayReplayButton();
}


void uiBackground() {
    rectMode(CORNERS);
    fill(150);
    rect(width - 240, 190, width - 20, height - 210);        // shadow
    
    stroke(150);
    fill(180);
    rect(width - 250, 200, width - 30, height - 200);
}


void displayLives() {
    int heartX = width - 240;
    for (int i = 0; i < player.HP; i++) {
        image(heartSpr, heartX, 220, 60, 60);
        heartX += 70;
    }
}


void displayBombs() {
    int bombX = width - 240;
    for (int i = 0; i < player.bombs; i++) {
        image(bombSpr, bombX, 300, 60, 60);
        bombX += 70;
    }
}


void displayScore() {
    String s = "SCORE\n"+player.score;
    textAlign(CENTER, CENTER);
    textSize(45);    
    fill(0);
    text(s, width - 140, 450);        // middle
}


void updateHighScore() {
    if (player.score > highScore) {
        highScore = player.score;
    }
}


void displayHighScore() {
    String s = "HIGH SCORE\n"+highScore;
    textSize(45);
    fill(0);
    text(s, width - 140, 620);
}


void displayGameOver() {
    highScore = player.score;

    rectMode(CORNERS);
    fill(140, 140, 140, 40);
    rect(100, 100, width - 100, height - 100);        // game over background
    
    textSize(100); 
    fill(0, 0, 0, 255);
    String s = "Game Over\n\nYour score was\n"+player.score;
    text(s, width / 2, (height / 2) - 100);
}


void displayReplayButton() {
    rectMode(CORNERS);

    fill(120);
    rect(playAgainButton[0] + 10, playAgainButton[1] - 10, playAgainButton[2] + 10, playAgainButton[3] - 10);        // shadow

    fill(180);
    rect(playAgainButton[0], playAgainButton[1], playAgainButton[2], playAgainButton[3]);

    String s = "Play again";
    fill(0);
    textSize(80);
    text(s, width / 2, (height / 2) + 240);
}


void mousePressed() {
    if (gameOver) {
        if (mouseX >= playAgainButton[0] && mouseX <= playAgainButton[2] && mouseY >= playAgainButton[1] && mouseY <= playAgainButton[3]) {
            resetGame();
        }
    }
}

void resetGame() {

    for (int x = 0; x < grid.length; x++) {
        for (int y = 0; y < grid[0].length; y++) {
            grid[x][y] = 0;
        }
    }
    gameIteration = (int)random(100);
    init();
}




/* DEBUGGING */
void printIntArray(int[][] arr) {
    println("");
    println("");
    println("");
    for (int x = 0; x < arr.length; x++) {
        for (int y = 0; y < arr[0].length; y++) {
            print(arr[x][y] + ", ");
        }
        println();
    }
}
