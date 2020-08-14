
package arithmeticquiz;

import project4.ArithmeticQuizSrc;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * READ THIS: You must run this program only because this main file needs to run on ArithmeticQuizSrc. 
 * This program allows to run a math quiz from addition to multiplication with different methods
 * and output to file to write a grades result. 
 */
public class ArithmeticQuiz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // saving the file name in a varible so in future only once the name needs to be changed if needed
        String fileName = "outputStats.txt";
        File outputStatsFile = new File(fileName);
        // adding try catch block
        try {
            outputStatsFile.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(ArithmeticQuiz.class.getName()).log(Level.SEVERE, null, ex);
        }
        // adding try catch block
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            // to make sure no previous data stays in the file
            fileWriter.write("");
            // adding try catch block
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
                // initializing variables
                int choice = 8, lowerBound, upperBound;
                char sign;
                // creating arithmeticQuiz object to perform the quizes and other tasks
                ArithmeticQuizSrc arithmeticQuiz = new ArithmeticQuizSrc(printWriter);
                while (choice != 6) {
                    choice = arithmeticQuiz.getChoice();
                    // using switch to get various result based on the given input
                    switch (choice) {
                        case 1:
                            // setting lower bound, upper bound and sign
                            lowerBound = 1;
                            upperBound = 10;
                            sign = '+';
                            // passing the assigned values to the arithmeticQuiz object
                            arithmeticQuiz.set(lowerBound, upperBound, sign);
                            break;
                        case 2:
                            lowerBound = 1;
                            upperBound = 100;
                            sign = '+';
                            arithmeticQuiz.set(lowerBound, upperBound, sign);
                            break;
                        case 3:
                            lowerBound = 1;
                            upperBound = 10;
                            sign = '-';
                            arithmeticQuiz.set(lowerBound, upperBound, sign);
                            break;
                        case 4:
                            lowerBound = 1;
                            upperBound = 100;
                            sign = '-';
                            arithmeticQuiz.set(lowerBound, upperBound, sign);
                            break;
                        case 5:
                            lowerBound = 1;
                            upperBound = 10;
                            sign = '*';
                            arithmeticQuiz.set(lowerBound, upperBound, sign);
                            break;
                    }
                }
                // finishing the program with the finishing tasks such as showing file path and storing percentage in the file
                arithmeticQuiz.finish(fileName, outputStatsFile.getAbsolutePath());
                // closing the opened writers..
                printWriter.close();
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                System.err.print("Something went wrong");
            }
        } catch (IOException e) {
            System.err.print("Something went wrong");
        }
    }
} // end main 
