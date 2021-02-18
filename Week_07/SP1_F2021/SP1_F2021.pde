/* Grid Game */

Boolean debug = true;

/* Grid */
int gridLength = 46;
int gridSquareSize = 20;
int[][] grid = new int[gridLength][gridLength];

/* Game settings */
int frames = 12;
int[] playAgainButton = new int[4];
Boolean gamePaused = false;
Boolean gameOver = false;
int highScore = 0;

/* Player movement */
Boolean movingLeft = false;
Boolean movingRight = false;
Boolean movingUp = false;
Boolean movingDown = false;

/* Player stats */
int playerHP = 3;
int playerScore = 0;

/* Enemie stats */
int amountOfEnemies = 5;
int distanceToEnemy = 15;       // min distance used when generating random enemy spawn positions
int enemyDifficulty = 4;        // the higher the difficulty, the lower the chance of random enemy movement

/* Food stats */
int amountOfFood = 15;
int distanceToFood = 6;         // min distance used when generating random enemy spawn positions
int foodDifficulty = 2;         // the higher the difficulty, the lower the chance of random food movement
int safeDistance = 5;           // the distance a food will have to player before moving freely

/* Components */
Player player;
Enemy[] enemies = new Enemy[amountOfEnemies];
Food[] foods = new Food[amountOfFood];



void setup() {
    size(1200, 921);        // 1100, 921
    frameRate(frames);
    
    int[] _playAgainButton = {(width / 2) - 200, (height / 2) + 200, (width / 2) + 200, (height / 2) + 300};
    playAgainButton = _playAgainButton;
    
    player = new Player((int)gridLength/2, (int)gridLength/2, playerHP, playerScore);               // player starts in "middle" of grid
    
    for (int i = 0; i < enemies.length; i++) {          
        enemies[i] = new Enemy(player, distanceToEnemy, enemyDifficulty);    // create the enemies
        enemies[i].spawnEnemy();                                             // generate a random start position for enemies 
    }
    for (int i = 0; i < foods.length; i++) {
        foods[i] = new Food(player, distanceToFood, foodDifficulty);         // create the food
        foods[i].spawnFood();                                                // generate a random start position for food
    }
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
