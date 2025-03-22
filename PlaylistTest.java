package la2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class PlaylistTest {

	@Test
	void testAddingAndRemoving() {
		Playlist p = new Playlist("my_playlist1");
		p.addSong("Lullaby", "Leonard Cohen", "Old Ideas");
		assertTrue(p.getSongs().size() == 1);
		
		p.removeSong("Lullaby", "Leonard Cohen", "Old Ideas");
		assertTrue(p.getSongs().size() == 0);
	}
	
	@Test
	void testRemovingForBranching() {
		Playlist p = new Playlist("my_playlist1");
		p.addSong("Lullaby", "Leonard Cohen", "Old Ideas");
		p.addSong("Lullaby", "OneRepublic", "Waking Up");
		assertFalse(p.removeSong("Lullaby", "Fatih", "my Album"));
		assertFalse(p.removeSong("Fatihs song", "OneRepublic", "Fatihs Album"));
		assertFalse(p.removeSong("Fatihs song", "Fatih", "Waking Up"));

	}
	
	
	@Test
	void testContainsSong() {
		Playlist p = new Playlist("my_playlist1");
		p.addSong("Tired", "Adele", "19");
		assertTrue(p.containsSong("Tired", "Adele", "19"));
		
		assertFalse(p.containsSong("Hi", "Fatih", "myAlbum"));
	}
	
	
	@Test
	void testGetName() {
		Playlist p = new Playlist("my_playlist1");
		assertTrue(p.getName().equals("my_playlist1"));
	}
	
	@Test
	void testCopyConstructor() {
		ArrayList<Song> songs = new ArrayList<>();
		Playlist p = new Playlist("my_playlist1", songs);
		assertTrue(p.getSongs().size() == 0);
	}

}
