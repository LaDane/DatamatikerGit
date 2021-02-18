/* Grid Game */

/* debug */
Boolean debug = true;


/* Grid size */
int size = 40;
int[][] grid = new int[25][25];

/* Game logic */
int amountOfEnemies = 4;


/* Arrays */
Player player;
Enemy[] enemies = new Enemy[amountOfEnemies];



void setup() {
    size(1001, 1001);
    player = new Player(12, 12);                        // player starts in "middle" of grid
    
    for (int i = 0; i < enemies.length; i++) {          // create the enemies
      enemies[i] = new Enemy(20 + i, 20 + i, player);   // CHANGE THIS to algo at some point
    }
}

void draw() {
    clearBoard();
    updateEntities();
    drawBoard();    
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
    player.takeDamage();   
    
    for (int i = 0; i < enemies.length; i++) {
      grid[enemies[i].x][enemies[i].y] = enemies[i].type;
    }
}

void drawBoard() {
    for (int x = 0; x < grid.length; x++) {
        for (int y = 0; y < grid[0].length; y++) {
            fill(getColorFromType(grid[x][y]));
            
            rect(x * size, y * size, size, size);
        }
    }
}




color getColorFromType(int type) {
    color c = color(255);
    switch(type) {
        case 0: 
            c = color(127);
            break;
        case 1: 
            c = color(255,0,0);
            break;
        case 2: 
            c = color(0, 255, 0);
            break;
        case 3: 
            c = color(0,0,255);
            break;
        case 4: 
            c = color (0,255,255);
            break; 
    }    
    return c; 
}


void keyPressed() {
    if(key == 'w') player.y--;   // move up
    if(key == 'a') player.x--;   // move left   
    if(key == 's') player.y++;   // move down
    if(key == 'd') player.x++;   // moev right
    if(key == 'z') debugging();
}


void debugging() {
  if (debug) printIntArray(grid);
}


void printIntArray(int[][] arr) 
{
    println("");
    println("");
    println("");
    for (int x = 0; x < arr.length; x++)
    {
        for (int y = 0; y < arr[0].length; y++) 
        {

            print(arr[x][y] + ", ");
            
        }
        println();
    }
}
