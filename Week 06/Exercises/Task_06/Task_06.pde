/*
6.a make 2 integer variables named a and b. 
 Print "Success!" if either of them is equal to 10 or if the sum is. If not, print "Failure!".
 
 6.b make 3 integer variables named x, y and z. 
 Print "Success!" if their sum is 30, but none of them may have the value of 10, 20 or 30. Otherwise print "Failure!".
 */


/* 6.a */
int a = 2;
int b = 8;

if (a + b == 10) {
  println("Succes!");
} else {
  println("Failure!");
}

println();


/* 6.b */

int x = 8;
int y = 7;
int z = 15;
int[] numbers = new int[3];

Boolean isFail = false;

numbers[0] = x;
numbers[1] = y;
numbers[2] = z;

if (x + y + z == 30) {
  for (int i = 0; i < numbers.length; i++) {
    if (numbers[i] == 10 || numbers[i] == 20 || numbers[i] == 30) {
      isFail = true;
    }
  }
} else {
  isFail = true;
}

if (isFail) {
  println("Failure!");
} else {
  println("Succes!");
}
