import java.util.Scanner;

public class Q1 {
    static class PlacementRecord {
        String studentName;
        String company;
        double packageLpa;
        public PlacementRecord(String studentName, String company, double packageLpa) {
            this.studentName = studentName;
            this.company = company;
            this.packageLpa = packageLpa;
        }
        public void printRecord() {
            System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlacementRecord[] records = new PlacementRecord[3];
        if (scanner.hasNextLine()) {
            for (int i = 0; i < 3; i++) {
                String name = scanner.nextLine();
                String company = scanner.nextLine();
                double lpa = Double.parseDouble(scanner.nextLine());
                records[i] = new PlacementRecord(name, company, lpa);
            }
        } else {
            records[0] = new PlacementRecord("Ravi", "TCS", 4.5);
            records[1] = new PlacementRecord("Anitha", "Zoho", 6.2);
            records[2] = new PlacementRecord("Karthik", "Infosys", 4.0);
        }
        for (int i = 0; i < records.length; i++) {
            records[i].printRecord();
        }
        scanner.close();
    }
}
