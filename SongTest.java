import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class SongTest {

    
    @Test
    void testArtistName() {
    	Song song = new Song("Tired", "Adele", "19");
        assertEquals("Adele", song.getArtistName());
    }
    
    @Test
    void testSongTitle() {
    	Song song = new Song("Tired", "Adele", "19");
        assertEquals("Tired", song.getSongTitle());
    }

    @Test
    void testFavStatus() {
    	Song song = new Song("Tired", "Adele", "19");
        assertFalse(song.getFavStatus(), "Favorite status should be false by default");
    }
    
    @Test
    void testAlbumTitle() {
    	Song song = new Song("Tired", "Adele", "19");
        assertEquals("19", song.getAlbumTitle());
    }

   

    @Test
    void testRating() {
    	Song song = new Song("Tired", "Adele", "19");
        song.setRating(Rating.FIVE);
        assertEquals(Rating.FIVE, song.getSongRating());
        assertTrue(song.getFavStatus(), "Favorite status should be true when rating is FIVE");

        song.setRating(Rating.THREE);
        assertEquals(Rating.THREE, song.getSongRating());
        assertTrue(song.getFavStatus(), "Favorite status should remain true once set to FIVE");
    }
}
