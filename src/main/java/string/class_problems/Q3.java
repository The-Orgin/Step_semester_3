import java.util.Scanner;

public class Q3 {
    static class NameTag {
        private final String nickname;

        public NameTag(String fullName) {
            String[] parts = fullName.split(" ");
            if (parts.length >= 2) {
                this.nickname = parts[0] + " " + parts[1].charAt(0) + ".";
            } else {
                this.nickname = fullName;
            }
        }

        public String getNickname() {
            return this.nickname;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }
        String fullName = scanner.nextLine();
        NameTag tag = new NameTag(fullName);
        System.out.println(tag.getNickname());
        scanner.close();
    }
}
