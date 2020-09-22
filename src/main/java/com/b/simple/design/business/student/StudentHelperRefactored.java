package com.b.simple.design.business.student;


public class StudentHelperRefactored {

	//COMMENTS ONLY TO EXPLAIN - IDEALLY THIS AND THE REST OF THE COMMENTS
	//CAN BE DELETED WITHOUT AFFECTING CLARITY.
	
	/*
	 Discuss the Problems With this solution
	 
	 The solution looks very simple. But, think what's involved in changing lower limit from 51 to 61. Will a new developer be able to make the change? 
	 Very difficult condition to understand. Looking at just the code, it is difficult to explain the business logic. 
	 What are 51, 80 and 90?
	 Is it good to use a conditional operator for a complex expression? 
	 Duplication.marks>51 condition is repeated twice.	 
	 */
	
	/*
	 * Most important thing to be able to  write clear code is to think on the same lines as the business requirement and the business concepts. 
	 * 
	 * The business concepts involved in the above example are lower limit and upper limit. All that we did in the solution is tried to create 
	 * variables for the business concept. If the logic is more complex we can think of creating a method to get the upper limit.
	 * 
	 * upperLimit = getUpperLimitForGradeB(isMaths);
	 * 
	 * 
	 */
	private static final int LOWER_LIMIT_GRADEB = 51;
	private static final int UPPER_LIMIT_GRADEB = 80;
	private static final int EXTRA_LIMIT_MATHS = 10;
	
	public boolean isGradeB(int marks, boolean isMaths) {
		
		int lowerLimit = LOWER_LIMIT_GRADEB;
		int upperLimit = isMaths? UPPER_LIMIT_GRADEB + EXTRA_LIMIT_MATHS : UPPER_LIMIT_GRADEB;
		
		return marks>=lowerLimit && marks<=upperLimit; 
	}

	
	/*
	 Discuss the Problems With this solution.
	 
	 What if any of the limits are changed? Changes in multiple locations.
	 What happens if the getGrade1 function is called with inputs mark = 94 and isMaths = true. isBGrade needs to be changed to fix this. mark < 90 should be removed.
	 Logic for lowerLimit is duplicated (conditionals used for lowerLimitForAGrade,lowerLimitGradeB)
	 What are 55, 50, 95 and 90?
	 Is there a relationship between 55 and 50 (55 in the current context is 50 + additional marks needed for maths)?
	 What are "A", "B" & "C"? Can we use Enums For Grade?	 
	 
	 */
	
	/*
	 * Ask Students to try and write code to improve the solution.
	 */
	
	   /*
     * The focus is again to express business concepts
     * 
     * There is an extra limit for maths across limits for all grades. So, we pulled it out as a seperate concept expressed using variable. Created an Enum for Grade to express it more clearly.
     * 
     */

	public enum Grade {
		A, B, C
	} /* Can be made a separate class */

	private static final int MATHS_HIGHER_REQUIREMENT = 5;
	private static final int GRADE_A_LOWER_LIMIT = 91;
	private static final int GRADE_B_LOWER_LIMIT = 51;

	public Grade getGrade(int marks, boolean isMaths) {

		int extraRequirementOverLimit = isMaths ? MATHS_HIGHER_REQUIREMENT : 0;

		if (marks >= GRADE_A_LOWER_LIMIT + extraRequirementOverLimit)
			return Grade.A;

		if (marks >= GRADE_B_LOWER_LIMIT + extraRequirementOverLimit)
			return Grade.B;

		return Grade.C;
	}


    /* PROBLEM 3 SOLUTION */    
    public String willQualifyForQuiz(int marks1, int marks2, boolean isMaths) {
        if (isNotGoodAtSubject(marks1, isMaths)
                || isNotGoodAtSubject(marks2, isMaths)) return "NO";
        if (isVeryGoodAtSubject(marks1, isMaths)
                || isVeryGoodAtSubject(marks2, isMaths)) return "YES";
        return "MAYBE";
    }

    private boolean isNotGoodAtSubject(int marks, boolean isMaths) {
        return isMaths ? marks <= 25 : marks <= 20;
    }

    private boolean isVeryGoodAtSubject(int marks, boolean isMaths) {
        return isMaths ? marks >= 85 : marks >= 80;
    }

}
