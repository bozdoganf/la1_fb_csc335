package la2;

import java.util.ArrayList;
import java.util.HashSet;

public class Playlist {
	private ArrayList<Song> songs;
	private String name;
	
	public Playlist(String name) {
		this.name = name;
		songs = new ArrayList<>();
	}
	
	// copy constructor
	public Playlist(String name, ArrayList<Song> songs) {
		this.name = name;
		this.songs = songs;
	}
	
	
	public void addSong(String songTitle, String songArtist, String albumName) {
		songs.add(new Song(songTitle, songArtist, albumName));
	}
	
	public boolean removeSong(String title, String artist, String albumName) {
		Song s = this.findSong(title, artist, albumName);
		return songs.remove(s);
	}
	
	public Song findSong(String title, String artist, String albumName) {
		// remove the song only
		for (Song s : songs) {
			if (s.getSongTitle().equals(title) && s.getArtistName().equals(artist) 
					&& s.getAlbumTitle().equals(albumName)) {
				return s;
			}
		}
		return null;
	}
	
	/*public boolean PlaylistIsEmpty() {
		return songs.isEmpty();
	}*/
	
	public boolean containsSong(String songTitle, String songArtist, String albumName) {
		for (Song s : songs) {
			if (s.getSongTitle().equals(songTitle) && s.getArtistName().equals(songArtist) 
					&& s.getAlbumTitle().equals(albumName)) {
				return true;
			}
		}
		return false;
	}

	
	
	// GETTERS
	public ArrayList<Song> getSongs() {
		ArrayList<Song> songsCopy = new ArrayList<>();
		
		for (Song s : songs) {
			Song sCopy = new Song(s.getSongTitle(), s.getArtistName(), s.getAlbumTitle(), s.getSongRating(), s.getFavStatus());
			songsCopy.add(sCopy);
		}
		return songsCopy;
	}
		
	public String getName() {
		return name;
	}
	
}
