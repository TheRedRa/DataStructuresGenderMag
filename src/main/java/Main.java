import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        LinkedList<Song> songs = new LinkedList<>();
        songs.add(new Song(1234567, "Stairway to Heaven", "Led Zeppelin", "Rock", 1971));
        songs.add(new Song(2345678, "Purple Rain", "Prince", "Pop", 1984));
        songs.add(new Song(3456789, "Thriller", "Michael Jackson", "Pop", 1982));

        System.out.println("First song data: " + songs.getFirst().getSongData1());
        System.out.println("Last song ID: " + songs.getLast().getSongID());
        Song secondSong = songs.get(1);
        System.out.println("Second song data before change: " + secondSong);
        secondSong.setSongData1("Raspberry Beret");
        secondSong.setSongData2("Prince and The Revolution");
        secondSong.setSongData3("Pop");
        secondSong.setSongData4(1985);
        System.out.println("Second song data after change: " + secondSong);
        Song.displayAllSongs(songs);

        Song[] songsArray = Song.readSongsToArray("songs.txt");
        System.out.println("Songs array:");
        for (Song song : songsArray) {
            System.out.println(song);
        }
        System.out.println();

        LinkedList<Song> songsList = Song.readSongsToList("songs.txt");
        System.out.println("Songs list:");
        for (Song song : songsList) {
            System.out.println(song);
        }
        System.out.println();

        String searchName = "Bohemian Rhapsody";
        Song[] songsByName = Song.searchSongsByName(songsArray, searchName);
        System.out.println("Songs with name \"" + searchName + "\":");
        for (Song song : songsByName) {
            System.out.println(song);
        }
        System.out.println();

        int searchYear = 1991;
        LinkedList<Song> songsByYear = Song.searchSongsByYear(songsList, searchYear);
        System.out.println("Songs from year " + searchYear + " or later:");
        for (Song song : songsByYear) {
            System.out.println(song);
        }
        System.out.println();
    }
}
