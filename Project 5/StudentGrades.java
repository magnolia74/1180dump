
package project5;

import java.util.ArrayList;


public class StudentGrades {
    public static final double NUMBER_OF_LABS = 5;
    public static final double MAX_LAB_POINTS = 10;
    public static final double NUMBER_OF_PROJECTS = 3;
    public static final double MAX_PROJECT_POINTS = 50;
    public static final double NUMBER_OF_QUIZZES = 5;
    public static final double MAX_QUIZ_POINTS = 5;
    public static final double NUMBER_OF_EXAMS = 2;
    public static final double MAX_EXAM_POINTS = 100;
    public static final double LAB_WEIGHT = .15;
    public static final double PROJECT_WEIGHT = .25;
    public static final double QUIZ_WEIGHT = .10;
    public static final double EXAM_WEIGHT = .50;

    private String name;
    private ArrayList<Double> labGrades;
    private ArrayList<Double> projectGrades;
    private ArrayList<Double> quizGrades;
    private ArrayList<Double> examGrades;

    public StudentGrades(String name) {
        this.name = name;
        labGrades = new ArrayList<>();
        projectGrades = new ArrayList<>();
        quizGrades = new ArrayList<>();
        examGrades = new ArrayList<>();
    }

    //set student name
    public void setName(String name) {
        this.name = name;
    }

    //add the lab grades into a list
    public void addLabGrade(double grade) {
        this.labGrades.add(grade);
    }

    //add the project grades into a list
    public void addProjectGrade(double projectGrade) {
        this.projectGrades.add(projectGrade);
    }

    //add the quiz grade into a list
    public void addQuizGrade(double quizGrade) {
        this.quizGrades.add(quizGrade);
    }

    //add the exam grade into a list
    public void addExamGrade(double examGrade) {
        this.examGrades.add(examGrade);
    }

    //acquire the student name
    public String getName() {
        return name;
    }

    //acquire the list of lab grades
    public ArrayList<Double> getLabGrades() {
        return labGrades;
    }

    //acquire the list of project grades
    public ArrayList<Double> getProjectGrades() {
        return projectGrades;
    }

    //acquire the list of quiz grades
    public ArrayList<Double> getQuizGrades() {
        return quizGrades;
    }

    //acquire the list of exam grades
    public ArrayList<Double> getExamGrades() {
        return examGrades;
    }

    /**
     * calculating lab average point
     * @return
     */
    public double getLabAverage() {
        double total = 0;
        for (int i = 0; i < NUMBER_OF_LABS; i++) {
            total = total + labGrades.get(i);
        }
        double average = total /NUMBER_OF_LABS ;
        double percentage = (average/MAX_LAB_POINTS)*100;
        return percentage;
    }

    /**
     * calculating project average point
     * @return
     */
    public double getProjectAverage() {
        double total = 0;
        for (int i = 0; i < NUMBER_OF_PROJECTS; i++) {
            total = total + projectGrades.get(i);
        }
        double average = total /NUMBER_OF_PROJECTS;
        double percentage = (average/MAX_PROJECT_POINTS)*100;
        return percentage;
    }

    /**
     * calculating quiz average point
     * @return
     */
    public double getQuizAverage() {
        double total = 0;
        for (int i = 0; i < NUMBER_OF_QUIZZES; i++) {
            total = total + quizGrades.get(i);
        }
        double average = total /NUMBER_OF_QUIZZES;
        double percentage = (average/MAX_QUIZ_POINTS)*100;
        return percentage;
        
        
    }

    /**
     * calculating exam average point
     * @return
     */
    public double getExamAverage() {
        double total = 0;
        for (int i = 0; i < NUMBER_OF_EXAMS; i++) {
            total = total + examGrades.get(i);
        }
        double average = total /NUMBER_OF_EXAMS ;
        double percentage = (average/MAX_EXAM_POINTS)*100;
        return percentage;
        
    }

    /**
     * calculating course average point
     * @return
     */
    public double getCourseAverage() {
        double courseAverage = ((this.getLabAverage()*LAB_WEIGHT)
                +(this.getProjectAverage()*PROJECT_WEIGHT)
                +(this.getQuizAverage()*QUIZ_WEIGHT)
                +(this.getExamAverage()*EXAM_WEIGHT))
                /((LAB_WEIGHT+PROJECT_WEIGHT+QUIZ_WEIGHT+EXAM_WEIGHT)*100)*100;
        return courseAverage;
    }
}
