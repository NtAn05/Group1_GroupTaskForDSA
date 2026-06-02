import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Task5_EnrollmentSystem {
    private HashMap<String, String> studentDirectory;
    private HashMap<String, HashSet<String>> courseEnrollments;

    public Task5_EnrollmentSystem() {
        studentDirectory = new HashMap<>();
        courseEnrollments = new HashMap<>();
        initMockData();
    }

    public void registerStudent(String id, String name) {
        id = normalize(id);
        name = name.trim();

        if (id.isEmpty() || name.isEmpty()) {
            System.out.println("Invalid student information");
            return;
        }

        if (studentDirectory.containsKey(id)) {
            System.out.println("Student " + id + " already exists");
            return;
        }

        studentDirectory.put(id, name);
        System.out.println("Registered student " + id + " -> " + name);
    }

    public void createCourse(String courseCode) {
        courseCode = normalize(courseCode);

        if (courseCode.isEmpty()) {
            System.out.println("Invalid course code");
            return;
        }

        if (courseEnrollments.containsKey(courseCode)) {
            System.out.println("Course " + courseCode + " already exists");
            return;
        }

        courseEnrollments.put(courseCode, new HashSet<>());
        System.out.println("Created course " + courseCode);
    }

    public boolean enroll(String courseCode, String studentId) {
        courseCode = normalize(courseCode);
        studentId = normalize(studentId);

        if (!courseEnrollments.containsKey(courseCode)) {
            System.out.println("Course " + courseCode + " does not exist");
            return false;
        }

        if (!studentDirectory.containsKey(studentId)) {
            System.out.println("Student " + studentId + " does not exist");
            return false;
        }

        HashSet<String> students = courseEnrollments.get(courseCode);

        if (students.contains(studentId)) {
            System.out.println("Student " + studentId + " already enrolled in " + courseCode);
            return false;
        }

        students.add(studentId);
        System.out.println("Enrolled " + studentId + " into " + courseCode);
        return true;
    }

    public boolean drop(String courseCode, String studentId) {
        courseCode = normalize(courseCode);
        studentId = normalize(studentId);

        if (!courseEnrollments.containsKey(courseCode)) {
            System.out.println("Course " + courseCode + " does not exist");
            return false;
        }

        if (!studentDirectory.containsKey(studentId)) {
            System.out.println("Student " + studentId + " does not exist");
            return false;
        }

        HashSet<String> students = courseEnrollments.get(courseCode);

        if (!students.contains(studentId)) {
            System.out.println("Student " + studentId + " is not enrolled in " + courseCode);
            return false;
        }

        students.remove(studentId);
        System.out.println("Dropped " + studentId + " from " + courseCode);
        return true;
    }

    public void listStudentsInCourse(String courseCode) {
        courseCode = normalize(courseCode);

        if (!courseEnrollments.containsKey(courseCode)) {
            System.out.println("Course " + courseCode + " does not exist");
            return;
        }

        HashSet<String> studentIds = courseEnrollments.get(courseCode);
        ArrayList<String> names = new ArrayList<>();

        for (String studentId : studentIds) {
            names.add(studentDirectory.get(studentId));
        }

        Collections.sort(names);

        System.out.println("Course " + courseCode + ": " + String.join(", ", names));
    }

    public void listCoursesOfStudent(String studentId) {
        studentId = normalize(studentId);

        if (!studentDirectory.containsKey(studentId)) {
            System.out.println("Student " + studentId + " does not exist");
            return;
        }

        ArrayList<String> courses = new ArrayList<>();

        for (String courseCode : courseEnrollments.keySet()) {
            if (courseEnrollments.get(courseCode).contains(studentId)) {
                courses.add(courseCode);
            }
        }

        Collections.sort(courses);
        System.out.println("Courses of " + studentId + ": " + courses);
    }

    private String normalize(String input) {
        if (input == null) {
            return "";
        }
        return input.trim().toUpperCase();
    }

    private void initMockData() {
        studentDirectory.put("ST001", "An");
        studentDirectory.put("ST002", "Bao");
        studentDirectory.put("ST003", "Chi");
        studentDirectory.put("ST004", "Dung");
        studentDirectory.put("ST005", "Ha");
        studentDirectory.put("ST006", "Linh");
        studentDirectory.put("ST007", "Minh");
        studentDirectory.put("ST008", "Nam");
        studentDirectory.put("ST009", "Phong");
        studentDirectory.put("ST010", "Quyen");

        courseEnrollments.put("DSA201", new HashSet<>());
        courseEnrollments.put("JAVA101", new HashSet<>());
        courseEnrollments.put("DBI202", new HashSet<>());

        courseEnrollments.get("DSA201").add("ST001");
        courseEnrollments.get("DSA201").add("ST002");
        courseEnrollments.get("DSA201").add("ST003");
        courseEnrollments.get("DSA201").add("ST004");

        courseEnrollments.get("JAVA101").add("ST002");
        courseEnrollments.get("JAVA101").add("ST005");
        courseEnrollments.get("JAVA101").add("ST006");

        courseEnrollments.get("DBI202").add("ST007");
        courseEnrollments.get("DBI202").add("ST008");
        courseEnrollments.get("DBI202").add("ST009");
        courseEnrollments.get("DBI202").add("ST010");
    }

    public static void main(String[] args) {
        Task5_EnrollmentSystem system = new Task5_EnrollmentSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Register student");
            System.out.println("2. Create course");
            System.out.println("3. Enroll student");
            System.out.println("4. Drop student");
            System.out.println("5. List students in course");
            System.out.println("6. Find courses of student");
            System.out.println("0. Exit");
            System.out.println();
            System.out.print("Choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    system.registerStudent(id, name);
                    break;

                case "2":
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.nextLine();
                    system.createCourse(courseCode);
                    break;

                case "3":
                    System.out.print("Enter course code: ");
                    String enrollCourse = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String enrollStudent = scanner.nextLine();
                    system.enroll(enrollCourse, enrollStudent);
                    break;

                case "4":
                    System.out.print("Enter course code: ");
                    String dropCourse = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String dropStudent = scanner.nextLine();
                    system.drop(dropCourse, dropStudent);
                    break;

                case "5":
                    System.out.print("Enter course code: ");
                    String listCourse = scanner.nextLine();
                    system.listStudentsInCourse(listCourse);
                    break;

                case "6":
                    System.out.print("Enter student ID: ");
                    String searchStudent = scanner.nextLine();
                    system.listCoursesOfStudent(searchStudent);
                    break;

                case "0":
                    System.out.println("Exit");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
