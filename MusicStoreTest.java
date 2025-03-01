import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class MusicStoreTest {
    
    @Test
    void testSearchSongByTitleFound() {
        MusicStore musicStore = new MusicStore();
        musicStore.configureMS();
        Album album = new Album("Mission Bell", "Amos Lee", "Singer/Songwriter", "2010");
        Song song = new Song("Windows Are Rolled Down", "Amos Lee", "Mission Bell");
        album.buildAlbum(song);
        
        ArrayList<Song> result = musicStore.searchSongByTitle("Windows Are Rolled Down");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Windows Are Rolled Down", result.get(0).getSongTitle());
    }
    
    @Test
    void testSearchSongByTitleNotFound() {
        MusicStore musicStore = new MusicStore();
        musicStore.configureMS();
        
        ArrayList<Song> result = musicStore.searchSongByTitle("Nonexistent Song");

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSearchSongByArtistFound() {
        MusicStore musicStore = new MusicStore();
        musicStore.configureMS();
        Album album = new Album("Mission Bell", "Amos Lee", "Singer/Songwriter", "2010");
        Song song = new Song("Windows Are Rolled Down", "Amos Lee", "Mission Bell");
        album.buildAlbum(song);
        
        ArrayList<Song> result = musicStore.searchSongByArtist("Amos Lee");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Windows Are Rolled Down", result.get(0).getSongTitle());
    }

    @Test
    void testSearchSongByArtistNotFound() {
        MusicStore musicStore = new MusicStore();
        musicStore.configureMS();
        
        ArrayList<Song> result = musicStore.searchSongByArtist("Nonexistent Artist");

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSearchAlbumByTitleFound() {
        MusicStore musicStore = new MusicStore();
        musicStore.configureMS();
        Album album = new Album("Mission Bell", "Amos Lee", "Singer/Songwriter", "2010");
        
        ArrayList<Album> result = musicStore.searchAlbumByTitle("Mission Bell");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Mission Bell", result.get(0).getTitle());
    }

    @Test
    void testSearchAlbumByTitleNotFound() {
        MusicStore musicStore = new MusicStore();
        musicStore.configureMS();
        
        ArrayList<Album> result = musicStore.searchAlbumByTitle("Nonexistent Album");

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testSearchAlbumByArtistFound() {
        MusicStore musicStore = new MusicStore();
        musicStore.configureMS();
        Album album = new Album("Mission Bell", "Amos Lee", "Singer/Songwriter", "2010");
        
        ArrayList<Album> result = musicStore.searchAlbumByArtist("Amos Lee");

        
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Amos Lee", result.get(0).getArtist());
    }

    @Test
    void testSearchAlbumByArtistNotFound() {
        MusicStore musicStore = new MusicStore();
        musicStore.configureMS();
        
        ArrayList<Album> result = musicStore.searchAlbumByArtist("Nonexistent Artist");

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}