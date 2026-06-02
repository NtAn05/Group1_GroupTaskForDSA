import java.util.*;

Long-ValidationAndNormalization
// Task 5 — HashSet & HashMap: Course Enrollment System
// Author (Member 3): Long
// Task 5  HashSet & HashMap: Course Enrollment System
// Author (Member 1): An
public class Task5_EnrollmentSystem {
    private HashMap<String, String> studentDirectory;
    private HashMap<String, HashSet<String>> courseEnrollments;


    public Task5_EnrollmentSystem() {
        studentDirectory = new HashMap<>();
        courseEnrollments = new HashMap<>();
    }
    //Helper function to validation and Normalization
    //Chuẩn hóa dữ liệu đầu vào
    private String santitizeInput(String input, boolean isCode) {
        if (input ==null) return "";
        String cleaned = input.trim();
        return isCode ? cleaned.toUpperCase() : cleaned;
    }

    //Kiểm tra Student đã tồn tại hay chưa
    private boolean isStudentExists(String studentId) {
        return studentDirectory.containsKey(studentId);
    }

    //Kiểm tra Course đã tồn tại hay chưa
    private boolean isCourseExists(String courseId) {
        return courseEnrollments.containsKey(courseId);
    }

    //Kiểm tra trùng lặp đăng kí (học sinh đã ở trong lớp hay chưa)
    private boolean isAlreadyEnrolled(String courseCode, String studentId) {
        HashSet<String> students = courseEnrollments.get(courseCode);
        return students != null && students.contains(studentId);
    }

    //Hàm tổng hợp kiểm tra nhanh điều kiện tiên quyết cho enroll và Drop
    private boolean validateQueryConditions(String courseCode, String studentId) {
        if(isCourseExists(courseCode)) {
            System.out.println("Validation Error: Course " + courseCode + " does not exists");
            return false;
        }
        if(isStudentExists(studentId)) {
            System.out.println("Validation Error: Student " + studentId + " does not exists");
            return false;
        }
        return true;
    }

    public void registerStudent(String id, String name) {
        if (id == null || name == null) return;
        id = id.trim();
        name = name.trim();
        if (id.isEmpty() || name.isEmpty()) return;

        studentDirectory.put(id, name);
        System.out.println("Registered student " + id + " -> " + name);
    }

    public void createCourse(String courseCode) {
        if (courseCode == null) return;
        courseCode = courseCode.trim();
        if (courseCode.isEmpty()) return;

        courseEnrollments.putIfAbsent(courseCode, new HashSet<>());
        System.out.println("Created course " + courseCode);
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

