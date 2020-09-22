package com.b.simple.design.business.student;

public class StudentHelper {

	/* PROBLEM 1 */	
	/*
	* You get a grade B if marks are between 51 and 80 (both inclusive). Except for Maths where the upper limit is increased by 10.
	*/
	public boolean isGradeB(int marks, boolean isMaths) {
		return isMaths ? marks>=51 && marks<=90 : marks>=51 && marks<=80; 
	}

	/* PROBLEM 2 */
	/*
	You are awarded a grade based on your marks.
	Grade A = 91 to 100, Grade B = 51 to 90, Otherwise Grade C
	Except for Maths where marks to get a Grade are 5 higher than required for other subjects.
	*/

	public String getGrade(int mark, boolean isMaths) {
		String grade = "C";
		
		if (isGradeA(mark, isMaths))
			grade = "A";
		else if (isBGrade(mark, isMaths)) {
			grade = "B";
		}
		return grade;
	}

	private boolean isGradeA(int mark, boolean isMaths) {
		int lowerLimitForAGrade = isMaths ? 95
				: 90;
		return mark > lowerLimitForAGrade;
	}

	private boolean isBGrade(int mark, boolean isMaths) {
		int lowerLimitGradeB = isMaths ? 55
				: 50;
		return mark > lowerLimitGradeB && mark < 90;
	}

    /*  PROBLEM 3
     * You and your Friend are planning to enter a Subject Quiz.
     * However, there is a marks requirement that you should attain to qualify.
     * 
     * Return value can be YES, NO or MAYBE.
     * 
     * YES If either of you are very good at the subject(has 80 or more marks)
     * However, there is an exception that if either of you is not good in the subject(20 or less marks), it is NO.
     * In all other conditions, return MAYBE.
     * 
     * However, the definition for good and not good are 5 marks higher if the subject is Mathematics.
     * 
     * marks1 - your marks
     * marks2 - your friends marks
    */
        
    public String willQualifyForQuiz(int marks1, int marks2, boolean isMaths) {
        if ((isMaths ? marks1 <= 25 : marks1 <= 20)
                || (isMaths ? marks2 <= 25 : marks2 <= 20)) return "NO";
        if ((isMaths ? marks1 >= 85 : marks1 >= 80)
                || (isMaths ? marks2 >= 85 : marks2 >= 80)) return "YES";
        return "MAYBE";
    }	

}
