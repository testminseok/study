public class ManageStudent {
	public static void main(String[] args) {
		
		ManageStudent manage = new ManageStudent();
		Student[] students = null;
		
		students = manage.addStudent();
		
		manage.printStudents(students);
	}
	
	public Student[] addStudent() {
		
		Student[] students = new Student[3];
		
		students[0] = new Student("Lim");
		students[1] = new Student("Mim");
		students[2] = new Student("Sook", "Seoul", "010XXXXXXXX", "ask@godOfjava.com");
		
		return students;
	}
	
	public void printStudents(Student[] students) {
		
		for (Student student : students) {
			System.out.println(student);
		}
	}
}