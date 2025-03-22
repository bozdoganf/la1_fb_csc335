package la2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SongTest {

	@Test
	void testGetters() {
		Song s = new Song("Daydreamer", "Adele", "19");
		assertTrue(s.getAlbumTitle().equals("19"));
		assertTrue(s.getArtistName().equals("Adele"));
		assertTrue(s.getFavStatus() == false);
		assertTrue(s.getSongRating() == null);
		assertTrue(s.getSongTitle().equals("Daydreamer"));		
	}
	@Test
	void testCopyConstructor() {
		Song s = new Song("Daydreamer", "Adele", "19", Rating.FOUR, false);
		assertTrue(s.getSongRating() == Rating.FOUR);
		assertTrue(s.getFavStatus() == false);
	}
	
	@Test
	void testRatingForAllAndFavStatus() {
		Song s = new Song("Daydreamer", "Adele", "19");
		s.setRating(1);
		assertTrue(s.getSongRating() == Rating.ONE);
		
		s.setRating(2);
		assertTrue(s.getSongRating() == Rating.TWO);
		
		s.setRating(3);
		assertTrue(s.getSongRating() == Rating.THREE);
		
		s.setRating(4);
		assertTrue(s.getSongRating() == Rating.FOUR);
		
		s.setRating(4);
		assertTrue(s.getSongRating() == Rating.FOUR);
		
		s.setRating(5);
		assertTrue(s.getSongRating() == Rating.FIVE);
		
		assertTrue(s.getFavStatus() == true);

	}

}
