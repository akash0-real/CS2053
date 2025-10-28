import java.util.LinkedList;
import java.util.Scanner;

public class MusicPlaylist {
    public static void main(String[] args) {
        LinkedList<String> playlist = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            
            System.out.println("1. Add song at the beginning");
            System.out.println("2. Add song at the end");
            System.out.println("3. Remove first song");
            System.out.println("4. Remove last song");
            System.out.println("5. Replace song at a given index");
            System.out.println("6. Display complete playlist");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter song name to add at beginning: ");
                    String firstSong = sc.nextLine();
                    playlist.addFirst(firstSong);
                    System.out.println(firstSong + "' added at the beginning.");
                    break;

                case 2:
                    System.out.print("Enter song name to add at end: ");
                    String lastSong = sc.nextLine();
                    playlist.addLast(lastSong);
                    System.out.println(lastSong + "' added at the end.");
                    break;

                case 3:
                    if (!playlist.isEmpty()) {
                        System.out.println("Removed: " + playlist.removeFirst());
                    } else {
                        System.out.println("Playlist is empty!");
                    }
                    break;

                case 4:
                    if (!playlist.isEmpty()) {
                        System.out.println("Removed: " + playlist.removeLast());
                    } else {
                        System.out.println("Playlist is empty!");
                    }
                    break;

                case 5:
                    if (playlist.isEmpty()) {
                        System.out.println(" Playlist is empty!");
                    } else {
                        System.out.print("Enter index to replace (0 - " + (playlist.size() - 1) + "): ");
                        int index = sc.nextInt();
                        sc.nextLine(); 
                        if (index >= 0 && index < playlist.size()) {
                            System.out.print("Enter new song name: ");
                            String newSong = sc.nextLine();
                            playlist.set(index, newSong);
                            System.out.println("Song at index " + index + " replaced with '" + newSong + "'.");
                        } else {
                            System.out.println("Invalid index!");
                        }
                    }
                    break;

                case 6:
                    if (playlist.isEmpty()) {
                        System.out.println("🎧 Playlist is empty!");
                    } else {
                        System.out.println("\n🎶 Complete Playlist:");
                        int i = 0;
                        for (String song : playlist) {
                            System.out.println((i++) + ". " + song);
                        }
                    }
                    break;

                case 7:
                    System.out.println("Exiting playlist manager. Bye!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 7);

        sc.close();
    }
}
