/*
Activity 1.
Make a class Person, with instance variable name, age, and gender. Make a class Employee inherit
from Person, with extra data for salary, and hiring date. Make another class Student inherit from Person,
with data for program name, level (undergraduate/graduate), and program year. Supply required methods for
the superclass and the subclasses. Make a subclass Manager from Employee, with bonus salary, and
override the corresponding method(s). Supply appropriate toString methods for Person class. Then,
override this method in Employee and Manager classes, such that it concatenates “(Employee)” and
“(Manager)” to the end of the corresponding output. Override equals method for Person class by checking
the name and age of the corresponding objects.
*/
import java.util.ArrayList;

class Person {
	private String name;
	private int age;
	private String gender;

	public Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String toString() {
		return this.name + " " + this.age + " " + this.gender;
	}

	public boolean equals(Object person) {
		if(person instanceof Person) {
			Person p = (Person) person;
			return this.name.equals(p.name) && this.age == p.age;
		}
		else 
			return false;

	}
}

class Employee extends Person {
	private double salary;
	private String hiringDate;

	public Employee(String name, int age, String gender, double salary, String hiringDate) {
		super(name, age, gender);
		this.salary = salary;
		this.hiringDate = hiringDate;
	}

	public String toString() {
		return super.toString() + " Employee: " + salary + " " + hiringDate;
	}


}

class Student extends Person {
	private String programName;
	private String level;
	private int programYear;
	
	public Student(String name, int age, String gender, String programName, String level, int programYear) {
		super(name, age, gender);
		this.programName = programName;
		this.level = level;
		this.programYear = programYear;
	}

	public String toString() {
		return super.toString()+ " " + this.programName + " " + this.level + " " + this.programYear;
	}

}

class Manager extends Employee {
	private int bonusSalary;
	
	public Manager(String name, int age, String gender, double salary, String hiringDate, int bonusSalary) {
		super(name, age, gender, salary, hiringDate);
		this.bonusSalary = bonusSalary;
	}

	public String toString() {
		return super.toString() + " Manager " + this.bonusSalary;
	}
}


public class Activity1 {

	public static void main( String[] args ) {
		Person sandra = new Employee("Sandra", 21, "female", 100000.0, "2018/09/01");
		Person sandra2 = new Student("Sandra", 21, "female", "Engineering", "undergraduate", 4);
		System.out.println(sandra.toString());
		System.out.println(sandra.equals(sandra2));
		ArrayList<Person> arr = new ArrayList<Person>();
		arr.add(sandra);
		arr.add(sandra2);

		for(Person i : arr) {
			System.out.println(i.toString());
		}

	}


}