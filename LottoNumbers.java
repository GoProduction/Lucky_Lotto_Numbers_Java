/*
* Developer: Erick McCoy
* Date: July 3, 2019
* Purpose: This program will generate random numbers and import into an array for lucky PowerBall numbers
*/

//Import libraries so functions are accessible
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

class LottoNumbers {

  public static void main(String[] args) {
    Menu();
  }
  //Method that generates white numbers
  public static int NormalNumberGen(){
    //Random variable, used from the Random library
    Random rand = new Random();
    //Generates random integer from a range of 1 - 69; formula is ((max - min) + 1) + min
    int number = rand.nextInt((69 - 1) + 1) + 1;
    return number;
  }
  //Method that generates PowerBall number
  public static int PowerballNumberGen(){
    //Random variable, used from the Random library
    Random rand = new Random();
    //Generates random integer from a range of 1 - 69; formula is ((max - min) + 1) + min
    int number = rand.nextInt((26 -1) + 1) + 1;
    return number;
  }
  //Main Game method
  public static void Game(){
    System.out.println("Alright! Spinning up!\n");
    //Initialize lotto number array, with 
    int lottoArray[] = new int[5];
    //For loop to iterate 5 times
    for(int i = 0; i < 5; i++){
      //On each iteration, lottoArray will receive a new number at index[i] with a generated number from NormalNumberGen()
      lottoArray[i] = NormalNumberGen();
    }
    //Sort the array
    Arrays.sort(lottoArray);
    //lottoArray will be copied (this will be used when printed) from an index range 0 - 5
    int[] whiteNumbers = Arrays.copyOfRange(lottoArray, 0, 5);
    //New integer is initialized to be displayed as the PowerBall number
    int powerBall = PowerballNumberGen();
    //Numbers are printed out
    System.out.println("Your lucky numbers will be: " + Arrays.toString(whiteNumbers) + ", PowerBall: " + powerBall);
  }
  //Menu method that asks for input to start
  public static void Menu(){
    //Input variable is declared
    char input;
    //Scanner variable is initialized
    Scanner sc = new Scanner(System.in);
    System.out.println("\nAre you ready for your lucky numbers? y/n");
    //Input variable is initialized from the Scanner variable
    input = sc.next().charAt(0);
    //If y is input from the keyboard
    if(input == 'y'){
      //Run the game
      Game();
    }
    //If n is input from the keyboard
    else if (input == 'n'){
      //Say goodbye
      System.out.println("Ok, goodbye...");
    }
    //Else, input is not valid, and Menu() is called again
    else{
      System.out.println("Invalid input. Please try again.");
      Menu();
    }
  }
  
}
