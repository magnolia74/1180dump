/*@author Hunter Seitz
 * CS1180 Summer 2020
 * Project5
 * 
 */

package seitz_project5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.RoundingMode;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This program allows to use classes and file reading to output grades. 
 *  This is the main class. 
 */
public class GradeCalculatorMain {

    ArrayList<StudentGrades> studentGradesList = new ArrayList<>();
    String inputFileName = "";
    String outputFileName = "";

    public GradeCalculatorMain() {

        //Switchcase use for choosing inputfile
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Choose a text file");
        System.out.println("1.grades1.txt");
        System.out.println("2.grades2.txt");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                inputFileName = "grades1.txt";
                outputFileName = "grades1_out.txt";
                break;
            case 2:
                inputFileName = "grades2.txt";
                outputFileName = "grades2_out.txt";
                break;
            default:
                System.out.println("Please run again and  press 1 or 2");
                return;
        }

        //Fetch the grade's infromations from a input File.
        List<String> lineList = fetchDataFromFile(inputFileName);

        //Adding each grade's information into arraylist.
        addingGradesIntoStudentGradesList(lineList);

        //writing the averages to the output file.
        writeOutputFile(studentGradesList, outputFileName);

    }

    /**
     * The method used for fetching information from a intput file
     * @param inputFileName
     * @return
     */
    public List<String> fetchDataFromFile(String inputFileName) {
        List<String> lineList = new ArrayList<>();
        BufferedReader reader;
        try {

            reader = new BufferedReader(new FileReader(inputFileName));
            System.out.println();
            String line = reader.readLine();
            while (line != null) {
                lineList.add(line);
                //read next line
                line = reader.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineList;
    }

    /**
     * Adding each grade's information into arraylist.
     * @param lineList
     */
    public void addingGradesIntoStudentGradesList(List<String> lineList) {
        int informationOfSingleStudentStart = 0;
        int informationOfSingleStudentEnd = informationOfSingleStudentStart + 5;

        while (informationOfSingleStudentEnd < lineList.size() + 1) {
            List<String> gradeInformationOfSingleStudent = lineList.subList(informationOfSingleStudentStart, informationOfSingleStudentEnd);
            StudentGrades studentGrades = new StudentGrades(gradeInformationOfSingleStudent.get(0));

            //Removing white space from line string using split and adding the grades into arraylist
            List<String> splitedLabGrades = Arrays.asList(gradeInformationOfSingleStudent.get(1).split(" "));
            for (int i = 0; i < studentGrades.NUMBER_OF_LABS; i++) {
                studentGrades.addLabGrade(Double.parseDouble(splitedLabGrades.get(i)));
            }

            List<String> splitedProjectGrades = Arrays.asList(gradeInformationOfSingleStudent.get(2).split(" "));
            for (int i = 0; i < studentGrades.NUMBER_OF_PROJECTS; i++) {
                studentGrades.addProjectGrade(Double.parseDouble(splitedProjectGrades.get(i)));
            }

            List<String> splitedQuizGrades = Arrays.asList(gradeInformationOfSingleStudent.get(3).split(" "));
            for (int i = 0; i < studentGrades.NUMBER_OF_QUIZZES; i++) {
                studentGrades.addQuizGrade(Double.parseDouble(splitedQuizGrades.get(i)));
            }

            List<String> splitedExamGrades = Arrays.asList(gradeInformationOfSingleStudent.get(4).split(" "));
            for (int i = 0; i < studentGrades.NUMBER_OF_EXAMS; i++) {
                studentGrades.addExamGrade(Double.parseDouble(splitedExamGrades.get(i)));
            }

            //writing the information for each student to the screen
            displayGrades(studentGrades);

            studentGradesList.add(studentGrades);
            int hold = informationOfSingleStudentEnd;
            informationOfSingleStudentStart = hold;
            informationOfSingleStudentEnd = informationOfSingleStudentStart + 5;

        }

    }

    /**
     * writing the information for each student to the screen
     * @param studentGrades
     */
    public void displayGrades(StudentGrades studentGrades) {
        System.out.println("Grades for " + studentGrades.getName() + ":");
        System.out.printf("      Lab grades: " + studentGrades.getLabGrades()
                .toString()
                .replace("[", "")
                .replace("]", "")
                .trim() + " Lab average: %.2f%%\n", studentGrades.getLabAverage());

        System.out.printf("      Project grades: " + studentGrades.getProjectGrades()
                .toString()
                .replace("[", "")
                .replace("]", "")
                .trim() + " Project average: %.2f%%\n", studentGrades.getProjectAverage());

        System.out.printf("      Quiz grades: " + studentGrades.getQuizGrades()
                .toString()
                .replace("[", "")
                .replace("]", "")
                .trim() + " Quiz average: %.2f%%\n", studentGrades.getQuizAverage());

        System.out.printf("      Exam grades: " + studentGrades.getExamGrades()
                .toString()
                .replace("[", "")
                .replace("]", "")
                .trim() + " Exam average: %.2f%%\n", studentGrades.getExamAverage());

        System.out.printf("      Course Average: %.2f%%\n\n", studentGrades.getCourseAverage());
    }

    /**
     * writing the averages to the output file.
     * @param studentGradesList
     * @param outputFileName
     */
    private void writeOutputFile(ArrayList<StudentGrades> studentGradesList, String outputFileName) {
        DecimalFormat df = new DecimalFormat("0.0");
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        try {
            FileWriter fw = new FileWriter(outputFileName);

            fw.write(padRight("name", 20)
                    + padRight("Lab Avg", 20)
                    + padRight("Project Avg", 20)
                    + padRight("Quiz Avg", 20)
                    + padRight("Exam Avg", 20)
                    + padRight("Course Avg\n", 1)
            );
            fw.write(System.getProperty("line.separator"));
            for (StudentGrades s : studentGradesList) {
                fw.write(padRight(s.getName(), 21));
                fw.write(padRight("" + df.format(s.getLabAverage()), 20));
                fw.write(padRight("" + df.format(s.getProjectAverage()), 20));
                fw.write(padRight("" + df.format(s.getQuizAverage()), 20));
                fw.write(padRight("" + df.format(s.getExamAverage()), 20));
                fw.write(padRight("" + df.format(s.getCourseAverage()), 20));
                fw.write(System.getProperty("line.separator"));

            }

            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Successfully writing the averages to the output file.....");
    }

    /**
     * Adding space among names and grades
     * @param s
     * @param n
     * @return
     */
    public String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }

    /**
     * Main Method
     * @param args
     */
    public static void main(String[] args) {
        new GradeCalculatorMain();
    }

}
