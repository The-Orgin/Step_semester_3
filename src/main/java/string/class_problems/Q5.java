import java.util.Scanner;

public class Q5 {
    static class Student {
        String name;
        int attendance;
        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;
        public Student(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }
        public static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student s1 = new Student("A", 80);
        Student s2 = new Student("B", 90);
        Student.printCollegeInfo();
        scanner.close();
    }
}
