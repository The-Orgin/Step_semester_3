import java.util.Scanner;

public class Q4 {
    static class HallTicket {
        String studentName;
        int seatNumber;
        public HallTicket(String studentName, int seatNumber) {
            this.studentName = studentName;
            this.seatNumber = seatNumber;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;
        copy.seatNumber = 45;
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        HallTicket separate = new HallTicket("Priya", 45);
        System.out.println("separate == priya: " + (separate == priya));
        scanner.close();
    }
}
