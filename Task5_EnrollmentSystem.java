import java.util.*;

// Task 5 — HashSet & HashMap: Course Enrollment System
// Author (Member 3): Long
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
        // TODO: implement
    }

    public void createCourse(String courseCode) {
        // TODO: implement
    }

    public boolean enroll(String courseCode, String studentId) {
        // TODO: implement
        return false;
    }

    public boolean drop(String courseCode, String studentId) {
        // TODO: implement
        return false;
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

    public static void main(String[] args) {
        Task5_EnrollmentSystem system = new Task5_EnrollmentSystem();
        Scanner sc = new Scanner(System.in);

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
            System.out.print("Choice: ");

            String choiceStr = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(choiceStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a number.");
                continue;
            }

            if (choice == 0) {
                System.out.println("Exit");
                break;
            }

            switch (choice) {
                case 1: {
                    System.out.print("Enter student ID: ");
                    String id = readNonEmpty(sc);
                    System.out.print("Enter student name: ");
                    String name = readNonEmpty(sc);
                    system.registerStudent(id, name);
                    break;
                }
                case 2: {
                    System.out.print("Enter course code: ");
                    String courseCode = readNonEmpty(sc);
                    system.createCourse(courseCode);
                    break;
                }
                case 3: {
                    System.out.print("Enter course code: ");
                    String courseCode = readNonEmpty(sc);
                    System.out.print("Enter student ID: ");
                    String studentId = readNonEmpty(sc);
                    boolean ok = system.enroll(courseCode, studentId);
                    if (ok) {
                        System.out.println("Enrolled " + studentId + " into " + courseCode);
                    } else {
                        System.out.println("Enroll failed");
                    }
                    break;
                }
                case 4: {
                    System.out.print("Enter course code: ");
                    String courseCode = readNonEmpty(sc);
                    System.out.print("Enter student ID: ");
                    String studentId = readNonEmpty(sc);
                    boolean ok = system.drop(courseCode, studentId);
                    if (ok) {
                        System.out.println("Dropped " + studentId + " from " + courseCode);
                    } else {
                        System.out.println("Drop failed");
                    }
                    break;
                }
                case 5: {
                    System.out.print("Enter course code: ");
                    String courseCode = readNonEmpty(sc);
                    system.listStudentsInCourse(courseCode);
                    break;
                }
                case 6: {
                    System.out.print("Enter student ID: ");
                    String studentId = readNonEmpty(sc);
                    system.listCoursesOfStudent(studentId);
                    break;
                }
                default:
                    System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}

