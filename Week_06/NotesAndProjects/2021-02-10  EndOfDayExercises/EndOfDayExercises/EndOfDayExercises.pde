
/* Exercise 1 */
//for (int i = 0; i <= 10; i++) {
//  println(i);
//};


/* Exercise 2 */
//int i = 0;
//while(i <= 10) {
//  println(i);
//  i++;
//}


/* Exercise 3 */
//int sum = 0;
//for (int i = 0; i <= 10; i++) {
//  sum += i;
//  println("i = " + i + ". Sum = " + sum);
//}


/* Exercise 4 */
//for (int i = 0; i <= 100; i += 6) {
//  println(i); 
//}


/* Exercise 5 */
//int startVal = 7;
//while (startVal > 0) {
//  String output = "";
//  for (int i = 0; i < startVal; i++) {
//    output += "*";
//  }
//  println(output);
//  startVal--;
//}


/* Exercise 6 */
color white = color(255);
color grey = color(60);

int increment = 0;
int rows = 8;
int rSize = 50;

Boolean isWhite = true; 

void setup() {
  size(450, 450);

  for (int i = 0; i < rows; i++) {
    for (int u = 0; u < rows; u++) {
      if (isWhite) fill(white);
      else fill(grey);

      rect(rSize * increment, rSize * i, rSize, rSize);

      isWhite = !isWhite;
      increment++;
    }
    isWhite = !isWhite;
    increment = 0;
  }
}
