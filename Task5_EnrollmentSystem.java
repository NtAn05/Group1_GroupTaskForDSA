import java.util.*;

// Task 5  HashSet & HashMap: Course Enrollment System
// Author (Member 1): An
public class Task5_EnrollmentSystem {
    private HashMap<String, String> studentDirectory;
    private HashMap<String, HashSet<String>> courseEnrollments;


    public Task5_EnrollmentSystem() {
        studentDirectory = new HashMap<>();
        courseEnrollments = new HashMap<>();
    }

    public void registerStudent(String id, String name) {
        // TODO: implement
    }

    public void createCourse(String courseCode) {
        // TODO: implement
    }

    public boolean enroll(String courseCode, String studentId) {
        courseCode = courseCode.trim().toUpperCase();
    studentId = studentId.trim().toUpperCase();
    if (!courseEnrollments.containsKey(courseCode)) {
        return false;
    }
    if (!studentDirectory.containsKey(studentId)) {
        return false;
    }
    HashSet<String> students = courseEnrollments.get(courseCode);
    if (students.contains(studentId)) {
        return false;
    }
    students.add(studentId);
    return true;
    }

    public boolean drop(String courseCode, String studentId) {
        courseCode = courseCode.trim().toUpperCase();
    studentId = studentId.trim().toUpperCase();
    if (!courseEnrollments.containsKey(courseCode)) {
        return false;
    }
    HashSet<String> students = courseEnrollments.get(courseCode);
    if (!students.contains(studentId)) {
        return false;
    }
    students.remove(studentId);
    return true;
}


    public void listStudentsInCourse(String courseCode) {
        // TODO: implement
    }

    public void listCoursesOfStudent(String studentId) {
        // TODO: implement
    }

    private static String readNonEmpty(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.print("Input cannot be empty. Try again: ");
        }
    }

    public static void main(String[] args) 
    {
        Task5_EnrollmentSystem system = new Task5_EnrollmentSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Register student");
            System.out.println("2. Create course");
            System.out.println("3. Enroll student");
            System.out.println("4. Drop student");
            System.out.println("5. List students in course");
            System.out.println("6. Find courses of student");
            System.out.println("7. Largest enrollment");
            System.out.println("0. Exit");

            System.out.print("Choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("Student ID: ");
                    String id = sc.nextLine();

                    System.out.print("Student Name: ");
                    String name = sc.nextLine();

                    system.registerStudent(id, name);
                    break;

                case 2:
                    System.out.print("Course Code: ");
                    String course = sc.nextLine();

                    system.createCourse(course);
                    break;

                case 3:
                    System.out.print("Course Code: ");
                    course = sc.nextLine();

                    System.out.print("Student ID: ");
                    id = sc.nextLine();

                    system.enroll(course, id);
                    break;

                case 4:
                    System.out.print("Course Code: ");
                    course = sc.nextLine();

                    System.out.print("Student ID: ");
                    id = sc.nextLine();

                    system.drop(course, id);
                    break;

                case 5:
                    System.out.print("Course Code: ");
                    course = sc.nextLine();

                    system.listStudentsInCourse(course);
                    break;

                case 6:
                    System.out.print("Student ID: ");
                    id = sc.nextLine();

                    system.listCoursesOfStudent(id);
                    break;

             /*    case 7:
                    system.largestEnrollmentCourse();
                    break;*/

                case 0:
                    System.out.println("Exit");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}

