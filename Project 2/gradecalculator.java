
package seitz_project2;

import java.util.Scanner;

/**
 * This program calculates the weighted grade averages from labs to exams.
 * Including a letter grade relating to the averaged grade.
 */
public class gradecalculator {

    public static void main(String[] args) {
        // variables
        double exam_weight = .50;
        double labs_weight = .15;
        double project_weight = .25;
        double quiz_weight = 10;

        int labs = 0;
        int quiz = 0;
        int project = 0;
        int exam = 0;

        //averages 
        double lab_avg = 0;
        double quiz_avg = 0;
        double project_avg = 0;
        double exam_avg = 0;
        double avg_grade = 0;
        // string assignments to name, char to single letter grade, and again if
        // you want to do the program again. 
        String name;
        char course_grade = 0;
        String again;
        //do statement do all of the instructions below from inputs to outputs. 
        do {
            // user inputs
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Please enter a name: ");
            name = keyboard.nextLine();
            System.out.println();

            // lab grades 
            System.out.println("Enter lab grade 1: ");
            labs = keyboard.nextInt();
            System.out.println("Enter lab grade 2: ");
            labs = keyboard.nextInt();
            System.out.println("Enter lab grade 3: ");
            labs = keyboard.nextInt();
            System.out.println("Enter lab grade 4: ");
            labs = keyboard.nextInt();
            System.out.println("Enter lab grade 5: ");
            labs = keyboard.nextInt();
            System.out.println();
            //project grades -3
            System.out.println("Enter project grade 1: ");
            project = keyboard.nextInt();
            System.out.println("Enter project grade 2: ");
            project = keyboard.nextInt();
            System.out.println("Enter project grade 3: ");
            project = keyboard.nextInt();
            System.out.println();
            //quiz grades -5
            System.out.println("Enter quiz grade 1: ");
            quiz = keyboard.nextInt();
            System.out.println("Enter quiz grade 2: ");
            quiz = keyboard.nextInt();
            System.out.println("Enter quiz grade 3: ");
            quiz = keyboard.nextInt();
            System.out.println("Enter quiz grade 4: ");
            quiz = keyboard.nextInt();
            System.out.println("Enter quiz grade 5: ");
            quiz = keyboard.nextInt();
            System.out.println();
            //exam grades -2 
            System.out.println("Enter exam grade 1: ");
            exam = keyboard.nextInt();
            System.out.println("Enter exam grade 2: ");
            exam = keyboard.nextInt();
            System.out.println();

            // averages and adding all of it. 
            lab_avg = labs / 5 * labs_weight * 100;
            quiz_avg = quiz / 5 * quiz_weight * 100;
            project_avg = project / 3 * project_weight * 100;
            exam_avg = exam / exam_weight * 100;
            avg_grade = (lab_avg + quiz_avg + project_avg + exam_avg) / 4 * 100;
            // if-else statements reflects on various grades relating letters. 
            if (avg_grade < 100) {
                course_grade = 'A';
            } else if (avg_grade <= 89 && avg_grade >= 80) {
                course_grade = 'B';
            } else if (avg_grade <= 79 && avg_grade >= 70) {
                course_grade = 'C';
            } else if (avg_grade <= 69 && avg_grade >= 60) {
                course_grade = 'D';
            } else if (avg_grade <= 59 && avg_grade >= 0) {
                course_grade = 'F';
            } else {
                System.out.println("Please enter an integer.");
            }
            // outputs 
            System.out.println("Grades for " + name + ": ");
            System.out.printf("\t Lab average: %.2f%% \n", lab_avg);
            System.out.printf("\t Project average: %.2f%% \n", project_avg);
            System.out.printf("\t Quiz average: %.2f%% \n", quiz_avg);
            System.out.printf("\t Exam average: %.2f%% \n", exam_avg);
            System.out.printf("Course average for " + name + ": %.2f \n", avg_grade);
            System.out.println("Course grade for " + name + ": \n" + course_grade);

            System.out.println("Do you want to enter grades for another student?(Y/N): ");
            again = keyboard.next();
        } while (again.equalsIgnoreCase("Y")); // while loop after do to "do" it again

    } // end main 

}// end program 
