# Task 5 - Course Enrollment System

## 1. Project Information

Course: Data Structures & Algorithms  
Task: Task 5 - HashSet & HashMap: Course Enrollment System  
Language: Java 17+  
Interface: Console Application  

## 2. Group Members and Responsibilities

| Member | Responsibility |
|---|---|
| Member 1 - An | Build base class structure, declare studentDirectory and courseEnrollments, implement registerStudent and createCourse |
| Member 2 - Son | Implement enroll and drop logic |
| Member 3 - Long | Implement validation and input normalization helper methods |
| Member 4 - Dai | Implement query and sorting methods: listStudentsInCourse and listCoursesOfStudent |
| Member 5 - Linh | Build console UI, menu loop, Scanner and switch-case |
| Member 6 - Doan | Merge code, add initMockData, run test cases, prepare README and test output |

## 3. Data Structures Used

The program uses:

1. HashMap<String, String> studentDirectory

- Key: student ID
- Value: student name

2. HashMap<String, HashSet<String>> courseEnrollments

- Key: course code
- Value: set of student IDs

HashSet is used to prevent duplicate enrollment of the same student in the same course.

## 4. Features

The console menu supports:

1. Register student
2. Create course
3. Enroll student
4. Drop student
5. List students in course
6. Find courses of student
0. Exit

## 5. Mock Data

The method initMockData() automatically loads sample data when the program starts.

It includes:

- 10 students: ST001 to ST010
- 3 courses: DSA201, JAVA101, DBI202

This satisfies the assignment constraint requiring at least 3 courses and 10 students in the demo.

## 6. How to Compile and Run

Open terminal in the folder containing Task5_EnrollmentSystem.java.

Compile:

    javac Task5_EnrollmentSystem.java

Run:

    java Task5_EnrollmentSystem

## 7. Test Cases

The test output is stored in:

    test-output.txt

### Test Case 1: List students in course

Input:

    5
    DSA201
    0

Expected key output:

    Course DSA201: An, Bao, Chi, Dung

### Test Case 2: Enroll same student twice

Input:

    3
    DSA201
    ST002
    0

Expected key output:

    Student ST002 already enrolled in DSA201

### Test Case 3: Drop student not enrolled in course

Input:

    4
    DSA201
    ST010
    0

Expected key output:

    Student ST010 is not enrolled in DSA201

### Test Case 4: Find courses of student

Input:

    6
    ST002
    0

Expected key output:

    Courses of ST002: [DSA201, JAVA101]

## 8. Submission Files

The submitted files are:

- Task5_EnrollmentSystem.java
- README.md
- test-output.txt
- .gitignore
