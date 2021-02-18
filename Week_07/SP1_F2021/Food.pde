class Food {
    /* Position stuff */
    int x;
    int y;
    int minDistanceToPlayer;

    /* Difficulty */
    int difficulty;

    /* GFX */
    int type = 2;

    /* Components */
    Player player;
    Positions positions = new Positions();

    /* Constructor */
    Food(Player player, int distanceToPlayerSpawn, int foodDifficulty) {
        this.player = player;
        this.minDistanceToPlayer = distanceToPlayerSpawn;
        this.difficulty = foodDifficulty;
    }        


    void spawnFood() {            // Generate a random spawn position for food
        int[] spawnPoints = positions.randomStartPosition(minDistanceToPlayer);
        x = spawnPoints[0];
        y = spawnPoints[1];
    }


    void moveFood() {             // move food away from player
        int[] lowRange = {0, 1, 2, 3, 4, 5};
        int[] highRange = {gridLength - 5, gridLength - 4, gridLength - 3, gridLength - 2, gridLength - 1, gridLength};

        int[] newPos;
        newPos = positions.newPosition(false, difficulty, x, y);
        
        for (int i = 0; i < lowRange.length; i++) {
            if ((x == lowRange[i] && positions.measureDistance('x', x, player.x) >= safeDistance) || (y == lowRange[i] && positions.measureDistance('y', y, player.y) >= safeDistance)) {
                newPos = positions.randomNewPosition(x, y);
            }
        }
        
        for (int i = 0; i < highRange.length; i++) {
            if ((x == highRange[i] && positions.measureDistance('x', x, player.x) >= safeDistance) || (y == highRange[i] && positions.measureDistance('y', y, player.y) >= safeDistance)) {
                newPos = positions.randomNewPosition(x, y);
            }
        }        
        
        x = newPos[0];
        y = newPos[1];
    }
}
