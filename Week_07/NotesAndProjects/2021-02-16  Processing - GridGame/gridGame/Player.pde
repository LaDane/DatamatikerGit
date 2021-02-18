class Player {
  int x;
  int y;
  int move = 50;

  Player(int x, int y) {
    this.x = x;
    this.y = y;
  }

  void moveLeft() {
    x-=move;
  }
  void moveRight() {
    x+=move;
  }

  void moveUp() {
    y-=move;
  }

  void moveDown() {
    y+=move;
  }
}
