import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class SongTableGenerator {

    public static void main(String[] args) {
        String[] songs = {
                "Shape of You", "Despacito", "Uptown Funk", "Thinking Out Loud", "One Dance",
                "Closer", "Old Town Road", "See You Again", "Sorry", "Roar",
                "Dark Horse", "All About That Bass", "Havana", "Girls Like You", "Something Just Like This",
                "Can't Stop the Feeling!", "Love Yourself", "Stay With Me", "Happy", "Shallow",
                "God's Plan", "I Like It", "Bad Guy", "Blinding Lights", "Dynamite"
        };
        String[] artists = {
                "Ed Sheeran", "Luis Fonsi", "Mark Ronson ft. Bruno Mars", "Ed Sheeran", "Drake",
                "The Chainsmokers ft. Halsey", "Lil Nas X ft. Billy Ray Cyrus", "Wiz Khalifa ft. Charlie Puth", "Justin Bieber", "Katy Perry",
                "Katy Perry ft. Juicy J", "Meghan Trainor", "Camila Cabello ft. Young Thug", "Maroon 5 ft. Cardi B", "The Chainsmokers ft. Coldplay",
                "Justin Timberlake", "Justin Bieber", "Sam Smith", "Pharrell Williams", "Lady Gaga and Bradley Cooper",
                "Drake", "Cardi B ft. Bad Bunny and J Balvin", "Billie Eilish", "The Weeknd", "BTS"
        };
        String[] genres = {
                "Pop", "Reggaeton", "Funk", "Pop", "Hip hop",
                "Electronic", "Country rap", "Pop", "Pop", "Pop rock",
                "Pop", "Pop", "Pop", "Pop rock", "Electronic",
                "Pop", "Pop", "Soul", "Pop", "Pop rock",
                "Hip hop", "Latin trap", "Electropop", "Synthwave", "Disco-pop"
        };
        int[] years = {
                2017, 2017, 2014, 2014, 2016,
                2016, 2019, 2015, 2015, 2013,
                2013, 2014, 2017, 2018, 2017,
                2016, 2015, 2014, 2013, 2018,
                2018, 2018, 2019, 2020, 2020
        };

        try {
            FileWriter writer = new FileWriter("song_table.txt");
            writer.write("Song ID\tSong\tArtist\tGenre\tYear\n");
            writer.write("=======\t====\t======\t=====\t====\n");

            Random random = new Random();
            for (int i = 0; i < songs.length; i++) {
                int songID = random.nextInt(9000000) + 1000000;
                writer.write(songID + "\t" + songs[i] + "\t" + artists[i] + "\t" + genres[i] + "\t" + years[i] + "\n");
                writer.write(songID + "\t" + songs[i] + "\t" + artists[i] + "\t" + genres[i] + "\t" + years[i] + "\n");
            }

            writer.close();
            System.out.println("Successfully generated song_table.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while generating the song table.");
        }
    }

}
