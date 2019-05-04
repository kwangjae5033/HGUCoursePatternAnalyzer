package edu.handong.analysis.datamodel;

public class Course {
	private String courseName;

	// constructor
	public Course(String name) {
		courseName = name;
	}
    //getter
	public String getCourseName() {
		return courseName;
	}
	//setter 
	public void setCourseName(String courseName) {
		this.courseName = courseName; 
	}
}
