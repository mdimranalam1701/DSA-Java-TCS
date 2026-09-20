import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class musicplayer {

    // =========================
    // ACTION ENUM
    // =========================
    enum Action {
        NEXT,
        PREVIOUS,
        DOUBLE_TAP_PREVIOUS,
        PLAY_PAUSE
    }

    // =========================
    // SONG CLASS
    // =========================
    static class Song {

        private String title;
        private String artist;

        public Song(String title, String artist) {
            this.title = title;
            this.artist = artist;
        }

        public String getTitle() {
            return title;
        }

        public String getArtist() {
            return artist;
        }

        @Override
        public String toString() {
            return title + " - " + artist;
        }
    }

    // =========================
    // MUSIC PLAYER CLASS
    // =========================
    static class MusicPlayer {

        private List<Song> songs;
        private int currentIndex;
        private boolean playing;

        public MusicPlayer(List<Song> songs) {

            this.songs = songs;
            this.currentIndex = 0;
            this.playing = false;
        }

        // Play / Pause
        public void playPause() {

            if (songs.isEmpty()) {
                System.out.println("Playlist is empty.");
                return;
            }

            playing = !playing;

            if (playing) {
                System.out.println(
                        "▶ Playing: " + songs.get(currentIndex)
                );
            } else {
                System.out.println(
                        "⏸ Paused: " + songs.get(currentIndex)
                );
            }
        }

        // Next song
        public void next() {

            if (songs.isEmpty()) {
                System.out.println("Playlist is empty.");
                return;
            }

            currentIndex++;

            // Circular playlist
            if (currentIndex >= songs.size()) {
                currentIndex = 0;
            }

            playing = true;

            System.out.println(
                    "⏭ Next: " + songs.get(currentIndex)
            );
        }

        // Previous song
        public void previous() {

            if (songs.isEmpty()) {
                System.out.println("Playlist is empty.");
                return;
            }

            currentIndex--;

            // Circular playlist
            if (currentIndex < 0) {
                currentIndex = songs.size() - 1;
            }

            playing = true;

            System.out.println(
                    "⏮ Previous: " + songs.get(currentIndex)
            );
        }

        // Handle user action
        public void handleAction(Action action) {

            switch (action) {

                case NEXT:
                    next();
                    break;

                case PREVIOUS:
                    previous();
                    break;

                case DOUBLE_TAP_PREVIOUS:
                    previous();
                    break;

                case PLAY_PAUSE:
                    playPause();
                    break;
            }
        }

        // Show current song
        public void showCurrentSong() {

            if (songs.isEmpty()) {
                System.out.println("Playlist is empty.");
                return;
            }

            System.out.println(
                    "Current Song: " + songs.get(currentIndex)
            );

            System.out.println(
                    "Status: " + (playing ? "Playing" : "Paused")
            );
        }

        // Show complete playlist
        public void showPlaylist() {

            System.out.println("\n===== PLAYLIST =====");

            for (int i = 0; i < songs.size(); i++) {

                if (i == currentIndex) {
                    System.out.println(
                            "▶ " + (i + 1) + ". " + songs.get(i)
                    );
                } else {
                    System.out.println(
                            "  " + (i + 1) + ". " + songs.get(i)
                    );
                }
            }

            System.out.println("====================");
        }
    }

    // =========================
    // MAIN METHOD
    // =========================
    public static void main(String[] args) {

        // Create playlist
        List<Song> songs = new ArrayList<>();

        songs.add(new Song("Perfect", "Ed Sheeran"));
        songs.add(new Song("Believer", "Imagine Dragons"));
        songs.add(new Song("Shape of You", "Ed Sheeran"));
        songs.add(new Song("Blinding Lights", "The Weeknd"));
        songs.add(new Song("Faded", "Alan Walker"));

        // Create music player
        MusicPlayer player = new MusicPlayer(songs);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== MUSIC PLAYER =====");

            System.out.println("1. Play / Pause");
            System.out.println("2. Next");
            System.out.println("3. Previous");
            System.out.println("4. Double Tap Previous");
            System.out.println("5. Show Current Song");
            System.out.println("6. Show Playlist");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    player.handleAction(Action.PLAY_PAUSE);
                    break;

                case 2:
                    player.handleAction(Action.NEXT);
                    break;

                case 3:
                    player.handleAction(Action.PREVIOUS);
                    break;

                case 4:
                    player.handleAction(Action.DOUBLE_TAP_PREVIOUS);
                    break;

                case 5:
                    player.showCurrentSong();
                    break;

                case 6:
                    player.showPlaylist();
                    break;

                case 7:
                    System.out.println("Music player closed.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
