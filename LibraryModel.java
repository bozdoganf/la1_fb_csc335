package la2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LibraryModel {
	
	// library
	private ArrayList<Album> albumsLib;
	private HashMap<String, Playlist> playlistLib;
	private ArrayList<Song> songsLib;
	private ArrayList<Song> favArr;
	 
	
	public LibraryModel() {
		albumsLib = new ArrayList<>();
		playlistLib = new HashMap<>();
		songsLib = new ArrayList<>();
		favArr = new ArrayList<>();
	}
	
	// SEARCH
	public ArrayList<Song> searchSongByTitle(String songTitle){
		
		ArrayList<Song> songsFoundByTitle = new ArrayList<>();
		
		// check the songs
		for (Song s : songsLib) {
			if (s.getSongTitle().equals(songTitle)) {
				songsFoundByTitle.add(new Song(s.getSongTitle(), s.getArtistName(), s.getAlbumTitle(), s.getSongRating(),s.getFavStatus()));
			}
		}		
		return songsFoundByTitle;
	}
	
	public ArrayList<Song> searchSongByArtist(String songArtist){
		
		ArrayList<Song> songsFoundByArtist = new ArrayList<>();
		
		// check the songs
		for (Song s : songsLib) {
			if (s.getArtistName().equals(songArtist)) {
				songsFoundByArtist.add(new Song(s.getSongTitle(), s.getArtistName(), s.getAlbumTitle(), s.getSongRating(),s.getFavStatus()));
			}
		}
		return songsFoundByArtist;
	}
	
	public ArrayList<Album> searchAlbumByTitle(String albumTitle){
		ArrayList<Album> albumsFoundByTitle = new ArrayList<>();
		for (Album a : albumsLib ) {
			if(albumTitle.equals(a.getTitle())) {albumsFoundByTitle.add(new Album(a.getTitle(), a.getArtist(), a.getGenre(), a.getYear(), a.getSongs()));}
		}
		
		return albumsFoundByTitle;
	}
	
	public ArrayList<Album> searchAlbumByArtist(String albumArtist){
		ArrayList<Album> albumsFoundByArtist = new ArrayList<>();
		for (Album a : albumsLib ) {
			if(albumArtist.equals(a.getArtist())) {albumsFoundByArtist.add(new Album(a.getTitle(), a.getArtist(), a.getGenre(), a.getYear(), a.getSongs()));}
		}		
		return albumsFoundByArtist;
	}
	
	public boolean songIsInLibrary(String songTitle, String songArtist, String albumName) {
		for (Song s : songsLib) {
			if (s.getSongTitle().equals(songTitle) && s.getArtistName().equals(songArtist) 
					&& s.getAlbumTitle().equals(albumName)) {
				return true;
			}
		}
		return false;
	}
	public boolean albumIsInLibrary(String albumName, String albumArtist) {
		for (Album a : albumsLib) {
			if (a.getTitle().equals(albumName) && a.getArtist().equals(albumArtist)) {
				return true;
			}
		}
		return false;
	}
	
	public void addSongAndAlbumHandler(String songName, String songArtist, String albumName, Album albumInMS) {
		Album albumInLib = this.findAlbum(albumName, songArtist);
		
		if (albumInLib == null) {
			this.addSongAndInitializeAlbum(songName, songArtist, albumName, albumInMS);
			return;
		}
		this.addSongAndHandleAlbum(songName, songArtist, albumName, albumInMS, albumInLib);
	}
	private Album findAlbum(String albumName, String artistName) {
		for (Album a : albumsLib) {
			if (a.getTitle().equals(albumName) && a.getArtist().equals(artistName)) {
				return a;
			}
		}
		return null;
	}
	
	private void addSongAndInitializeAlbum(String songName, String songArtist, String albumName, Album album) {
		Album albumCopy = new Album(album.getTitle(), album.getArtist(), album.getGenre(), album.getYear()); // copy without the songs
				
		albumCopy.addSong(songName, songArtist, albumName);
		
		Song songCopy = new Song(songName, songArtist, albumName);
		songsLib.add(songCopy);
		
		albumsLib.add(albumCopy);
	}
	
	private void addSongAndHandleAlbum(String songName, String songArtist, String albumName, Album albumMS, Album albumLib) {
		Song songCopy = new Song(songName, songArtist, albumName);

		songsLib.add(songCopy);
		
		if (albumLib.getSongs().size() < albumMS.getSongs().size()) {
			albumLib.addSong(songName, songArtist, albumName);
			return;
		}
	}
	
	public boolean addAlbumAndSongsHandler(String albumName, String albumArtist, Album albumInMS) {
		Album albumInLib = this.findAlbum(albumName, albumArtist);
		ArrayList<Song> songsToAdd = albumInMS.getSongs();
		
		
		if (albumInLib.getSongs().size() < songsToAdd.size()) {
			for (Song s : songsToAdd) {
				albumInLib.addSong(s.getSongTitle(), s.getArtistName(), s.getAlbumTitle());
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addAlbum(Album a) {
		Album albumDeepCopy = new Album(a.getTitle(), a.getArtist(), a.getGenre(), a.getYear(), a.getSongs());
		
		// add all the songs inside the album to the song list
		for (Song s : a.getSongs()) {
			songsLib.add(s); // check for encapsulation here
		}
		albumsLib.add(albumDeepCopy);
	}
	
	
	// PLAYLIST
	public void initializeAPlayList(String name) {
		playlistLib.put(name, new Playlist(name));
	}
	
	public boolean playlistIsInLibrary(String playlistName) {
		if (playlistLib.containsKey(playlistName)) {return true;}
		return false;
	}
	
	public boolean songIsInPlaylist(String songTitle, String songArtist, String albumName, String playlistName) {
		if (playlistLib.get(playlistName).containsSong(songTitle, songArtist, albumName)) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Song> getSongsFromPlaylist(String playlistName) {
		return playlistLib.get(playlistName).getSongs();
	}
	
	public void addToPlayList(String songTitle, String songArtist, String albumName, String playlistName) {
		playlistLib.get(playlistName).addSong(songTitle, songArtist, albumName);
	}
	
	public boolean removeFromPlaylist(String playlistName, String songTitle, String songArtist, String albumName) {
		return playlistLib.get(playlistName).removeSong(songTitle, songArtist, albumName);
	}
	
	public void rateTheSong(String songTitle, String artistName, String albumTitle, int rating) {
		Song s = this.findTheSongInLib(songTitle, artistName, albumTitle, rating);
		s.setRating(rating);
    	if (s.getFavStatus()) {this.addToFavArr(s);}
	}
	
	
	private Song findTheSongInLib(String songTitle, String artistName, String albumTitle, int rating) {		
		// check the songs
		for (Song s : songsLib) {
			if (s.getSongTitle().equals(songTitle) && s.getArtistName().equals(artistName)
					&& s.getAlbumTitle().equals(albumTitle)) {
				return s;
			}
		}
		return null;
	}
	
	private void addToFavArr(Song song) {
		favArr.add(song);
	}
	
	// GETTERS
	public ArrayList<String> getSongsLib() {
		// have a hash set
		ArrayList<String> res = new ArrayList<>();
		
		// go over everything and put them into a string format
		
		String songFormat;
		
		// check the songs
		for (Song s : songsLib) {
			songFormat = s.getSongTitle();
			res.add(songFormat);
		}
		return res;
	}
	
	public ArrayList<String> getArtistsLib() {
		ArrayList<String> res = new ArrayList<>();
		// go over everything and put them into a string format
		
		String songFormat;
		for (Album a : albumsLib) {
			ArrayList<Song> albumSongs = a.getSongs();
			for (Song s : albumSongs) {
				songFormat = s.getArtistName();
				res.add(songFormat);
			}
		}
		return res;
	}
	
	public ArrayList<String> getAlbumsLib() {
		ArrayList<String> res = new ArrayList<>();
		// go over everything and put them into a string format
		
		String songFormat;
		for (Album a : albumsLib) {
			ArrayList<Song> albumSongs = a.getSongs();
			for (Song s : albumSongs) {
				songFormat = s.getAlbumTitle();
				res.add(songFormat);
			}
		}
		return res;
	}
	
	public ArrayList<String> getPlaylists() {
		ArrayList<String> res = new ArrayList<>();
		for (String key : playlistLib.keySet()) {
		   res.add(playlistLib.get(key).getName());
		}
		return res;
	}
	
	public ArrayList<String> getFavArr() {
		ArrayList<String> res = new ArrayList<>();
		for (Song s : favArr) {
			res.add(s.getSongTitle());
		}
		return res;
	}
}

