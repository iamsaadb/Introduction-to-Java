package project4;
import java.util.Scanner;
import java.util.Random;

public class Project4 {

//both TestCircle and TestCircle2 do the same thing, except that TestCircle2 return value that will help in later tests
public static void TestCircle(int x, int y, int r){
//test for point inside the circle    
if (Math.pow(x,2)+ Math.pow(y,2)<Math.pow(r,2)) {
System.out.printf("The point ( %d , %d ) is within the circle\n",x,y);

}
//test for point on the edges
else if (Math.pow(x,2)+Math.pow(y,2)==Math.pow(r,2)) {
System.out.printf("The point (%d , %d) belongs to the edge of the circle\n",x,y);

}
//test for point outside the circle
else {System.out.printf("The point (%d , %d) is outside the circle\n",x,y); 

}
}


public static int TestCircle2(int x, int y, int r){
    
if (Math.pow(x,2)+ Math.pow(y,2)<Math.pow(r,2)) {
return 0;
}

else if (Math.pow(x,2)+Math.pow(y,2)==Math.pow(r,2)) {
return 1;
}

return 2;
}
 
    
    public static void main(String[] args) {
     /* x and y are used to save coordinates
        r is used to save radius
        n is the random number
        eff is the total point that the user wants to generate
        i and j are counters for the bidimensional array
        inCir is the number of points inside the circle
        and number is the result of inCir * 4 / eff which diverge to PI 
        */
    int x,y,r,n,eff,i,j,inCir=0;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a radius:  ");
    r = input.nextInt();
    System.out.print("Enter X coordinate:  ");
    x = input.nextInt();
    System.out.print("Enter Y coordinate:  ");
    y = input.nextInt();
    TestCircle(x,y,r);
    // The 15% extra credit starts here 
    System.out.print("Enter a RADIUS:  ");
    r = input.nextInt();
    
    System.out.print("Enter the number of point to generate:  ");
    eff = input.nextInt();
    
    //coor is bidimensional array used to save coordinates of random points
    int [][] coor = new int [eff][eff]  ;

    //This look is to load the array with points' coordinates 
    for (i=0;i<eff;i++){
        for (j=0;j<2;j++){
         Random rand = new Random();
         n = rand.nextInt(r) + 0;
         coor[i][j]=n;
         //i copy the value of each x and y of the point to make a test
         x = coor[i][0];
         y = coor[i][1];
        }
        //test returning 0 if the points (x,y) is inside the circle, if the return value is 0, inCir increments by 1
        if (TestCircle2(x,y,r)==0) {inCir++; }
    }
    //this line prints the points x y of each line
    for (i=0;i<eff;i++){
        for (j=0;j<2;j++){
        System.out.printf("%4d",coor[i][j]);
         
        }
         System.out.println("");
    }
    //print in the result of the program, unCir is the number of points inside the circle
    System.out.println("Points within the circles are " + inCir);
    //cast double number into number 
    double number= (double) inCir*4/eff;
    System.out.println("The number is " + number);  }
}
    
