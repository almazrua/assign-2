import java.util.*;

public class Student {
	  private String id; 
	  private String name;
	  
	  private ArrayList<Course> courses; // contains all courses the student is registered in 
	  
	  public String getName() { return name;  } 
	 
	  public String getId() { return id;  } 
	 
	  public Student(String id, String name) {
		  /* initialize name and id. Also initialize the ArrayList */
		  courses = new ArrayList<Course>();
		  this.id = id;
		  this.name = name;
	  } 
	 
	  public void registerFor(Course course)
	  {
		  if(courses.contains(course))
			  return;
		  
		  courses.add(course);
		  course.AddStudent(this);
	  }
	  public boolean isRegisteredInCourse(Course course)
	  {
		  return course.CheckIfDepartment(this);
	  }
	  public String toString() {
		  /* return a string representation of a student using the following format:      
		   * // 100234546 John McDonald      
		   * // Registered courses: ELEE 2110, ELEE 2790, SOFE 2710, SOFE 2800, SOFE 2850  */ 
		  String student = name + " " + id;
		  if(courses.isEmpty())
			  return student;
		  return student;
	  }
}
