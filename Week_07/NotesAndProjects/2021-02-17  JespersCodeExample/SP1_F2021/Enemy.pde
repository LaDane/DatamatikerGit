class Enemy
{
    int x; 
    int y; 
    int type = 1; 
    Player player;

    Enemy(int x, int y, Player player)
    {
        this.x = x;
        this.y = y;
        this.player = player;
    }

    void RandomStartPosition() {
            
    }

    void MoveTowardsPlayer()
    {
      
        int xDistance = Math.abs(player.x - x);
        int yDistance = Math.abs(player.y - y);

        // random chance (~25% chance) for at enemy flytter sig i en tilfældig retning. 

        if (xDistance > yDistance)
        {
            // opdatér x værdi til at rykke ét felt nærmere playeren!
        } 
        else
        {
            // opdatér y værdi til at rykke ét felt nærmere playeren!
        }
    }
}
