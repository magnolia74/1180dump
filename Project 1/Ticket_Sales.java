/*@author Hunter Seitz
 * CS1180 Summer 2020
 * Project1
 * 
 */
package seitz_project1;

import java.util.Scanner;

/**
 *This program demonstrates the ticket revenue using 
 * price of the tickets and how many. At the end, will have the total cost and price.  
 */
public class Ticket_Sales {

    public static void main(String[] args) {
        // constants
        final double ADULT_TICKETS = 29.00;
        final double STUDENT_TICKETS = 14.50;
        final double DISCOUNT = 0.1;

        //variables 
        int adult = 0; // using an integer to decalre both variables to how many tickets. 
        int student = 0;
        double totalCost = 0; // total cost for revenue of both tickets sold  
        double price; // total cost minus the discount 
        double bonus = 0;

        // Strings 
        String name;
        String answer;

        //boolean for if statement 
        boolean repeat = true;
        //user inputs
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter your name:");
        name = keyboard.nextLine();
        System.out.println();
        System.out.print("Please enter the number of adult tickets you are purchasing: ");
        adult = keyboard.nextInt();
        System.out.print("Please enter the number of student tickets you are purchasing: ");
        student = keyboard.nextInt();
        System.out.println("Are you a member of the Bonus Club (Y/N)?: ");
        answer = keyboard.next();

        // excuting math statements 
        totalCost = adult * ADULT_TICKETS + student * STUDENT_TICKETS;
        price = totalCost - bonus;
        // output
        System.out.println();
        System.out.println();
        System.out.print("Summary of purchase for " + name + ": ");
        System.out.println();
        System.out.println("Number of adult tickets purchased: " + adult);
        System.out.println("Number of student tickets purchased: " + student);
        System.out.println();
        System.out.println();
        System.out.printf("Total Cost: $%.2f\n", totalCost);
        System.out.printf("Discount: $%.2f\n", bonus);
        // if statements for discount (Bonus Club)
        if ("Y".equalsIgnoreCase(answer)) {
            bonus = totalCost / DISCOUNT;
        } else if ("N".equalsIgnoreCase(answer)) {
            System.out.println("Join our Bonus Club to recieve our discounts!");
        }

        System.out.printf("Purchase Price: $%.2f\n", price);
        System.out.println();

    }// end class

}// end main
