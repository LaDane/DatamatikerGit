/* Grid Game */

import java.util.HashSet;
import java.util.Collections;

Boolean debug = true;

/* Grid */
int gridLength = 46;
int gridSquareSize = 20;
int[][] grid = new int[gridLength][gridLength];

/* Game settings */
int frames = 9;
int[] playAgainButton = new int[4];
Boolean gamePaused = false;
Boolean gameOver = false;
Boolean useAstarPathfinding = true;

/* Player movement */
Boolean movingLeft = false;
Boolean movingRight = false;
Boolean movingUp = false;
Boolean movingDown = false;

/* Player settings */
int playerHP = 3;
int playerScore = 0;
int highScore = 0;

/* Enemy settings */
int amountOfEnemies = 4;
int distanceToEnemy = 17;       // min distance used when generating random enemy spawn positions
int enemyDifficulty = 2;        // the higher the difficulty, the lower the chance of random enemy movement

/* Food settings */
int amountOfFood = 10;
int distanceToFood = 10;         // min distance used when generating random food spawn positions
int foodDifficulty = 3;         // the higher the difficulty, the lower the chance of random food movement
int safeDistance = 6;           // the distance a food will have to player before moving freely

/* Terrain settings */
float wallPerlinCap = 0.55;
float wallPerlinScale = 0.2;

/* Components */
Player player;
Enemy[] enemies = new Enemy[amountOfEnemies];
Food[] foods = new Food[amountOfFood];

Pathfind pathfind;
PathfindGrid pathfindGrid;
PathfindNode pathfindNode;

Walls walls;


void setup() {
    size(1200, 921);        // 1100, 921
    frameRate(frames);

    /* Create walls with perlin noise */
    walls = new Walls(wallPerlinCap, wallPerlinScale);
    walls.wallGeneration();

    int[] _playAgainButton = {(width / 2) - 200, (height / 2) + 200, (width / 2) + 200, (height / 2) + 300};
    playAgainButton = _playAgainButton;

    player = new Player((int)gridLength/2, (int)gridLength/2, playerHP, playerScore);    // player starts in "middle" of grid

    for (int i = 0; i < enemies.length; i++) {          
        enemies[i] = new Enemy(player, distanceToEnemy, enemyDifficulty);                // create the enemies
        enemies[i].spawnEnemy();                                                         // generate a random start position for enemies
    }
    
    for (int i = 0; i < foods.length; i++) {
        foods[i] = new Food(player, distanceToFood, foodDifficulty, safeDistance);       // create the food
        foods[i].spawnFood();                                                            // generate a random start position for food
    }

    /* Load sprites */
    assignSprites();

    /* Setup A star pathfinding */
    pathfindGrid = new PathfindGrid(gridLength);
    pathfindGrid.createGrid();
    pathfind = new Pathfind(pathfindGrid);
}


void draw() {
    if (!gamePaused) {
        /* Handle player movement */
        if (movingLeft) player.moveLeft();
        if (movingRight) player.moveRight();
        if (movingUp) player.moveUp();
        if (movingDown) player.moveDown();

        /* Game logic */
        playGame();

        /* UI */
        updateUI(); 

        /* Game settings */
        player.checkLives();
    }

    if (gameOver) {
        gamePaused = true;
        gameOverUI();
    }
}
