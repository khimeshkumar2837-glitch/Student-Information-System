import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("ID    Name            Age   Grade      Contact");
        System.out.println("------------------------------------------------------");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                return student;
            }
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        Student student = searchStudent(id);

        if (student != null) {
            students.remove(student);
            return true;
        }
        return false;
    }
}
