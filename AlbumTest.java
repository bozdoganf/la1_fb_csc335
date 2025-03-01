import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashSet;




class AlbumTest {



    @Test
    void testGetTitle() {
    	Album album = new Album("19", "Adele", "Pop", "2008");
        assertEquals("19", album.getTitle());
    }

    @Test
    void testGetArtist() {
    	Album album = new Album("Waking Up", "OneRepublic", "Rock", "2009");
        assertEquals("OneRepublic", album.getArtist());
    }

    @Test
    void testGetGenre() {
    	Album album = new Album("Waking Up", "OneRepublic", "Rock", "2009");
        assertEquals("Rock", album.getGenre());
    }

    @Test
    void testGetYear() {
    	Album album = new Album("21", "Adele", "Pop", "2008");
        assertEquals("2008", album.getYear());
    }

    // Test for retrieveAlbumSongs method
    
    @Test
    void testRetrieveAlbumSongs() {
    	Album album = new Album("Waking Up", "OneRepublic", "Rock", "2009");
        HashSet<Song> resultSet = new HashSet<>();
        album.retrieveAlbumSongs(resultSet);
        
        Song song1 = new Song("Fear", "OneRepublic", "Waking Up");
        Song song2 = new Song("Lullaby", "OneRepulic", "Waking Up");


        assertEquals(2, resultSet.size(), "The set should contain 2 songs.");
        assertTrue(resultSet.contains(song1), "The set should contain song1.");
        assertTrue(resultSet.contains(song2), "The set should contain song2.");
    }

    // Test for printAllSongs method

    @Test
    void testSearchSongByTitle() {
        ArrayList<Boolean> found = new ArrayList<>();
        found.add(false);  // Initialize with false
        ArrayList<Song> songsSearched1 = new ArrayList<>();

    	Album album = new Album("Waking Up", "OneRepublic", "Rock", "2009");
        album.searchSongByTitle("Fear", found, songsSearched1);

        assertTrue(found.get(0), "The song should be found in the album");
        assertEquals(1, songsSearched1.size());
        assertEquals("Fear", songsSearched1.get(0).getSongTitle());
    }

    @Test
    void testSearchSongByTitleWithHashSet() {
        ArrayList<Boolean> found = new ArrayList<>();
        found.add(false);
        HashSet<Song> songsSearched1 = new HashSet<>();
    	Album album = new Album("Waking Up", "OneRepublic", "Rock", "2009");

        album.searchSongByTitle("Fear", found, songsSearched1);

        assertTrue(found.get(0), "The song should be found in the album");
        assertEquals(1, songsSearched1.size());
     
    }

    @Test
    void testSearchSongByTitleNotFound() {
        ArrayList<Boolean> found = new ArrayList<>();
        found.add(false);
        ArrayList<Song> songsSearched1 = new ArrayList<>();

    	Album album = new Album("Waking Up", "OneRepublic", "Rock", "2009");

        album.searchSongByTitle("Not Available Song", found, songsSearched1);

        assertFalse(found.get(0), "The song should not be found in the album");
        assertEquals(0, songsSearched1.size());
    }

    @Test
    void testSearchSongByArtist() {
        ArrayList<Boolean> found = new ArrayList<>();
        found.add(false);
        ArrayList<Song> songsSearched2 = new ArrayList<>();
        
    	Album album = new Album("Waking Up", "OneRepublic", "Rock", "2009");


        album.searchSongByArtist("OneRepulic", found, songsSearched2);

        assertTrue(found.get(0), "Song OneRepublic should not be found");
        assertEquals(2, songsSearched2.size());
    }

    @Test
    void testSearchSongByArtistWithHashSet() {
        ArrayList<Boolean> found = new ArrayList<>();
        found.add(false);
        HashSet<Song> songsSearched2 = new HashSet<>();

    	Album album = new Album("Waking Up", "OneRepublic", "Rock", "2009");

        album.searchSongByArtist("OneRepublic", found, songsSearched2);

        assertTrue(found.get(0), "Songs by OneRepublic should be found");
        assertEquals(2, songsSearched2.size());
    }	

    @Test
    void testSearchSongByArtistNotFound() {
        ArrayList<Boolean> found = new ArrayList<>();
        found.add(false);
        ArrayList<Song> songsSearched2 = new ArrayList<>();
        
    	Album album = new Album("Waking Up", "OneRepublic", "Rock", "2009");
        album.searchSongByArtist("OneRepublic", found, songsSearched2);

        assertFalse(found.get(0), "Songs by OneRepublic should not be found");
        assertEquals(0, songsSearched2.size());
    }

    @Test
    void testFindSong() {
    	Album album = new Album("Waking Up", "OneRepublic", "Rock", "2009");
        Song foundSong = album.findSong("Fear", "OneRepublic", "Waking Up");
        assertNotNull(foundSong);
        assertEquals("Fear", foundSong.getSongTitle());
    }
    

    
    @Test
    void testFindSongNotFound() {
    	Album album = new Album("Waking Up", "OneRepublic", "Rock", "2009");
        Song foundSong = album.findSong("My Same", "OneRepublic", "Waking Up");
        assertNull(foundSong);
    }
}
