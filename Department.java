import java.util.*;

public class Department {
	 private String name; // the name of school “Dept of Computing and Info Science”    
	 private String id; // short name for courses “SOFE”, “ELEE”, “STAT”, etc
	 ArrayList<Course> courseList; // all courses offered by the department    
	 ArrayList<Course> registerList; // all students taking courses in the department. 
	 
	 public String getName() 	{ return this.name; } 
	 
	 public String getId() 		{ return this.id; } 
	 
	 public Department(String name, String id) {
		 /* also initialize the arraylists  */ 
		 this.name = name;
		 this.id = id;
		 courseList = new ArrayList<Course>();
		 registerList = new ArrayList<Course>();
	 } 
	 
	 public void offerCourse(Course course)
	 {
		 if(!courseList.contains(course))		 
			 courseList.add(course);
	 }
	 
	 public void printStudentsRegisteredInCourse(int code)
	 {
		 ArrayList<Student> printList = this.studentsRegisteredInCourse(code);
		 if(printList == null)
			 return;
		 
		 for(int i = 0; i < printList.size(); ++i)
		 {
			 System.out.println(printList.get(i).getId() + " " + printList.get(i).getName());
		 }
	 }
	 
	 public void printCoursesOffered()
	 {
		 if(courseList.isEmpty())
			 return;
		 System.out.print("[");
		 for(int i = 0; i < courseList.size(); ++i)
	     {
			System.out.print(courseList.get(i).toString());
			if(i == courseList.size() - 1)
				System.out.print("]");
			else
				System.out.println();
			
	     }
	 }
	 
	 public Course largestCourse()
	 {
		 if(courseList.size() == 0)
			 return null;
		 
		 int index = 0;
		 int max = 0;
		 for(int i = 0; i < courseList.size(); ++i)
		 {
			 if(max < courseList.get(i).getNumberOfStudents())
			 {
				 max = courseList.get(i).getNumberOfStudents();
				 index = i;
			 }
		 }
		 
		 return courseList.get(index);
	 }
	 
	 public void AddCourse(Course c)
	 {
		 if(courseList.contains(c))
			 if(!registerList.contains(c))
				 registerList.add(c);
	 }
	 
	 public ArrayList<Student> studentsRegisteredInCourse(int code)
	 {
		 for(int i = 0; i < courseList.size(); ++i)
		 {
			 if(courseList.get(i).getNumber() == code)
				 return courseList.get(i).getStudents();
		 }
		 return null;
	 }
	 
	 public void printStudentsByName()
	 {
		 if(courseList.isEmpty())
		 {
			 System.out.println("The department \"" + name + "\" is empty" );
			 return;
		 }
		 
		 ArrayList<Student> students = new ArrayList<Student>();
		 
		 for(int i = 0; i < registerList.size(); ++i)
		 {
			 if(registerList.get(i).getNumberOfStudents() == 0)
				 continue;
			 
			 ArrayList<Student> temp_list = registerList.get(i).getStudents();
			 for(int j = 0; j < temp_list.size(); ++j)
				 if(!students.contains(temp_list.get(j)))
					 students.add(temp_list.get(j));
		 }
		 if(students.size() > 0)
			 System.out.println(id + " students:");
		 for(int i = 0; i < students.size(); ++i)
			 System.out.print(students.get(i) + "\n");
	 }
	 public boolean isStudentRegistered(Student student)
	 {
		 for(int i = 0; i < registerList.size(); ++i)
		 {
			 if(registerList.get(i).getStudents().contains(student))
				 return true;
		 }
		 return false;
	 }
	 
	 public String toString() {       
		 /* returns a string representation of department name, number        
	   	// of courses offered and number of students registered in the       
	    * // department. Use the format:       // ECSE: 53 courses, 460 students */  
		 int sum_students = 0;
		 for(int i = 0; i < registerList.size(); ++i)
		 {
			 sum_students += registerList.get(i).getNumberOfStudents();
		 }
		 String return_string = id + ": " + courseList.size() + " courses, " + sum_students + " students\n";
		 return return_string;
	 }
}
