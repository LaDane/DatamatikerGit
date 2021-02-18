class Enemy {
    /* Position stuff */
    int x; 
    int y;
    int minDistanceToPlayer;

    /* Difficulty */
    int difficulty;

    /* GFX */
    int type = 1;

    /* Components */
    Player player;
    Positions positions = new Positions();

    /* Constructor */
    Enemy(Player player, int distanceToPlayerSpawn, int enemyDifficulty) {
        this.player = player;
        this.minDistanceToPlayer = distanceToPlayerSpawn;
        this.difficulty = enemyDifficulty;
    }


    void spawnEnemy() {
        int[] spawnPoints = positions.randomStartPosition(minDistanceToPlayer);
        x = spawnPoints[0];
        y = spawnPoints[1];
    }


    void moveEnemy() {
        int[] newPos;
        newPos = positions.newPosition(true, difficulty, x, y);
        // int newPosX = newPos[0];
        // int newPosY = newPos[1];

        // newPos = positions.checkPositionNotOccupied(x, y, newPosX, newPosY);        not working

        // newPosX = newPos[0];
        // newPosY = newPos[1];        
        
        x = newPos[0];
        y = newPos[1];        



        //Boolean checkingIfPosOccupied = true;

        //while (checkingIfPosOccupied) {

        //    Boolean posOccupied = true;
        //    for (int i = 0; i < enemies.length; i++) {
        //        int indexX = enemies[i].x;
        //        int indexY = enemies[i].y;
        //        if (x == indexX && y == indexY) continue;                                    // were not interested in checking if out own position = our own position... continue
        //        if (!positions.positionOccupied(newPos[0], newPos[1], indexX, indexY)) {
        //            posOccupied = false;
        //        }
        //        println(newPos[0], newPos[1], indexX, indexY);
        //    }
        //    if (posOccupied == true) {
        //        newPos = positions.randomNewPosition(x, y);
        //        break;
        //    }
            
        //    if (posOccupied == false) {
        //        checkingIfPosOccupied = false;
        //        break;
        //    }
        //}



    }
}
