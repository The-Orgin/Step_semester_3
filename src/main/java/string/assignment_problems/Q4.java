import java.util.Scanner;

public class Q4 {
    static class TrafficLight {
        private String color;
        private final String id;

        public TrafficLight(String id) {
            this.id = id;
            this.color = "RED";
        }

        public void next() {
            if (this.color.equals("RED")) {
                this.color = "GREEN";
            } else if (this.color.equals("GREEN")) {
                this.color = "YELLOW";
            } else if (this.color.equals("YELLOW")) {
                this.color = "RED";
            }
        }

        public String getColor() {
            return this.color;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) {
            scanner.close();
            return;
        }
        TrafficLight t = new TrafficLight(scanner.next());
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) t.next();
        System.out.println(t.getColor());
        scanner.close();
    }
}
