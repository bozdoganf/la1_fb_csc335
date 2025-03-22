package la2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class MusicStoreTest {

	@Test
	void testSearchAlbumByArtist() {
		MusicStore ms = new MusicStore();
		ms.configureMS("/Users/fatihbozdogan/Desktop/CS/CSC335/las/la2/src");
		ArrayList<Album> albumsTest = ms.searchAlbumByArtist("Adele");
		ArrayList<String> correctTitles = new ArrayList<>();
		correctTitles.add("19");
		correctTitles.add("21");
		for (Album a : albumsTest) {
			assertTrue(correctTitles.contains(a.getTitle()));
		}
	}

	@Test
	void testSearchAlbumByTitle() {
		MusicStore ms = new MusicStore();
		ms.configureMS("/Users/fatihbozdogan/Desktop/CS/CSC335/las/la2/src");
		ArrayList<Album> albumsTest = ms.searchAlbumByTitle("19");
		for (Album a : albumsTest) {
			assertTrue(a.getTitle().equals("19"));
		}
	}
	
	@Test
	void testSearchSongByTitle() {
		MusicStore ms = new MusicStore();
		ms.configureMS("/Users/fatihbozdogan/Desktop/CS/CSC335/las/la2/src");
		ArrayList<Song> songsTest = ms.searchSongByTitle("Tired");
		for (Song s : songsTest) {
			assertTrue(s.getSongTitle().equals("Tired"));
		}
	}
	
	@Test
	void testSearchSongByArtist() {
		MusicStore ms = new MusicStore();
		ms.configureMS("/Users/fatihbozdogan/Desktop/CS/CSC335/las/la2/src");
		ArrayList<Song> songsTest = ms.searchSongByArtist("Adele");
		assertEquals(songsTest.size(), 24);
		for (Song s : songsTest) {
			assertTrue(s.getArtistName().equals("Adele"));
		}
	}
	
	@Test
	void songIsInMS() {
		MusicStore mS = new MusicStore();
		mS.configureMS("/Users/fatihbozdogan/Desktop/CS/CSC335/las/la2/src");
		mS.songIsInMS("Lullaby", "OneRepublic", "Waking Up");
	}
	
	@Test
	void albumIsInMS() {
		MusicStore mS = new MusicStore();
		mS.configureMS("/Users/fatihbozdogan/Desktop/CS/CSC335/las/la2/src");
		mS.albumIsInMS("19", "Adele");
	}
	
	@Test
	void findAlbum() {
		MusicStore mS = new MusicStore();
		mS.configureMS("/Users/fatihbozdogan/Desktop/CS/CSC335/las/la2/src");
		mS.findAlbum("19", "Adele");
		mS.findAlbum("my album", "Fatih");
	}
	
	
	
}
