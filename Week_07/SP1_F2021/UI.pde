/* All ui stuff goes in here */

void updateUI() {
    uiBackground();
    displayScore();
    displayLives();
    updateHighScore();
    displayHighScore();
}

void gameOverUI() {
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


void displayScore() {
    String s = "SCORE\n"+player.score;
    textAlign(CENTER, CENTER);
    textSize(32);    

    fill(0);
    text(s, width - 140, 270);
}


void displayLives() {
    String s = "LIVES\n"+player.HP;
    textSize(32); 

    fill(0);
    text(s, width - 140, 450);
}


void updateHighScore() {
    if (player.score > highScore) {
        highScore = player.score;
    }
}


void displayHighScore() {
    String s = "HIGH SCORE\n"+highScore;
    textSize(32);

    fill(0);
    text(s, width - 140, 620);
}


void displayGameOver() {
    highScore = player.score;

    rectMode(CORNERS);
    fill(140, 140, 140, 20);
    rect(100, 100, width - 100, height - 100);        // game over background
    textSize(80); 
    fill(0, 0, 0, 255);
    String s = "Game Over!\n\nYour score was\n"+player.score;
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
    textSize(60);
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
    rectMode(CORNERS);
    fill(200);
    rect(0, 0, width, height);
    
    gameOver = false;
    gamePaused = false;
    setup();
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
