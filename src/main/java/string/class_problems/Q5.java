import java.util.Scanner;

public class Q5 {
    static class AttendanceSheet {
        private String[] presentStudents;
        private int count;

        public AttendanceSheet(int maxSize) {
            this.presentStudents = new String[maxSize];
            this.count = 0;
        }

        public void markPresent(String name) {
            if (this.count < this.presentStudents.length && !isPresent(name)) {
                this.presentStudents[this.count] = name;
                this.count++;
            }
        }

        public int getPresentCount() {
            return this.count;
        }

        public boolean isPresent(String name) {
            for (int i = 0; i < this.count; i++) {
                if (this.presentStudents[i].equals(name)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        AttendanceSheet sheet = new AttendanceSheet(scanner.nextInt());
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            sheet.markPresent(scanner.next());
        }
        System.out.println(sheet.getPresentCount());
        scanner.close();
    }
}
