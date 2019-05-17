package edu.handong.analysis;

import edu.handong.analysis.datamodel.*;
import java.util.ArrayList;

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
	private ArrayList<Student> students;
	private ArrayList<Course> courses;
	
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
	private ArrayList<Student> initiateStudentArrayFromLines(String[] lines) {
		// TODO: implement this method
        ArrayList<Student> students = new ArrayList<Student>();
		
		for(String line:lines) {
			String studentName = line.split(",")[1].trim();
			Student newStudent = new Student(studentName);
			if(!studentExist(students,newStudent))
				students.add(newStudent);
		}
		
		return students;

	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students2
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(ArrayList<Student> students, Student student) {
		// TODO: implement this method
		for(Student aStudent:students) {
			if(aStudent != null && aStudent.getName().equals(student.getName()))
				return true;
		}

		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Course> initiateCourseArrayFromLines(String[] lines) {
		// TODO: implement this method
		ArrayList<Course> courses = new ArrayList<Course>();
		
		for(String line:lines) {
			String courseName = line.split(",")[2].trim();
			Course newCourse = new Course(courseName);
			if(!courseExist(courses,newCourse))
				courses.add(newCourse);
		}
		
		return courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses2
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(ArrayList<Course> courses, Course course) {
		
		// TODO: implement this method
		
		for(Course aCourse:courses) {
			if(aCourse != null && aCourse.getCourseName().equals(course.getCourseName()))
				return true;
		}

		return false;
	}

}
