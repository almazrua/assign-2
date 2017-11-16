import java.util.*;

public class Course {
	 private Department dept;    
	 private String title; // title of the course (e.g. “Intro to programming”);    
	 private String code; // course code, e.g. SOFE, ELEE, MANE, etc.    
	 private int number; // course number, e.g. 1200, 2710, 2800, etc.    
	 ArrayList<Student> classList; // contains all students registered in this course 
	 
	 public String getDept() {  return dept.getId();  }
	 
	 public String getCode() {  return code;  } 
	 
	 public int getNumber() { return number; }
	
	 public ArrayList<Student> getStudents()
	 {
		 if(classList.isEmpty())
			 return null;
		 return classList;
	 }
	 
	 public int getNumberOfStudents()
	 {
		 return classList.size();
	 }
	 
	 public boolean CheckIfDepartment(Student s)
	 {
		 return dept.isStudentRegistered(s);
	 }
	 
	 public void AddStudent(Student s)
	 {
		if(!classList.contains(s))
		{
			classList.add(s);
		 	dept.AddCourse(this);
		}
	 }
	 
	 public Course(String code, int number, Department dept, String title){       
		 /* also initialize the classList; */
		 this.code = code;
