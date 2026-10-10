import java.util.Scanner;

public class Q5 {
    static abstract class Subscriber {
        String name;
        String startDate;
        Subscriber(String n, String s) { name = n; startDate = s; }
        abstract int getValidity();
        String getRenewalDate() {
            return java.time.LocalDate.parse(startDate).plusDays(getValidity()).toString();
        }
    }
    static class Basic extends Subscriber {
        Basic(String n, String s) { super(n, s); }
        int getValidity() { return 30; }
    }
    static class Standard extends Subscriber {
        Standard(String n, String s) { super(n, s); }
        int getValidity() { return 90; }
    }
    static class Premium extends Subscriber {
        Premium(String n, String s) { super(n, s); }
        int getValidity() { return 365; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Subscriber[] subs = new Subscriber[n];
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            String sdate = scanner.next();
            if (type.equals("BASIC")) subs[i] = new Basic(name, sdate);
            else if (type.equals("STANDARD")) subs[i] = new Standard(name, sdate);
            else subs[i] = new Premium(name, sdate);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(subs[i].name + ": " + subs[i].getRenewalDate());
        }
        scanner.close();
    }
}
