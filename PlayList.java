package la1_fbbe;

import java.util.ArrayList;

public class PlayList {
	private ArrayList<Song> songs;
	private String name;
	
	public PlayList(String name) {
		this.name = name;
		songs = new ArrayList<>();
	}
	
	// add / remove songs from the playlist
	
	public String getName() {
		return name;
	}
	
	
	public void addSong(Song song) {
		songs.add(song);
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
	
	public void removeSong(String title, String artist, String albumName) {
		Song s = this.findSong(title, artist, albumName);
		songs.remove(s);
	}
	public boolean isEmpty() {
		if (songs.size() == 0) {
			return true;
		}
		return false;
	}
	
	public ArrayList<Song> getSongs() {
		return songs;
	}
}