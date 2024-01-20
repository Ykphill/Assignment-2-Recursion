import java.util.InputMismatchException;
import java.util.Scanner;

// Name: Phillip Bell
// Class: CS 3305/Section 04
// Term: Spring 2024
// Instructor: Dr. Haddad
// Assignment: 2
// IDE Name: Inteli J

//This class takes in a string and count the number of vowels present
public class Vowels {
    public static void main(String[] args) {

         Scanner scan = new Scanner(System.in);

         boolean sentinelMain=true;    // sentinel variable for program
         boolean sentinelExcMenu=true; //exception loop variable
         int choice=0;
         String userString="";

         //sentinel loops for program
         do {

             //exception loop for menu
             do {

                 try {
                     //calls menu to prompt user for a choice
                     choice = menu();
                     sentinelExcMenu=false;
                 }
                 catch (InputMismatchException e) {
                     System.out.println("\nplease only input intergers");
                     sentinelExcMenu=true;
                 }
             } while (sentinelExcMenu);


             //take users input and call the method according to the function
             //reads in String to be manipulated
             if (choice == 1) {
            userString=readString();

             }

             //determines the amount of vowels in a string
             if (choice == 2) {
                //stops the user from having an empty string
                 if(userString.equals("")){
                        System.out.println("\nPlease read in an input first.");

                 }
                 //calls the method countVowel to determine how many vowel in a string
                 else {
                        int lastIndex = userString.length()-1;  //identifies the last index

                        System.out.println("\nYou entered string:\t"+userString+"\n"
                                +"Number of vowels:\t"+countVowels(userString,lastIndex));
                 }
             }

             //closes program
             if (choice == 3) {
                sentinelMain=false;
             }

             //prompt user to make a proper selection
             if (choice < 1 || choice > 3) {
                System.out.println("\nplease choose a option listed");
             }

         }while (sentinelMain);
    }

    // Print out menu and reads in input
    public static int menu(){
        Scanner scan = new Scanner(System.in);

        System.out.print("\n---------MAIN MENU---------\n" +
                "1. Read input string\n" +
                "2. Compute number of vowels\n" +
                "3. Exit program\n" +
                " Enter option number:\t");

        return scan.nextInt();
    }

    //Menu:option 1 read in String values
    public static String readString(){
        Scanner scan = new Scanner(System.in);

        System.out.print("\nEnter input string:\t");

        return scan.nextLine();

    }

    //Recusive method that counts vowels
    public static int countVowels(String userString,int lastIndex){
        //will count the number of vowels in each activation record
        int count=0;

        //base case
        if (lastIndex==0){
                //adds to count if it is a vowel and returns count
                if (isVowel(userString.charAt(lastIndex))==true){
                    count++;
                    return count;
                }
                //returns count
                return count;
        }
        else {

            //adds to count if it is a vowel and calls the method
            if (isVowel(userString.charAt(lastIndex))==true){
                count++;
                return count+countVowels(userString,lastIndex-1);
            }
            //calls the method
            else{
                return count+countVowels(userString,lastIndex-1);
            }
        }



    }

    //Determines if the character is vowel or not
    public static boolean isVowel(char character){

        //return true if a,e,u,i,o
        if(character=='a'|| character=='e'||character=='i'|| character=='o'|| character == 'u'){
        return true;
        }
        //non vowel return false
        else {
            return false;
        }
    }
}
