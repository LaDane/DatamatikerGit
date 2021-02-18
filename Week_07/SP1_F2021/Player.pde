class Player {
    /* Position stuff */
    int x; 
    int y; 
    
    /* Stats */
    int HP;
    int score;
    
    /* GFX */
    int type = 3; 

    /* Constructor */
    Player(int x, int y, int playerHP, int playerScore) {
        this.x = x;
        this.y = y;
        this.HP = playerHP;
        this.score = playerScore; 
    }

    /* Movement */
    void moveLeft() {
        if (canMove('x', -1)) x--;
    }
    void moveRight() {
        if (canMove('x', 1)) x++;
    }
    void moveUp() {
        if (canMove('y', -1)) y--;
    }
    void moveDown() {
        if (canMove('y', 1)) y++;
    }


    Boolean canMove(char xy, int wantedDirection) {
        if (xy == 'x') {
            if (x == 0 && wantedDirection == -1) return false;
            if (x == gridLength-1 && wantedDirection == 1) return false;
        }
        if (xy == 'y') {
            if (y == 0 && wantedDirection == -1) return false;
            if (y == gridLength-1 && wantedDirection == 1) return false;
        }
        return true;
    }


    void takeDamage() {
        HP--;
        if (HP <= 0) HP = 0;
    }
    
    
    void increaseScore() {
        score += 100;
    }
    
    
    void checkLives() {
        if (HP <= 0) gameOver = false;
    }
}
