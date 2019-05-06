package edu.handong.analysis;

import edu.handong.analysis.datamodel.*;

public class HGUCoursePatternAnalyzer {
	
	private String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private Student[] students;
	private Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	    
		//getting students name only from the "lines"
		students = initiateStudentArrayFromLines(lines);
		
		//print out total number of students and their names by calling getter 
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		//getting course name only from the "lines" 
		courses = initiateCourseArrayFromLines(lines);
		
		//print out total number of students and their names by calling getter 
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		// TODO: implement this method
		//extract students' names from the string array "lines"
		String[] stringOfNames = new String[lines.length];
		int i=0;
		for(String name: lines)
			stringOfNames[i++]= name.split(",")[1].trim();
		//instantiate a Student class array 
		//to transfer students' name from String to Student
		Student[] studentNameWithDuplicate = new Student[lines.length];
		i=0;
		for(String name: stringOfNames)
			studentNameWithDuplicate[i++] = new Student(name); 
		//delete duplicates
		for(Student student: studentNameWithDuplicate) {
			if(studentExist(studentNameWithDuplicate, student)) {
				student.setName("");
			}
		}
		//get the number of students without duplicates
		int count=0;
		for(Student student: studentNameWithDuplicate) 
			if(!(student.getName().equals(""))) count++;
		//instantiate new Stduent class array to store student names
		//without duplicates 
		Student[] studentNameNoDuplicate = new Student[count];
		int k=0;
		int clock=0; 
		for(int j=0; j<count; j++) 
			for(k=clock; k<lines.length; k++) {
				clock++;
				if(!(studentNameWithDuplicate[k].getName().equals(""))){
					studentNameNoDuplicate[j] = new Student(studentNameWithDuplicate[k].getName());
					break;
				}
			}	
		
		return studentNameNoDuplicate; 
	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		// TODO: implement this method
		int numberOfDuplicate = 0; 
		for (int i=0; i<students.length; i++)
			if (student.getName().equals(students[i].getName())) 
				numberOfDuplicate++;
		if (numberOfDuplicate > 1) return true; 
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		// TODO: implement this method
		//extract course names from string array "lines" 
		String[] stringOfNames = new String[lines.length];
		int i=0;
		for(String name: lines)
			stringOfNames[i++]= name.split(",")[2].trim();
		//transfer course names from String to Student 
		Course[] courseNameWithDuplicate = new Course[lines.length];
		i=0;
		for(String name: stringOfNames)
			courseNameWithDuplicate[i++] = new Course(name); 
		//delete the duplicates
		for(Course course: courseNameWithDuplicate) {
			if(courseExist(courseNameWithDuplicate, course)) {
				course.setCourseName("");
			}
		}
		//get the number of students without duplicates
		int count=0;
		for(Course course: courseNameWithDuplicate) 
			if(!(course.getCourseName().equals(""))) count++;
		//instantiate another Course array and fill in course names
		//without duplicates 
		Course[] courseNameNoDuplicate = new Course[count];
		int k=0;
		int clock=0; 
		for(int j=0; j<count; j++) 
			for(k=clock; k<lines.length; k++) {
				clock++;
				if(!(courseNameWithDuplicate[k].getCourseName().equals(""))){
					courseNameNoDuplicate[j] = new Course(courseNameWithDuplicate[k].getCourseName());
					break;
				}
			}	
		
		return courseNameNoDuplicate; 
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		// TODO: implement this method
		int numberOfDuplicate = 0; 
		for (int i=0; i<courses.length; i++)
			if (course.getCourseName().equals(courses[i].getCourseName())) 
				numberOfDuplicate++;
		if (numberOfDuplicate > 1) return true; 
		return false;
	}

}
