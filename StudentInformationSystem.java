import java.util.Scanner;

public class StudentInformationSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;

        do {
            System.out.println("\n===== STUDENT INFORMATION SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    if (!ValidationUtils.isValidAge(age)) {
                        System.out.println("Invalid age!");
                        break;
                    }

                    System.out.print("Enter Grade (A-F): ");
                    String grade = scanner.nextLine();

                    if (!ValidationUtils.isValidGrade(grade)) {
                        System.out.println("Invalid grade!");
                        break;
                    }

                    System.out.print("Enter Contact: ");
                    String contact = scanner.nextLine();

                    Student student = new Student(id, name, age, grade, contact);
                    manager.addStudent(student);

                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();

                    Student found = manager.searchStudent(searchId);

                    if (found != null) {
                        System.out.println("Student Found:");
                        System.out.println(found);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();

                    if (manager.deleteStudent(deleteId)) {
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        scanner.close();
    }
}
