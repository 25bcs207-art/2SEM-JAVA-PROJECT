# Scholarship Eligibility Verification and Student Shortlisting System

## 1. Project Title
Scholarship Eligibility Verification and Student Shortlisting System

## 2. Abstract
This project is a console-based Java application designed to assist educational institutions in verifying scholarship eligibility and shortlisting students. The system collects student information, checks eligibility conditions, calculates a merit score, and produces a ranked shortlist.

The application demonstrates Java fundamentals such as classes, objects, collections, methods, conditional statements, loops, sorting, input validation, and comparator-based ranking.

## 3. Objectives
- Register student scholarship applications.
- Verify students against predefined eligibility rules.
- Calculate a merit score for eligible students.
- Shortlist students who satisfy the merit threshold.
- Rank shortlisted students by merit score.
- Reduce manual effort in preliminary scholarship screening.

## 4. Eligibility Rules Used
The sample implementation uses the following rules:

1. Student age must be between 17 and 30 years.
2. Annual family income must not exceed Rs. 500,000.
3. Academic percentage must be at least 60%.
4. Required documents must be verified.

These values are examples and can be changed according to the actual scholarship policy.

## 5. Merit Score
The base score is the academic percentage.

Additional points:
- First-generation student: +5
- Sports achievement: +3
- Disability category: +4
- Family income <= Rs. 100,000: +10
- Family income <= Rs. 200,000: +7
- Family income <= Rs. 300,000: +4

Students with a merit score of 70 or above are included in the sample shortlist.

## 6. Main Features
### Student Registration
The administrator can enter:
- Student name
- Age
- Family income
- Academic percentage
- First-generation status
- Sports achievement
- Disability status
- Document verification status

### Eligibility Verification
The system reports whether each student is eligible and provides a reason when the student is not eligible.

### Shortlisting
Eligible students with a merit score of at least 70 are shortlisted.

### Ranking
Shortlisted students are sorted from highest to lowest merit score. When two students have the same score, lower family income gets priority.

## 7. Technologies
- Programming Language: Java
- User Interface: Console
- Data Storage: In-memory ArrayList
- Java Concepts: OOP, Collections, Methods, Conditional Logic, Exception Handling, Comparator

## 8. System Flow
1. Start application.
2. Register or load student records.
3. Verify student information.
4. Apply eligibility rules.
5. Calculate merit score for eligible students.
6. Apply shortlist threshold.
7. Sort shortlisted students.
8. Display final ranking.
9. Exit.

## 9. Class Design
### Student
Stores student details and provides:
- `isEligible()`
- `eligibilityReason()`
- `meritScore()`
- `toString()`

### ScholarshipSystem
Controls:
- Menu
- Student registration
- Eligibility verification
- Shortlisting
- Ranking
- Input validation
- Sample data

## 10. How to Run

### Requirements
Install Java JDK 17 or later.

### Compile
Open a terminal in the folder containing the Java file and run:

    javac ScholarshipSystem.java

### Run

    java ScholarshipSystem

## 11. Sample Test Data
The application includes sample students automatically:

- Arun Kumar — income Rs. 150,000, academic percentage 82%
- Priya S — income Rs. 420,000, academic percentage 91%
- Rahul M — income Rs. 600,000, academic percentage 88%
- Divya R — income Rs. 90,000, academic percentage 68%

The sample demonstrates both eligible and ineligible cases.

## 12. Expected Result
The system should:
- Mark Arun Kumar as eligible.
- Mark Priya S as eligible.
- Mark Rahul M as ineligible because family income exceeds the limit.
- Mark Divya R as eligible.
- Generate a shortlist based on the merit-score threshold.

## 13. Advantages
- Simple and easy to operate.
- Reduces manual eligibility checking.
- Provides consistent preliminary screening.
- Produces a ranked shortlist.
- Easy to extend with a database or GUI.

## 14. Limitations
- Data is stored only while the program is running.
- Eligibility rules are hard-coded.
- It is a console application.
- It is intended for preliminary screening and does not replace official scholarship verification.

## 15. Future Enhancements
- Add MySQL or PostgreSQL database storage.
- Add Java Swing or JavaFX GUI.
- Add administrator login.
- Upload and verify supporting documents.
- Generate PDF/Excel reports.
- Add multiple scholarship schemes.
- Add configurable eligibility rules.
- Add audit logs.
- Add email/SMS notification.
- Add a web-based frontend.

## 16. Conclusion
The Scholarship Eligibility Verification and Student Shortlisting System provides a basic automated approach to scholarship screening. It verifies predefined eligibility conditions, calculates merit scores, and ranks qualified students. The project can serve as a foundation for a larger database-driven scholarship management system.

## 17. Disclaimer
The eligibility limits and scoring values in this educational project are sample rules only. Real scholarship decisions should use the official criteria, document verification procedures, and applicable institutional policies.
