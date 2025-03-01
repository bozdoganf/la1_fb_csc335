import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

class LibraryModelTest {

    @Test
    void testSearchAlbumByTitleLib() {
        LibraryModel libraryModel = new LibraryModel();
        Album album = new Album("Mission Bell", "Amos Lee", "Singer/Songwriter", "2010");
        libraryModel.addAlbum(album);
        
        ArrayList<Album> result = libraryModel.searchAlbumByTitleLib("Mission Bell");
        assertEquals(1, result.size());
        assertEquals("Mission Bell", result.get(0).getTitle());
    }

    @Test
    void testSearchAlbumByArtist() {
        LibraryModel libraryModel = new LibraryModel();
        Album album = new Album("Mission Bell", "Amos Lee", "Singer/Songwriter", "2010");
        libraryModel.addAlbum(album);
        
        ArrayList<Album> result = libraryModel.searchAlbumByArtist("Amos Lee");
        assertEquals(1, result.size());
        assertEquals("Mission Bell", result.get(0).getTitle());
    }

    @Test
    void testSearchSongByArtistLib() {
        LibraryModel libraryModel = new LibraryModel();
        Song song1 = new Song("El Camino", "Amos Lee", "Mission Bell");
        Song song2 = new Song("Windows Are Rolled Down", "Amos Lee", "Mission Bell");
        libraryModel.addSong(song1);
        libraryModel.addSong(song2);
        
        HashSet<Song> result = libraryModel.searchSongByArtistLib("Amos Lee");
        assertTrue(result.contains(song1));
        assertTrue(result.contains(song2));
    }

    @Test
    void testSearchSongByTitleLib() {
        LibraryModel libraryModel = new LibraryModel();
        Song song = new Song("El Camino", "Amos Lee", "Mission Bell");
        libraryModel.addSong(song);
        
        HashSet<Song> result = libraryModel.searchSongByTitleLib("El Camino");
        assertTrue(result.contains(song));
    }

    @Test
    void testFindPlaylist() {
        LibraryModel libraryModel = new LibraryModel();
        libraryModel.initializeAPlayList("Mission Bell");
        
        PlayList foundPlaylist = libraryModel.findPlaylist("Mission Bell");
        assertNotNull(foundPlaylist);
        assertEquals("Mission Bell", foundPlaylist.getName());
    }

    @Test
    void testRateTheSong() {
        LibraryModel libraryModel = new LibraryModel();
        Song song = new Song("El Camino", "Amos Lee", "Mission Bell");
        libraryModel.addSong(song);
        Rating rating = Rating.FIVE;
        
        libraryModel.rateTheSong("El Camino", "Amos Lee", "Mission Bell", rating);
        assertEquals(rating, song.getSongRating());
        assertTrue(song.getFavStatus());
    }
 
    @Test
    void testSearchPlaylistByNameLib() {
        LibraryModel libraryModel = new LibraryModel();
        libraryModel.initializeAPlayList("Mission Bell");
        
        PlayList foundPlaylist = libraryModel.findPlaylist("Mission Bell");
        assertNotNull(foundPlaylist);
    }

    @Test
    void testFindTheSongLM() {
        LibraryModel libraryModel = new LibraryModel();
        Song song = new Song("El Camino", "Amos Lee", "Mission Bell");
        libraryModel.addSong(song);
        
        Song foundSong = libraryModel.findTheSongLM("El Camino", "Amos Lee", "Mission Bell");
        assertEquals(song, foundSong);
    }
}
