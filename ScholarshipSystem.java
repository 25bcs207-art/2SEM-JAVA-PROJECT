import java.util.*;

/**
 * Scholarship Eligibility Verification and Student Shortlisting System
 *
 * Console-based Java application for:
 * 1. Registering student details
 * 2. Verifying scholarship eligibility
 * 3. Calculating a merit score
 * 4. Shortlisting eligible students
 * 5. Displaying and sorting shortlisted students
 *
 * Compile: javac ScholarshipSystem.java
 * Run:     java ScholarshipSystem
 */
public class ScholarshipSystem {

    static class Student {
        int id;
        String name;
        int age;
        double familyIncome;
        double academicPercentage;
        boolean firstGeneration;
        boolean sportsAchievement;
        boolean disability;
        boolean documentsVerified;

        Student(int id, String name, int age, double familyIncome,
                double academicPercentage, boolean firstGeneration,
                boolean sportsAchievement, boolean disability,
                boolean documentsVerified) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.familyIncome = familyIncome;
            this.academicPercentage = academicPercentage;
            this.firstGeneration = firstGeneration;
            this.sportsAchievement = sportsAchievement;
            this.disability = disability;
            this.documentsVerified = documentsVerified;
        }

        double meritScore() {
            double score = academicPercentage;

            if (firstGeneration) score += 5;
            if (sportsAchievement) score += 3;
            if (disability) score += 4;

            // Lower-income students receive additional priority.
            if (familyIncome <= 100000) score += 10;
            else if (familyIncome <= 200000) score += 7;
            else if (familyIncome <= 300000) score += 4;

            return score;
        }

        boolean isEligible() {
            return age >= 17
                    && age <= 30
                    && familyIncome <= 500000
                    && academicPercentage >= 60
                    && documentsVerified;
        }

        String eligibilityReason() {
            if (age < 17 || age > 30) return "Age is outside the allowed range";
            if (familyIncome > 500000) return "Family income exceeds the limit";
            if (academicPercentage < 60) return "Academic percentage is below 60%";
            if (!documentsVerified) return "Required documents are not verified";
            return "Eligible";
        }

        @Override
        public String toString() {
            return String.format(
                    "ID: %d | Name: %s | Academic: %.2f%% | Income: Rs. %.2f | Score: %.2f",
                    id, name, academicPercentage, familyIncome, meritScore());
        }
    }

    static final Scanner scanner = new Scanner(System.in);
    static final List<Student> students = new ArrayList<>();
    static int nextId = 1;

    public static void main(String[] args) {
        seedSampleData();

        while (true) {
            System.out.println("\n==============================================");
            System.out.println(" SCHOLARSHIP ELIGIBILITY & SHORTLISTING SYSTEM");
            System.out.println("==============================================");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Verify Eligibility");
            System.out.println("4. Show Shortlisted Students");
            System.out.println("5. Sort Shortlist by Merit Score");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> displayAllStudents();
                case 3 -> verifyEligibility();
                case 4 -> displayShortlist();
                case 5 -> sortAndDisplayShortlist();
                case 6 -> {
                    System.out.println("Thank you for using the system.");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void addStudent() {
        System.out.println("\n--- Add Student ---");

        System.out.print("Student name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Age: ");
        int age = readInt();

        System.out.print("Annual family income (Rs.): ");
        double income = readDouble();

        System.out.print("Academic percentage: ");
        double percentage = readDouble();

        System.out.print("First-generation student? (Y/N): ");
        boolean firstGeneration = readYesNo();

        System.out.print("Sports achievement? (Y/N): ");
        boolean sportsAchievement = readYesNo();

        System.out.print("Disability category? (Y/N): ");
        boolean disability = readYesNo();

        System.out.print("Documents verified? (Y/N): ");
        boolean documentsVerified = readYesNo();

        Student student = new Student(
                nextId++, name, age, income, percentage,
                firstGeneration, sportsAchievement, disability,
                documentsVerified
        );

        students.add(student);
        System.out.println("Student added successfully. Student ID: " + student.id);
    }

    static void displayAllStudents() {
        System.out.println("\n--- All Students ---");

        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    static void verifyEligibility() {
        System.out.println("\n--- Eligibility Verification ---");

        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }

        for (Student student : students) {
            System.out.println(
                    "ID: " + student.id +
                    " | " + student.name +
                    " | " + student.eligibilityReason()
            );
        }
    }

    static List<Student> getEligibleStudents() {
        List<Student> eligible = new ArrayList<>();

        for (Student student : students) {
            if (student.isEligible()) {
                eligible.add(student);
            }
        }

        return eligible;
    }

    static void displayShortlist() {
        System.out.println("\n--- Shortlisted Students ---");

        List<Student> eligible = getEligibleStudents();

        if (eligible.isEmpty()) {
            System.out.println("No eligible students found.");
            return;
        }

        // Default shortlist: students with merit score >= 70.
        List<Student> shortlist = new ArrayList<>();

        for (Student student : eligible) {
            if (student.meritScore() >= 70) {
                shortlist.add(student);
            }
        }

        if (shortlist.isEmpty()) {
            System.out.println("No students reached the merit-score threshold of 70.");
            return;
        }

        for (Student student : shortlist) {
            System.out.println(student);
        }
    }

    static void sortAndDisplayShortlist() {
        System.out.println("\n--- Sorted Shortlist ---");

        List<Student> shortlist = new ArrayList<>();

        for (Student student : getEligibleStudents()) {
            if (student.meritScore() >= 70) {
                shortlist.add(student);
            }
        }

        shortlist.sort(
                Comparator.comparingDouble(Student::meritScore).reversed()
                        .thenComparingDouble(s -> s.familyIncome)
        );

        if (shortlist.isEmpty()) {
            System.out.println("No students available for shortlisting.");
            return;
        }

        int rank = 1;
        for (Student student : shortlist) {
            System.out.println(
                    "Rank " + rank++ + " -> " + student
            );
        }
    }

    static void seedSampleData() {
        students.add(new Student(
                nextId++, "Arun Kumar", 20, 150000, 82,
                true, false, false, true
        ));

        students.add(new Student(
                nextId++, "Priya S", 21, 420000, 91,
                false, true, false, true
        ));

        students.add(new Student(
                nextId++, "Rahul M", 19, 600000, 88,
                true, false, false, true
        ));

        students.add(new Student(
                nextId++, "Divya R", 23, 90000, 68,
                true, false, true, true
        ));
    }

    static int readInt() {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid integer: ");
            }
        }
    }

    static double readDouble() {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());

                if (value < 0) {
                    System.out.print("Value cannot be negative. Enter again: ");
                    continue;
                }

                return value;
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }

    static boolean readYesNo() {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("y") || input.equals("yes")) {
                return true;
            }

            if (input.equals("n") || input.equals("no")) {
                return false;
            }

            System.out.print("Please enter Y or N: ");
        }
    }
}
