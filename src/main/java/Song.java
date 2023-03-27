import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
public class Song {
    private int songID;
    private String songData1;
    private String songData2;
    private String songData3;
    private int songData4;

    public Song(int songID, String songData1, String songData2, String songData3, int songData4) {
        this.songID = songID;
        this.songData1 = songData1;
        this.songData2 = songData2;
        this.songData3 = songData3;
        this.songData4 = songData4;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getSongData1() {
        return songData1;
    }

    public void setSongData1(String songData1) {
        this.songData1 = songData1;
    }

    public String getSongData2() {
        return songData2;
    }

    public void setSongData2(String songData2) {
        this.songData2 = songData2;
    }

    public String getSongData3() {
        return songData3;
    }

    public void setSongData3(String songData3) {
        this.songData3 = songData3;
    }

    public int getSongData4() {
        return songData4;
    }

    public void setSongData4(int songData4) {
        this.songData4 = songData4;
    }

    @Override
    public String toString() {
        return songID + "\t" + songData1 + "\t" + songData2 + "\t" + songData3 + "\t" + songData4;
    }
    public static void displayAllSongs(LinkedList<Song> songs) {
        for (Song song : songs) {
            System.out.println(song.getSongData1() + "\t" + song.getSongData2() + "\t" + song.getSongData3());
        }
    }
    public static Song[] readSongsToArray(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        Song[] songs = new Song[25];
        int i = 0;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("\t");
            int id = Integer.parseInt(data[0]);
            String songData1 = data[1];
            String songData2 = data[2];
            String songData3 = data[3];
            int songData4 = Integer.parseInt(data[4]);
            Song song = new Song(id, songData1, songData2, songData3, songData4);
            songs[i++] = song;
        }
        reader.close();
        return songs;
    }

    public static LinkedList<Song> readSongsToList(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        LinkedList<Song> songs = new LinkedList<>();
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("\t");
            int id = Integer.parseInt(data[0]);
            String songData1 = data[1];
            String songData2 = data[2];
            String songData3 = data[3];
            int songData4 = Integer.parseInt(data[4]);
            Song song = new Song(id, songData1, songData2, songData3, songData4);
            songs.add(song);
        }
        reader.close();
        return songs;
    }
    public static Song searchByName(String name, Song[] songs) {
        for (Song song : songs) {
            if (song.getSongData1().equals(name)) {
                return song;
            }
        }
        return null;
    }

    public static Song searchByYearAndName(int year, String name, LinkedList<Song> songs) {
        for (Song song : songs) {
            if (song.getSongData3().equals(String.valueOf(year)) && song.getSongData1().equals(name)) {
                return song;
            }
        }
        return null;
    }
    public static Song[] searchSongsByName(Song[] songs, String name) {
        ArrayList<Song> matchingSongs = new ArrayList<>();
        for (Song song : songs) {
            if (song.getSongData1().equals(name)) {
                matchingSongs.add(song);
            }
        }
        return matchingSongs.toArray(new Song[0]);
    }

    public static LinkedList<Song> searchSongsByYear(LinkedList<Song> songs, int year) {
        LinkedList<Song> matchingSongs = new LinkedList<>();
        for (Song song : songs) {
            int songYear = Integer.parseInt(song.getSongData2());
            if (songYear >= year) {
                matchingSongs.add(song);
            }
        }
        return matchingSongs;
    }
}
