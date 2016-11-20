public class Grade {

    //declare the variables
    private String name;
    private double totalScore;
    private int gradeCount;
    private double score;

    //construct Grade with student's name
    public Grade (String name){
        this.name = name;
        score =0;
        totalScore = 0;
    }

    public String getName(){
        return this.name;
    }

    //method to calcualte GPA
    public double getGPA(){
        return this.totalScore / this.gradeCount;
    }
    

    public void setTotalScore(double totalScore)
    {
        this.totalScore = totalScore;
    }
    //method to ctranslate grades to scores and calculate the total score
    public void ScoreConverter(String grade) {
        
       
        if (grade.equals("A")) {
            score = 4;
        } else if (grade.equals("A-")) {
            score = 3.7;
            System.out.println(score);
        } else if (grade.equals("B+")) {
            score = 3.3;
        } else if (grade.equals("B")) {
            score = 3;
        } else if (grade.equals("B-")) {
            score = 2.7;
        } else if (grade.equals("C+")) {
            score = 2.3;
        } else if (grade.equals("C")) {
            score = 2;
        } else if (grade.equals("C-")) {
            score = 1.7;
        } else if (grade.equals("D+")) {
            score = 1.3;
        } else if (grade.equals("D")) {
            score = 1;
        } else {
            score = 0;
        }
        
        totalScore = totalScore + score;
        gradeCount++;
        
    }
    public double getTotalScore()
    {
        return(totalScore);
    }
}

