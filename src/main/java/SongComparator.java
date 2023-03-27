import java.util.Comparator;

public class SongComparator {
    public static class NameComparator implements Comparator<Song> {
        @Override
        public int compare(Song s1, Song s2) {
            return s1.getSongData1().compareTo(s2.getSongData1());
        }
    }

    public static class YearAndNameComparator implements Comparator<Song> {
        @Override
        public int compare(Song s1, Song s2) {
            return Comparator.comparing(Song::getSongData3)
                    .thenComparing(Song::getSongData1)
                    .compare(s1, s2);
        }
    }
}
