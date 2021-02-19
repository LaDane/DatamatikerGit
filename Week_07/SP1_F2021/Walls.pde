class Walls {
    
    /* Generate random unwalkable walls using perlin noise */
    
    float perlinCap;
    float scl;
    

    Walls(float _perlinCap, float _scl) {
        this.perlinCap = _perlinCap;
        this.scl = _scl;
    }


    void generateWalls() {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {        
                float perlinPos = noise(x * scl, y * scl);
                if (perlinPos >= wallPerlinCap) {
                    grid[x][y] = 4;
                }
            }
        }
    }
}
