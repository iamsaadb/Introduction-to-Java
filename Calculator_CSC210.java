package javaapplication2;
import java.util.Scanner;

public class JavaApplication2 {  
      public static final int REPETITION = 3;
      public static void main(String[] args) throws InterruptedException { 
      
      int i = 0;
      while ( i < REPETITION ){   
      Menu();
      double a,b;
      Scanner input = new Scanner(System.in);
      int op = input.nextInt();
     
      if (op == 1){
      Scanner num = new Scanner(System.in);
      System.out.println("Enter you first number ");
      a = num.nextDouble();
       System.out.println("Enter you Second number ");
      b = num.nextDouble();
      Add(a,b);
      }
      
      else if (op == 2){
      Scanner num = new Scanner(System.in);
      System.out.println("Enter you first number ");
      a = num.nextDouble();
       System.out.println("Enter you Second number ");
      b = num.nextDouble();
      Sub(a,b);
      }
      
      else if (op == 3){
      Scanner num = new Scanner(System.in);
      System.out.println("Enter you first number ");
      a = num.nextDouble();
       System.out.println("Enter you Second number ");
      b = num.nextDouble();
      Mul(a,b);
      }
      
      else if (op == 4){
      Scanner num = new Scanner(System.in);
      System.out.println("Enter you first number ");
      a = num.nextDouble();
       System.out.println("Enter you Second number ");
      b = num.nextDouble();
      Div(a,b);
      }
      
      else if (op == 5){
      Scanner num = new Scanner(System.in);
      System.out.println("Enter you first number ");
      int B = num.nextInt();
       System.out.println("Enter you Second number ");
      int C = num.nextInt();
      Powerfunc(B,C);
      }
      
      else if (op == 6){
       System.out.println("THANK YOU FOR USING CALCULATOR. SEE YOU NEXT TIME.");  break;    }
       
       else System.out.println("The option that you entered is unavailable, PLEASE CHOOSE AN OPERATION FROM \n 1 TO 5 OR TYPE 6 TO EXIT");
      System.out.println("\n\n");
      i++; }
  
    }
      //Display Menu
      public static void Menu()
      {
           System.out.println("Select on Operation:\n1. Add\n2. Subract\n3. Multiply\n4. Divide\n5. Power/Exponential\n6. Exit");         
      System.out.println("\n\n PLEASE SELECT FROM 1 TO 5 TO CHOOSE YOUR OPERATION OR 6 TO EXIT");

      }
      //Addition
      public static void Add(double num1, double num2){
      double sum = num1+num2;
      System.out.println("Result is:  " + sum);
      }
      
       //Substraction
      public static void Sub(double num1, double num2){
      double sub = num1-num2;
      System.out.println("Result is:  " + sub);
      }
      
      //Multiplification 
      public static void Mul(double num1, double num2){
      double mul = num1*num2;
      System.out.println("Result is:  " + mul);
      }
      
       //Division
      public static void Div(double num1, double num2){
      double div = num1/num2;
      System.out.println("Result is:  " + div);
      }

      //Power
      public static void Powerfunc(int base, int power){
      int j ;
      int res = 1;
      if (power ==0) {System.out.println("Result is: " + res);}
      else { for(j=1;j<=power;j++) { res = res * base; }
            System.out.println("Result is: " + res);  
              }
      
      }

      
      }


