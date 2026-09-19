import java.util.Scanner;

public class Q2 {
    static class Playlist {
        private String[] songs;
        private int count;

        public Playlist(int maxSize) {
            this.songs = new String[maxSize];
            this.count = 0;
        }

        public void addSong(String song) {
            if (this.count < this.songs.length) {
                this.songs[this.count] = song;
                this.count++;
            }
        }

        public String[] getSongs() {
            String[] copy = new String[this.count];
            for (int i = 0; i < this.count; i++) {
                copy[i] = this.songs[i];
            }
            return copy;
        }

        public int getSongCount() {
            return this.count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        Playlist p = new Playlist(scanner.nextInt());
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            p.addSong(scanner.nextLine());
        }
        System.out.println(p.getSongCount());
        scanner.close();
    }
}
