import java.util.Scanner;

public class Q4 {
    static class Locker {
        private final String id;
        private String code;

        public Locker(String id, String initialCode) {
            this.id = id;
            this.code = initialCode;
        }

        public void changeCode(String oldCode, String newCode) {
            if (this.code.equals(oldCode)) {
                this.code = newCode;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) {
            scanner.close();
            return;
        }
        Locker l = new Locker(scanner.next(), scanner.next());
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            l.changeCode(scanner.next(), scanner.next());
        }
        scanner.close();
    }
}
