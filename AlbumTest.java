package la2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AlbumTest {

	@Test
	void testGetters() {
		Album a = new Album("19", "Adele", "Pop", "2008");
		assertTrue(a.getTitle().equals("19"));
		assertTrue(a.getArtist().equals("Adele"));
		assertTrue(a.getGenre().equals("Pop"));
		assertTrue(a.getYear().equals("2008"));
	}
	
	@Test
	void testCopyConstructor() {
		ArrayList<Song> songsArrLTest = new ArrayList<>();
		songsArrLTest.add(new Song("Tired", "Adele", "19"));
		Album a = new Album("19", "Adele", "Pop", "2008", songsArrLTest);
		assertTrue(a.getSongs().size() == songsArrLTest.size());
	}
	
	@Test
	void testAddSong() {
		Album a = new Album("19", "Adele", "Pop", "2008");
		a.addSong("Lullaby", "OneRepublic", "Waking Up");

		assertEquals(a.getSongs().size(), 1);
	}
	
	@Test
	void testAddingAnExistingSongAgain() {
		Album a = new Album("19", "Adele", "Pop", "2008");
		a.addSong("Lullaby", "OneRepublic", "Waking Up");
		a.addSong("Lullaby", "OneRepublic", "Waking Up");

		assertEquals(a.getSongs().size(), 1);
	}
	
	@Test
	void testFindSongsByTitle() {
		Album a = new Album("19", "Adele", "Pop", "2008");
		a.addSong("Tired", "Adele", "19");
		a.addSong("Daydreamer", "Adele", "19");
		a.addSong("Best for Last", "Adele", "19");
		ArrayList<Song> songsFoundByTitle = a.findSongsByTitle("Tired");
		assertTrue(songsFoundByTitle.get(0).getSongTitle().equals("Tired"));
	}
}
