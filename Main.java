// importing library, particularly in order to use scanner and math functions //
import java.util.*;

public class Main {
  public static void main(String[] args) {
    // code will work until the user no longer wants to continue //
    boolean run = true;
    while(run) {
      // 21 students - assigning them to a string array //
      String[] students = {"Syed","Andrew","Han","Bryan","Anthony","Daniel","Evan","Jun","Bin","Ryan","Alex","Alan","Sunqiao","Wilson","Tahiya","Fu Jun","Shuoshuo","Jonathan","Jack","Xu","ShungHuei"};   
      ArrayList<String> names = new ArrayList<>();
      // creating an ArrayList and loop through "students" array in order to add every student to the list //
      for(String values : students) {
        names.add(values);
      }
      System.out.println("Students: \n" + names);
      Scanner input = new Scanner(System.in);
      // asking user to enter amount of students that would be in each group and storing it in num//
      System.out.print("\nHow many students per group? ");
      int num = input.nextInt();
      // calling a chart function //
      chart(names, num);
      // asking whether the user wants to continue //
      System.out.println("\nDo you want to change size? y/n");
      String s = input.next();
      if(s.equalsIgnoreCase("y")) {
        run = true;
      }
      else {
        run = false;
      }
    }
  }
  
  public static void chart(ArrayList<String> names, int num) {
    // creating a new variable - amount, to determine the number of groups it will take to have num amount of students in it //
    int amount = 0;
    // if the number of students is divisible by the number of students in each group, then we can divide two integers and get the number of groups we need //
    if(21 % num == 0) {
      amount = 21 / num;
    }
    // other case scenario //
    else {
      amount = (21 / num) + 1;
    }

    // creating a 2D array to store number of groups and students in it //
    String[][] seats = new String[amount][num];

    // going through each value in the array and randomly assign students to their "seats" and then remove that student from the list //
    for (int row = 0; row < amount; row++){
      for(int col = 0; col < seats[row].length; col++){
        int number = (int)(Math.random()*names.size());
        seats[row][col]= names.get(number);
        names.remove(number);
      }

      // printing out each group / final outcome //
      System.out.println("\nGroup " + (row + 1) + ": " + Arrays.toString(seats[row]) + ".");

      // in case there're less students than a certain number determined by the user in the group, then we replace that spot with an empty sign //
      if(names.size() == 0) {
        break;
      }
      else if(names.size() < num) {
        // going through left "seats" and adding "Empty" to it //
        for(int k = names.size(); k < num; k++) {
          names.add("EMPTY");
        }
        System.out.println("\nGroup " + (row + 2) + ": " + names + ".");
        break;
      }
    }
  }
}