import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            scanner.close();
            return;
        }
        String feedback = scanner.nextLine();
        printFilteredWordFrequency(feedback);
        scanner.close();
    }

    public static void printFilteredWordFrequency(String feedback) {
        String[] stopWordsArr = {"the", "was", "and", "a", "is", "of", "in"};
        java.util.HashSet<String> stopWords = new java.util.HashSet<>();
        for (int i = 0; i < stopWordsArr.length; i++) {
            stopWords.add(stopWordsArr[i]);
        }

        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");

        java.util.HashMap<String, Integer> counts = new java.util.HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (!w.isEmpty() && !stopWords.contains(w)) {
                counts.put(w, counts.getOrDefault(w, 0) + 1);
            }
        }

        java.util.List<java.util.Map.Entry<String, Integer>> list = new java.util.ArrayList<>(counts.entrySet());
        list.sort(new java.util.Comparator<java.util.Map.Entry<String, Integer>>() {
            public int compare(java.util.Map.Entry<String, Integer> o1, java.util.Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + ": " + list.get(i).getValue());
        }
    }
}
