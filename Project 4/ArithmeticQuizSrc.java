
package seitz_project4;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ArithmeticQuizSrc {

    // making the scanner object final and this scanner object will be used everywhere needed
    // multiple use of Scanner object may create problem so only one Scanner object will be used
    static final Scanner NUMBER_SCAN = new Scanner(System.in);
    // also making the printWriter final as the value won't be changed
    private final PrintWriter printWriter;
    private int problemsAttempted;
    private int correctlyAnswered;

    // constructor of the class
    public ArithmeticQuizSrc(PrintWriter printWriter) {
        this.printWriter = printWriter;
        // as these two variables will only be increased by 1, these variables are assigned with the value of 0
        problemsAttempted = 0;
        correctlyAnswered = 0;
    }

    public int getChoice() {
        int choice;
        System.out.println("Please choose one of the following options for your math quiz: \n"
                + "\t1. Addition with numbers 1-10 \n"
                + "\t2. Addition with numbers 1-100 \n"
                + "\t3. Subtraction with numbers 1-10 \n"
                + "\t4. Subtraction with numbers 1-100 \n"
                + "\t5. Multiplication with numbers 1-10 \n"
                + "\t6. Exit the program ");
        // taking input of the choice of the user
        choice = NUMBER_SCAN.nextInt();
        return choice;
    }

    // this method will set most of the methods that are needed to complete the quiz
    public void set(int lowerBound, int upperBound, char sign) {
        int num1, num2, userAns, correctAns, input1Value;
        System.out.print("Enter the number of problems you would like (1-5):");
        input1Value = NUMBER_SCAN.nextInt();
        // making sure no other input is accepted other than 1 to 5
        while (input1Value < 1 || input1Value > 5) {
            System.out.println("The number of problems must be between 1 and 5; please re-enter");
            input1Value = NUMBER_SCAN.nextInt();
        }
        for (int i = 0; i < input1Value; i++) {
            System.out.println("Enter the answer to the following problem: ");
            num1 = getRandomlyGeneratedNum(lowerBound, upperBound);
            // if it's substruction, then the upperbound will be first number as we don't want any negative number
            if (sign == '-') {
                num2 = getRandomlyGeneratedNum(lowerBound, num1);
            } else {
                num2 = getRandomlyGeneratedNum(lowerBound, upperBound);
            }
            userAns = displayProblemAndReturnAns(num1, num2, sign);
            correctAns = getCorrectAns(num1, num2, sign);
            // checking whether the answer given by the user is correct or not
            if (correctAns == userAns) {
                System.out.println("That is the correct answer!");
                correctlyAnswered += 1;
            } else {
                System.out.println("Sorry, that is incorrect. The correct answer is " + correctAns);
            }
            writeInfo(printWriter, num1, num2, sign, userAns, correctAns);
        }
    }

    // method for getting random number
    public int getRandomlyGeneratedNum(int lowerBound, int upperBound) {
        int randomNum = ThreadLocalRandom.current().nextInt(lowerBound, upperBound + 1);
        return randomNum;
    }

    public int displayProblemAndReturnAns(int num1, int num2, char sign) {
        System.out.println(num1 + " " + sign + " " + num2);
        int answer;
        // user is inserting an answer
        answer = NUMBER_SCAN.nextInt();
        problemsAttempted += 1;
        return answer;
    }

    public int getCorrectAns(int num1, int num2, char sign) {
        // using switch case to determine which arithmetic action needs to be taken
        switch (sign) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        // as all the returns are inside the switch case a return outside the switch had to be placed
        return -1;
    }

    public void writeInfo(PrintWriter printWriter, int num1, int num2, char sign, int userAns, int correctAns) {
        printWriter.println("Problem: " + num1 + " " + sign + " " + num2
                + "\nYour answer: " + userAns + "\nCorrect answer: " + correctAns + "\n");
    }

    public void finish(String fileName, String filePath) {
        double percentage;
        percentage = percentageCorrectedAns(problemsAttempted, correctlyAnswered);
        outputSummaryResults(printWriter, problemsAttempted, correctlyAnswered, percentage);
        // closing the printWriter object
        printWriter.close();
        System.out.println("Thank you for taking the WSU Math Quiz. A summary of your results " + fileName
                + "\n maybe found in the file - " + filePath);
    }

    public double percentageCorrectedAns(int problemsAttempted, int correctlyAnswered) {
        double percentage;
        // if a user doesn't attempt any problem, then the result will show NaN. So, adding condition to show 0 if that happens
        if (problemsAttempted == 0) {
            percentage = 0.00;
        } else {
            percentage = ((double) correctlyAnswered / (double) problemsAttempted) * 100;
        }
        return percentage;
    }

    public void outputSummaryResults(PrintWriter printWriter, int problemsAttempted, int correctlyAnswered, double percentage) {
        // using String.format to only print two digit after the floating point
        printWriter.println("You attempted " + problemsAttempted + " problems.\n"
                + "You answered " + correctlyAnswered + " problems correctly.\n"
                + "Your percentage score is " + String.format("%.2f", percentage));
    }
}
