import java.util.Random;

String input = "";
int result;
int guess;
Random rnd = new Random();

void setup() {
  println("Guess a number!");
  result = rnd.nextInt(100);
}

void draw() {
}

void keyPressed() {
  if (keyCode == ENTER) {
    println("Input: "+input);
    try {
      guess = Integer.parseInt(input);
      CheckNumber(guess);
    }
    catch(NumberFormatException e) {
      println(e);
    }

    input = "";
  } else {
    input += key;
  }
}

void CheckNumber(int userGuess) {
  if (userGuess == result) {
    println();
    println("You've guessed correct! Game Over!");
    println();
    println("A new random number has been generated!"); 
    result = rnd.nextInt(100);
  } else if (userGuess < result) {
    println("The number you've guessed is lower than result");
  } else {
    println("The number you've guessed is higher than result");
  }
}
