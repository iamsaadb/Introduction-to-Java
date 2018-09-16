package project.pkg5.vampire.hunt;

import java.util.Random;
import java.util.Scanner;

public class Project5VampireHunt {

    
    public static void Header(){
    System.out.println("\t***                                  ***");
    System.out.println("\t****                                ****");
    System.out.println("\t***** WELCOME TO SAAD VAMPIRE HUNT *****");
    System.out.println("\t****                                ****");
    System.out.println("\t***                                  ***\n");
    }


    /*This method generates the blood points*/
    public static int GenerateBloodPoints (){
        Random rand = new Random();
        // rand takes (max-min+1) + min  with max = 10 and min = 5
        int bp = rand.nextInt(6) + 5;
        System.out.println("Your health is at : " +bp+ "!");
        return bp;
    }
    /*This method give the victim a position in the 10x10 units square, its coordinates varies from 0 to 9
      it is called Cheat because it displays the position of the victim. This method will be used if the 
      user choose to cheat*/
    public static int [][] CheatGenerateVictimPosition (){
        Random rand = new Random();
        int pos = rand.nextInt(10) + 0;
        int [][] position = new int [1][2]; 
        position [0][0] = pos;
        pos = rand.nextInt(10) + 0;
        position [0][1] = pos;
        System.out.println("The position of the victim is: "+ position [0][0] + " " + position [0] [1] );
        return position;
    }
      /*This method give the victim a position in the 10x10 units square, its coordinates varies from 0 to 9
      This method assign a position to the victim but it doesn't display it in the console. This method will
      be used in case the user doesn't want to cheat*/
    public static int [][] GenerateVictimPosition (){
        Random rand = new Random();
        int pos = rand.nextInt(10) + 0;
        int [][] position = new int [1][2]; 
        position [0][0] = pos;
        pos = rand.nextInt(10) + 0;
        position [0][1] = pos;
        return position;
    }
    /* This method reads input from the user, x space and y of the guess. Then it breaks the string input
       and convert it into integers which will be saved in a 2D array */
    public static int[][] GuessVictimPosition (){
        String str;
        int [] [] pos = new int [1][2];
        Scanner input = new Scanner(System.in);
        System.out.print("Guess the victim's position. Make sure you enter your X, a space and then your Y --->  ");
        str = input.nextLine();
        String[] parts = str.split(" ");
        pos [0][0] = Integer.parseInt(parts[0]);
        pos [0][1] = Integer.parseInt(parts[1]); 
        return pos;
    }
    /*This method takes two arguments, the position of the victim and the guess of the user/vampire, and 
      returns the distance between both */
    public static double DistanceVampVic (int [][] array1, int [][] array2){
        double distance = Math.sqrt(Math.pow(array1[0][0] - array2 [0][0] , 2 ) + Math.pow(array1[0][1] - array2 [0][1] , 2 )); 
        return distance;
    }
    /* This method displays a feedback to the user based on his guess or distance to the victim, returns
       -1 if it is a good guess or 1 if it is not*/
    public static int TestD (double d){
        System.out.printf("\nYou are %.2f units from the victim \n", d);
        if (d == 0) {   
            System.out.println("**** You just bit the victim, S/He is now a vampire !!! **** ");
            return -1;
        }
        else{
            return 1;
        }   
    }
    
    /*This method generates a random number from 0 to 2 for the level of damage, displays a message 
      accordingly to the level of the damage. this method won't run unless if the user didn't guess the 
      victims position */ 
    public static int arrowDamage(double d){
        Random rand = new Random();
        int damageLevel = rand.nextInt(3) + 0;
            while (d!=0){
            if (damageLevel == 0) {
                System.out.println("Lucky you, the arrow missed you, your blood remains the same");
            }
            else if (damageLevel == 1) {
                System.out.println("Oups you were grazed by and arrow");
            }
            else {
                System.out.println("OUUUCH, the arrow just hit you ! ");
            }
        return damageLevel;
    } return -1 ;}
    
    
    /* MAIN FUNCTION */
    
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    Random rand = new Random();
    int x1,y1,damage;
    int cheat = 0;
    double d = 1;
    int [][] victimPos = new int [1][2];
    int [][] vampirePos = new int [1][2];
    Header();
    int bp =  GenerateBloodPoints();
    System.out.println("If you want to cheat press 1 otherwise press 0");
    cheat = input.nextInt();
    if (cheat == 1) {
    victimPos = CheatGenerateVictimPosition();
    }
    else victimPos = GenerateVictimPosition();
    while (bp>0 && d!=0 ){
    vampirePos = GuessVictimPosition();
    d = DistanceVampVic(victimPos,vampirePos);
    TestD(d);
    if (d==0) break;
    damage = arrowDamage(d);
    bp = bp - damage;
    System.out.println("Your actual health is : " + bp + " bloodpoints\n");
    if (bp <= 0) System.out.println("**** Game Over ****");
    }
    
    }
    
}
