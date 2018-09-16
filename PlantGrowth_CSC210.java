package project3;
import java.util.Scanner;



public class Project3 {

/*IN THE PROGRAM BELOW I USED MONTHS FROM 1 TO 12 INSTEAD OF 0 TO 11, THANK YOU */    
    
//Below I defined 3 functions header, trackGrowth, and Display   
//function header prints tabs
public static void header(){

System.out.println("\nMonth    Temp  Rain  Growth    Plant Height");
}


//function trackGrowth takes 5 parameters 
public static int trackGrowth(int min, int max, int minrain ,int avTemp,int avRain){
    int a=0;
    //loop runs through the months 
    for (int i=0; i<12;i++){
    //if the average temperature is beyond the min-max range ==> a = -1
        if ( avTemp <min || avTemp > max ){
        a = -1;
        }
    //else a ==>  averageRain minus minimum rainfall requiered for the plant
        else a = avRain-minrain;
    }
    //return the value of a
return a;
}
    

//Display takes 4 arrays and print the values of the arrays in organized table
  public static void Display(int[] a, int[] b, int[] c, int [] d){
        for (int i=0; i<12 ; i++){
        // Printing the values of months from 1 to 12, temp, rain, growth, and plant height respectively
         System.out.printf("%-10d%-6d%-7d%-13d%d\n",i+1,a[i],b[i],c[i],d[i]);
        }


    }



    public static void main(String[] args) {
        
     final int NUMMONTHS = 12;
     int [] avgTemp = {46, 48, 49, 50, 51, 53, 54, 55, 56, 55, 51, 47};
     int [] avgRain = {5, 3, 3, 1, 1, 0, 0, 0, 0, 1, 3, 4};
     int [] newGrowth,newHeight;
     newGrowth = new int[NUMMONTHS];
     newHeight = new int[NUMMONTHS];
     int [] maxHeight = {0,0}; //First value of the array will be reserved for the maxheight, the second for the month where the plant hit that height
     newHeight [0] = 0;
     int minTemp=0;
     int maxTemp=0;
     int minRain=0;
     int i,j,k,l=0;
     Scanner input = new Scanner(System.in);
     System.out.println("\n******** WELCOME TO SAAD BOUAYAD FARM ********\n");
     System.out.println("Enter minimum temperature for plant, please:");
     minTemp = input.nextInt();
     System.out.println("Enter maximum temperature for plant, please:");
     maxTemp = input.nextInt();
     System.out.println("Enter minimum rainfall for plant, please:");
     minRain = input.nextInt();
     
     //Printing the header or tabs
     
     header();
     
        for ( i=0 ; i<NUMMONTHS ; i++ ){  
              newGrowth[i] = trackGrowth(minTemp,maxTemp,minRain,avgTemp[i],avgRain[i]);
              /* because the first value of the array doesnt have a predecessor 
              it is impossible to merge the conditions, so in this case, in case newGrowth is neg. height will remain null*/
              if (i == 0 && newGrowth[0]<0) { newHeight[0]=0; maxHeight[0]=0; maxHeight[1] = 1;}
              /* i=0, but growth is positive, newheight will take value of growth, and the MaxHeight will take the value in its x coordinate
              and the respective value of month in its y*/
              else if (i == 0 && newGrowth[0]>=0) { newHeight[0]=newGrowth[0]; maxHeight[0]=newHeight[i]; maxHeight[1] = 1;}
              // added this condition cus the height cannot be negative, so means height will be null. 
              else if ( i>0 && newHeight[i-1]+newGrowth[i]<0) { newHeight[i]=0;}
              // in case everything is positive, we will add the new value of growth to the previous value of height
              //means that the plant height will increase by the value of growth
              else if ( i>0 && newHeight[i-1]+newGrowth[i]>=0) { newHeight[i] = newHeight[i-1] + newGrowth[i];}
              // maxHeight values won't increase unless if the newheight at the month i is sup than the actual maxheight
              if (newHeight[i]>maxHeight[0]){ maxHeight[0]=newHeight[i]; maxHeight[1] = i+1;}
        }
     //Display arrays values in ordered table
     Display(avgTemp,avgRain,newGrowth,newHeight);
     //EXTRA CREDIT Question : displays the height and month where the plant reaches the peak height
     System.out.printf("\nThe plant reached the max height of %d at Month %d  \n",maxHeight[0],maxHeight[1]  );
    }
    
}