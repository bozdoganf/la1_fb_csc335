package la2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class LibraryModelTest {

	@Test
	void testAddSongAndAddAlbum() {
		LibraryModel lM = new LibraryModel();
		MusicStore mS = new MusicStore();
		mS.configureMS("/Users/fatihbozdogan/Desktop/CS/CSC335/las/la2/src");
		
		lM.addSongAndAlbumHandler("Lullaby", "OneRepublic", "Waking Up", mS.findAlbum("Waking Up", "OneRepublic"));
		
		lM.songIsInLibrary("Lullaby", "OneRepublic", "Waking Up");
		
		lM.searchSongByTitle("Lullaby");
		lM.searchSongByArtist("One Republic");
		
		lM.addAlbum(mS.findAlbum("Old Ideas", "Leonard Cohen"));
		lM.addAlbumAndSongsHandler("Waking Up", "OneRepublic", mS.findAlbum("Waking Up", "OneRepublic"));
		
		lM.albumIsInLibrary("Old Ideas", "Leonard Cohen");
		
		lM.searchAlbumByTitle("Waking Up");
		lM.searchAlbumByArtist("OneRepublic");
		
		assertTrue(lM.getSongsLib().size() == (mS.findAlbum("Old Ideas", "Leonard Cohen").getSongs().size() + 1));
	}
	
	@Test
	void testPlaylist() {
		LibraryModel lM = new LibraryModel();
		MusicStore mS = new MusicStore();
		mS.configureMS("/Users/fatihbozdogan/Desktop/CS/CSC335/las/la2/src");
		
		lM.addSongAndAlbumHandler("Lullaby", "OneRepublic", "Waking Up", mS.findAlbum("Waking Up", "OneRepublic"));
		
		lM.playlistIsInLibrary("my_playlist");
		lM.initializeAPlayList("my_playlist");
		lM.playlistIsInLibrary("my_playlist");
		
				
		lM.addToPlayList("Lullaby", "OneRepublic", "Waking Up", "my_playlist");
		lM.songIsInPlaylist("Lullaby", "OneRepublic", "Waking Up", "my_playlist");
		
		lM.removeFromPlaylist("my_playlist", "Lullaby", "OneRepublic", "Waking Up");
		ArrayList<Song> songsFromPlaylist = lM.getSongsFromPlaylist("my_playlist");
		assertTrue(songsFromPlaylist.size() == 0);
		
		assertTrue(lM.playlistIsInLibrary("my_playlist"));
		
		lM.getPlaylists();
	}
	
	@Test
	void testGetters() {
		LibraryModel lM = new LibraryModel();
		MusicStore mS = new MusicStore();
		mS.configureMS("/Users/fatihbozdogan/Desktop/CS/CSC335/las/la2/src");
		
		
		lM.addSongAndAlbumHandler("Lullaby", "OneRepublic", "Waking Up", mS.findAlbum("Waking Up", "OneRepublic"));
		lM.addSongAndAlbumHandler("Lullaby", "Leonard Cohen", "Old Ideas", mS.findAlbum("Old Ideas", "Leonard Cohen"));
		
		lM.getAlbumsLib();
		lM.getArtistsLib();
		
		lM.rateTheSong("Lullaby", "OneRepublic", "Waking Up", 5);
		
		ArrayList<String> favArr = lM.getFavArr();
		assertTrue(favArr.size() == 1);	
		
		lM.getSongsLib();
	}
	
	@Test
	void testAddSongEdgeCase() {
		LibraryModel lM = new LibraryModel();
		MusicStore mS = new MusicStore();
		mS.configureMS("/Users/fatihbozdogan/Desktop/CS/CSC335/las/la2/src");
		
		lM.addSongAndAlbumHandler("Tired", "Adele", "19", mS.findAlbum("19", "Adele"));
		lM.addSongAndAlbumHandler("Hometown Glory", "Adele", "19", mS.findAlbum("Hometown Glory", "Adele"));


		
	}

}
