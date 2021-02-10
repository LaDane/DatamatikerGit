/*
Have a look at the file in the folder named "TaskFive".
 5.a solve the problem presented in MethodOne.
 5.b solve the problem presented in MethodTwo.
 */

void setup() {
  MethodOne();
  println();
  MethodTwo();
}


/*
The following method has an error in it. Fix the error and run it. 
*/

void MethodOne() {
  int i = 1000; // You are not allowed to change this line. 
  int max = 10;

  String output = "";    // variable was local to if statement and could not be fetched in println

  if (i > max) {
    output += "i is greater than " + max + ".";
  }

  println(output);
}


/* 
Finish the following method so that we can change the number assigned 
to the weekday and it prints the correct output.  
*/

void MethodTwo() {
  int weekNumber = 0; // 0 = Monday, 6 = Sunday. 
  String weekDay = "";
  boolean weekend = false;

  if (weekNumber < 5) {
    weekend = false;
  } else {
    weekend = true;
  }

  /* if statements 
  if (weekNumber == 0)
    weekDay = "Monday";
  if (weekNumber == 1)
    weekDay = "Tuesday";
  if (weekNumber == 2)
    weekDay = "Wednesday";
  if (weekNumber == 3)
    weekDay = "Thursday";
  if (weekNumber == 4)
    weekDay = "Friday";
  if (weekNumber == 5)
    weekDay = "Saturday";
  if (weekNumber == 6)
    weekDay = "Sunday";
  */

  /* switch case */
  switch(weekNumber) {
    case 0: weekDay = "Monday"; break;
    case 1: weekDay = "Tuesday"; break;
    case 2: weekDay = "Wednesday"; break;
    case 3: weekDay = "Thursday"; break;
    case 4: weekDay = "Friday"; break;
    case 5: weekDay = "Saturday"; break;
    case 6: weekDay = "Sunday"; break;
  }


  // Print the name of the weekday here: 
  println("It is " + weekDay + " today!");  


  // Print if it is weekend here:
  if (weekend)
    println("It's a weekend today!");
  else
    println("It is unfortunately not a weekend today.");
}  
