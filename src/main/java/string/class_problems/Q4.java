import java.util.Scanner;

public class Q4 {
    static abstract class Question {
        String text, correct, student;
        int points;
        Question(String t, String c, String s, int p) { text = t; correct = c; student = s; points = p; }
        abstract double getScore();
        abstract String getType();
    }
    static class MCQ extends Question {
        MCQ(String t, String c, String s, int p) { super(t, c, s, p); }
        double getScore() { return student.equals(correct) ? points : 0.0; }
        String getType() { return "MCQ"; }
    }
    static class TF extends Question {
        TF(String t, String c, String s, int p) { super(t, c, s, p); }
        double getScore() { return student.equals(correct) ? points : 0.0; }
        String getType() { return "TF"; }
    }
    static class Essay extends Question {
        Essay(String t, String c, String s, int p) { super(t, c, s, p); }
        double getScore() {
            String[] keywords = correct.split(",");
            int match = 0;
            String st = student.toLowerCase();
            for (int i = 0; i < keywords.length; i++) {
                if (st.contains(keywords[i].trim().toLowerCase())) match++;
            }
            if (match >= 2) return points * 0.75;
            if (match == 1) return points * 0.50;
            return 0.0;
        }
        String getType() { return "ESSAY"; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }
        String firstLine = scanner.nextLine().trim();
        if (firstLine.isEmpty()) firstLine = scanner.nextLine().trim();
        int n = Integer.parseInt(firstLine);
        Question[] questions = new Question[n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            int sp1 = line.indexOf(' ');
            String type = line.substring(0, sp1);
            line = line.substring(sp1 + 1).trim();

            java.util.ArrayList<String> tokens = new java.util.ArrayList<>();
            int start = 0;
            while (start < line.length()) {
                if (line.charAt(start) == '"') {
                    int end = line.indexOf('"', start + 1);
                    tokens.add(line.substring(start + 1, end));
                    start = end + 1;
                    while (start < line.length() && line.charAt(start) == ' ') start++;
                } else {
                    int end = line.indexOf(' ', start);
                    if (end == -1) end = line.length();
                    tokens.add(line.substring(start, end));
                    start = end + 1;
                }
            }
            String qText = tokens.get(0);
            String correct = tokens.get(1);
            String student = tokens.get(2);
            int pts = Integer.parseInt(tokens.get(3));

            if (type.equals("MCQ")) questions[i] = new MCQ(qText, correct, student, pts);
            else if (type.equals("TF")) questions[i] = new TF(qText, correct, student, pts);
            else questions[i] = new Essay(qText, correct, student, pts);
        }
        double total = 0;
        for (int i = 0; i < n; i++) {
            double score = questions[i].getScore();
            System.out.printf("%s: %.2f\n", questions[i].getType(), score);
            total += score;
        }
        System.out.printf("Total Score: %.2f\n", total);
        scanner.close();
    }
}
