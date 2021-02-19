class Walls {
    
    /* Generate random unwalkable walls using perlin noise */
    
    float perlinCap;
    float scl;
    

    Walls(float _perlinCap, float _scl) {
        this.perlinCap = _perlinCap;
        this.scl = _scl;
    }


    void wallGeneration() {
        generateWalls();
        // createWallHoles();
    }


    void generateWalls() {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {        
                float perlinPos = noise(x * scl, y * scl);
                
                if (x < 5 || x > gridLength - 5 || y < 5 || y > gridLength -5) continue;                                                                    // dont make walls around border of board
                if ((x >= (gridLength / 2) - 5) && (x <= (gridLength / 2) + 5) && (y >= (gridLength / 2) - 5) && (y <= (gridLength / 2) + 5)) continue;     // dont make walls in 10x10 area around player spawn      
                
                if (perlinPos >= wallPerlinCap) {
                    grid[x][y] = 4;
                }
            }
        }
    }
    
    void createWallHoles() {
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                grid[x][y] = 0;
            }
        }
        for (int x = gridLength - 1; x > gridLength - 5; x--) {
            for (int y = gridLength - 1; y > gridLength - 5; y--) {
                grid[x][y] = 0;
            }
        }
    }
}
