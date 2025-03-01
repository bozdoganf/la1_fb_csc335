import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

class PlayListTest {

    @Test
    void testGetName() {
        PlayList playlist = new PlayList("Mission Bell");
        assertEquals("Mission Bell", playlist.getName());
    }

    @Test
    void testAddSong() {
        PlayList playlist = new PlayList("Mission Bell");
        
        Song song = new Song("Clear Blue Eyes (feat. Lucinda Williams)", "Amos Lee", "Singer/Songwriter");
        playlist.addSong(song);

        assertTrue(playlist.findSong("Clear Blue Eyes (feat. Lucinda Williams)", "Amos Lee", "Singer/Songwriter") != null);
    }

    @Test
    void testRemoveSong() {
        PlayList playlist = new PlayList("Mission Bell");
        
        playlist.removeSong("Flower", "Amos Lee", "Singer/Songwriter");
        assertNull(playlist.findSong("Flower", "Amos Lee", "Singer/Songwriter"));
    }

    @Test
    void testIsEmpty() {
        PlayList playlist = new PlayList("Mission Bell");
        assertFalse(playlist.isEmpty());
        
        playlist.removeSong("El Camino", "Amos Lee", "Singer/Songwriter");
        playlist.removeSong("Windows Are Rolled Down", "Amos Lee", "Singer/Songwriter");
        playlist.removeSong("Flower", "Amos Lee", "Singer/Songwriter");
        playlist.removeSong("Stay With Me", "Amos Lee", "Singer/Songwriter");
        playlist.removeSong("Out of the Cold", "Amos Lee", "Singer/Songwriter");
        playlist.removeSong("Jesus", "Amos Lee", "Singer/Songwriter");
        playlist.removeSong("Hello Again", "Amos Lee", "Singer/Songwriter");
        playlist.removeSong("Cup of Sorrow", "Amos Lee", "Singer/Songwriter");
        playlist.removeSong("Clear Blue Eyes (feat. Lucinda Williams)", "Amos Lee", "Singer/Songwriter");
        playlist.removeSong("Behind Me Now", "Amos Lee", "Singer/Songwriter");
        
        assertTrue(playlist.isEmpty());
    }

    @Test
    void testSearchSongByArtist() {
        ArrayList<Boolean> found = new ArrayList<>();
        found.add(false);
        HashSet<Song> songsSearched = new HashSet<>();

        PlayList playlist = new PlayList("Mission Bell");
        playlist.searchSongByArtist("Amos Lee", found, songsSearched);
        
        Song song = new Song("Windows Are Rolled Down", "Amos Lee", "Singer/Songwriter");
        assertTrue(found.get(0));
        assertTrue(songsSearched.contains(song));
    }

    @Test
    void testSearchSongByTitle() {
        ArrayList<Boolean> found = new ArrayList<>();
        found.add(false);
        HashSet<Song> songsSearched = new HashSet<>();

        PlayList playlist = new PlayList("Mission Bell");
        playlist.searchSongByTitle("El Camino", found, songsSearched);

        Song song = new Song("El Camino", "Amos Lee", "Singer/Songwriter");
        assertTrue(found.get(0));
        assertTrue(songsSearched.contains(song));
    }

    @Test
    void testPrintPlaylist() {
        PlayList playlist = new PlayList("Mission Bell");
        playlist.printPlaylist();
    }

    @Test
    void testRetrievePlayListSongs() {
        HashSet<Song> result = new HashSet<>();
        PlayList playlist = new PlayList("Mission Bell");
        playlist.retrievePlayListSongs(result);
        
        Song song1 = new Song("El Camino", "Amos Lee", "Singer/Songwriter");
        Song song2 = new Song("Windows Are Rolled Down", "Amos Lee", "Singer/Songwriter");
        Song song3 = new Song("Flower", "Amos Lee", "Singer/Songwriter");

        assertTrue(result.contains(song1));
        assertTrue(result.contains(song2));
        assertTrue(result.contains(song3));
    }
}
