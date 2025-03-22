package la2;

import java.util.ArrayList;
import java.util.HashSet;


public class Album {
	
	private String title;
	private String artistName;
	private String genre;
	private String year;
	private ArrayList<Song> songs;
	
	
	public Album(String title, String artistName, String genre, String year) {
		this.title = title;
		this.artistName = artistName;
		this.genre = genre;
		this.year = year;
		songs = new ArrayList<>();
	}
	
	// deep copy constructor; this is to copy everything about the album
	public Album(String title, String artistName, String genre, String year, ArrayList<Song> songs) {
		this.title = title;
		this.artistName = artistName;
		this.genre = genre;
		this.year = year;
		this.songs = songs;
	}
	

	
	public String getTitle() { return title;}
	public String getArtist() { return artistName;}
	public String getGenre() { return genre;}
	public String getYear() { return year;}
	
	
	public void addSong(String songTitle, String songArtist, String albumName) {
		
		if (!(this.songIsInAlbum(songTitle, songArtist, albumName))) {
			songs.add(new Song(songTitle, songArtist, albumName));
		}
		
	}
	
	// this returns the song list with a deep copy
	public ArrayList<Song> getSongs() {
		ArrayList<Song> songsCopy = new ArrayList<>();
		
		for (Song s : songs) {
			Song sCopy = new Song(s.getSongTitle(), s.getArtistName(), s.getAlbumTitle(), s.getSongRating(), s.getFavStatus());
			songsCopy.add(sCopy);
		}
		return songsCopy;
	}
	
	private boolean songIsInAlbum(String songTitle, String songArtist, String albumName) {
		for (Song s : songs) {
			if (s.getSongTitle().equals(songTitle) && s.getArtistName().equals(songArtist) && s.getAlbumTitle().equals(albumName)) {
				return true;
			}
		}
		return false;
	}
	
	
	// this finds the songs by the given titles in the album and returns a deep copy of them
	public ArrayList<Song> findSongsByTitle(String songTitle) {
		ArrayList<Song> songsFoundByTitleDeepCopy = new ArrayList<>();
		
		for(Song s : songs) {
			if(songTitle.equals(s.getSongTitle())) {
				Song sCopy = new Song(s.getSongTitle(), s.getArtistName(), s.getAlbumTitle(), s.getSongRating(), s.getFavStatus());
				songsFoundByTitleDeepCopy.add(sCopy);
			}
		}
		return songsFoundByTitleDeepCopy;
	}	
}
