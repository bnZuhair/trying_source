/*
this is a project for trying stuf in java
edited by: Saleh.
last date time: 18/2/2022 
*/    

import java.util.Scanner;

public class Tryin {
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    int counter = 0, miles, gallons = 01;
    double sum = 0.0, milesPerGallons;

    System.out.println("if you want to add values press 1 ");
    miles = in.nextInt();
    if (miles == 1){
      while ( (miles != -1) || (gallons != -1) ){
        System.out.println("Enter the miles       note: if you want to stop adding enter the value -1");
        miles = in.nextInt();
        System.out.println("Enter the gallons      note: if you want to stop adding enter the value -1");
        gallons = in.nextInt();
         milesPerGallons = miles / gallons; 

         if(miles != -1 || gallons != -1){
        System.out.println("the miles per gallons is " + milesPerGallons);
        sum += milesPerGallons;
        System.out.printf("sum is:%f%n%d ",sum, counter);
          ++counter;
        }

      }

    }else{
      System.out.print("No values enterd by the user");
    }
    System.out.println(sum > 0 ? "the average miles per gallon is:"+ sum/counter : "");
  }
}
  

