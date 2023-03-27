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
    public static Song[] readSongsToArray(String filename) {
        ArrayList<Song> songsList = new ArrayList<>();
        String line;
        String[] songData;

        try (BufferedReader reader = new BufferedReader(new FileReader("songs_table.txt"))) {
            // Skip the header row
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                songData = line.split(",");

                int id;
                try {
                    id = Integer.parseInt(songData[0].trim());
                } catch (NumberFormatException e) {
                    continue; // skip this line if the ID is not a valid integer
                }

                String data1 = songData.length > 1 ? songData[1].trim() : "";
                String data2 = songData.length > 2 ? songData[2].trim() : "";
                String data3 = songData.length > 3 ? songData[3].trim() : "";
                int data4 = songData.length > 4 ? Integer.parseInt(songData[4].trim()) : -1;

                Song song = new Song(id, data1, data2, data3, data4);
                songsList.add(song);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        Song[] songsArray = new Song[songsList.size()];
        songsArray = songsList.toArray(songsArray);
        return songsArray;
    }

    public static LinkedList<Song> readSongsToList(String filename) {
        LinkedList<Song> songsList = new LinkedList<>();
        String line;
        String[] songData;

        try (BufferedReader reader = new BufferedReader(new FileReader("songs_table.txt"))) {
            // Skip the header row
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                songData = line.split(",");

                if (songData.length < 4) {
                    // Handle the case where there are not enough columns in the data
                    continue;
                }

                int id;
                try {
                    id = Integer.parseInt(songData[0].trim());
                } catch (NumberFormatException e) {
                    id = -1;
                }
                String data1 = songData[1].trim();
                String data2 = songData[2].trim();
                String data3 = songData[3].trim();
                int data4;
                try {
                    data4 = Integer.parseInt(songData[4].trim());
                } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                    data4 = -1;
                }
                Song song = new Song(id, data1, data2, data3, data4);
                songsList.add(song);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return songsList;
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
