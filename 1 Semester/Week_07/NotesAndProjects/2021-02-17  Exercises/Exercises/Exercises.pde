///* Exercise 1 */

//int[] a = new int[]{ 1, 3, 3, 7 };
//int[] b = new int[a.length];


//for (int i = 0; i < a.length; i++) {
//  b[i] = a[i];
//}

//a[0] += 1;

//println("a elements");
//println(a);
//println();
//println("b elements");
//println(b);




/* Exercise 2 */
int[] sixElements = new int[]{ 1, 3, 5, 7, 9, 11 };
int[] shiftedElements = new int[sixElements.length];

void setup() {
  shiftUp(sixElements);
  printElements(sixElements, shiftedElements);
}

void shiftUp(int[] array) {
  int tempInt = array[0];
  for (int i = 0; i < array.length; i++) {

    if (i + 1 >= array.length) {
      shiftedElements[i] = tempInt;
      break;
    }

    shiftedElements[i] = array[i + 1];
  }
}

void printElements(int[] array1, int[] array2) {
  println("First array");
  println(array1);
  println();
  println("Second Array");
  println(array2);
}
