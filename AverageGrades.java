// Name: Phillip Bell
// Class: CS 3305/Section 04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 2
// IDE Name: Inteli J

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//This class takes in a class size and the students grade then gives a average
public class AverageGrades {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        boolean sentinelMain = true;        //sets sentinel value for program
        boolean sentinelExcMenu = false;    //sets sentinel value for menu

        int choice = 0;                     //choice for menu
        int classSize = 0;                  //initializes class size
        int [] classGrades=null;            //initializes class grades

        do {

            //exception loop for menu
            do {

                try {
                    //calls menu to prompt user for a choice
                    choice = menu();
                    sentinelExcMenu = false;
                } catch (InputMismatchException e) {
                    System.out.println("\nplease only input intergers");
                    sentinelExcMenu = true;
                }
            } while (sentinelExcMenu);



           //take users input and call the method according to the function//reads in String to be manipulated
            if (choice == 1) {

                    classSize = readClassSize();
            }

            //determines the amount of vowels in a string
            if (choice == 2) {

                //stops the user from having an empty class
                if(classSize==0){
                    System.out.println("\nThe class has no student Please input class size first.");
                }
                //calls the method
                else  {
                    classGrades = new int [classSize];
                   classGrades =readClassGrades(classGrades);


                }
            }
            //determines the amount of vowels in a string
            if (choice == 3) {


                //stops the user from having an empty class
                if(classSize==0){
                    System.out.println("\nThe class has no student Please input class size first.");
                }
                //stop user from having empty grades
                if (classGrades==null){
                    System.out.println("\nThe class has no grades.");
                }
                //calls the method
                else {
                        //finds average
                        double average=findAverage(classGrades,classSize-1,classSize);
                        //prints average/class size/ grades
                        printAverage(classGrades,average,classSize);

                }

            }

            //closes program
            if (choice == 4) {
                sentinelMain=false;
            }

            //prompt user to make a proper selection
            if (choice < 1 || choice > 4) {
                System.out.println("\nplease choose a option listed");
            }


            } while (sentinelMain);

        }

        // Print out menu and reads in input
        public static int menu(){
            Scanner scan = new Scanner(System.in);

            //prints out menu
            System.out.print("\n--------MAIN MENU-------\n" +
                    "1. Read class size\n" +
                    "2. Read class grades\n" +
                    "3. Compute class average\n" +
                    "4. Exit program\n" +
                    "Enter option number:\t");

            return scan.nextInt();
        }

        //reads  in the amount of students in class
        public static int readClassSize(){

            Scanner scan = new Scanner(System.in);

            int choice=0;
            boolean sentinel = true;

            do {
                //exception loop
                try {
                    System.out.print("\nPlease enter the amount of students:\t");
                    choice = scan.nextInt();
                    if(choice<1){
                        System.out.print("Please enter amount greater than 0\n" );
                    }
                    else {
                        sentinel= false;
                    }


                } catch (InputMismatchException e) {
                    System.out.println("Please only enter integers\n");
                }
                scan.nextLine();

            }while (sentinel);


            return choice;


        }

        //read in class grades
        public static int[] readClassGrades(int[] grades){

        Scanner scan = new Scanner(System.in);


        boolean sentinel = true;//sentinel variable
        //exception loop
        do {

            try {
                //prompt
                System.out.println("\nPlease enter students grades");

                //Iterates through array and assigns students grades
                for (int i = 0; i < grades.length ; i++) {

                    boolean sentinelGrade=true;
                    //ensure user only input 0 to 100
                    do {
                        System.out.print("Student " + (i + 1) + ":\t");
                        grades[i] = scan.nextInt();
                        scan.nextLine();

                        sentinelGrade=false;

                        //catches incorect inputs
                        if (grades[i]<0 ||100<grades[i]){
                            System.out.println("Only input integer 0-100");
                            sentinelGrade=true;
                        }
                    }while (sentinelGrade);
                }
                sentinel=false;


            } catch (InputMismatchException e) {
                System.out.println("Please only enter integers");
                scan.nextLine();
            }

        }while (sentinel);

        return grades;


    }

        //recursive method that take the average of students grades
        public static double findAverage(int[] grades,int lastIndex,int divider){

            //base case
            if(lastIndex==0){
                return grades[lastIndex];
            }
            //last recursive call
            if(divider==lastIndex+1){

                return ((grades[lastIndex]+findAverage(grades,lastIndex-1,divider))/divider);
            }
            //everyother instance of recursive calls
            else{
                return grades[lastIndex]+findAverage(grades,lastIndex-1,divider);
            }

        }

        //prints the average of the class ,size and grades
        public static void printAverage(int[] grades,double average,int classSize){

            //class size
            System.out.println("\nYou entered class size:\t\t"+classSize);

            //loops and prints all values in array
            System.out.print("You entered grades:\t\t\t");
            for (int i = 0; i < classSize; i++) {
                System.out.print(grades[i]+" ");
            }

            //prints class average
            System.out.printf("\nClass average:\t\t\t\t%.2f", average);
            System.out.print("\n");
        }

}
