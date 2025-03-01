// package la1_fbbe;

import java.util.ArrayList;
import java.util.HashSet;

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
	
	public void searchSongByArtist(String artist, ArrayList<Boolean> found, HashSet<Song> songsSearched2) {
		
		for(Song song: songs) {
			if(artist.equals(song.getArtistName())) {
				songsSearched2.add(song);
				System.out.println(song.getSongTitle());
				System.out.println(song.getArtistName());
				System.out.println(song.getAlbumTitle());
				if (found.contains(false))found.remove(false);
				found.add(true);
			}
		}
	}
	
	public void searchSongByTitle(String title, ArrayList<Boolean> found, HashSet<Song> songsSearched2) {
		
		for(Song song: songs) {
			if(title.equals(song.getSongTitle())) {
				songsSearched2.add(song);
				System.out.println(song.getSongTitle());
				System.out.println(song.getArtistName());
				System.out.println(song.getAlbumTitle());
				if (found.contains(false))found.remove(false);
				found.add(true);
			}
		}
	}
	
	public void printPlaylist() {
		for (Song s : songs) {
			System.out.println("Song name " + s.getSongTitle());
			System.out.println("Song artist: " + s.getArtistName());
		}
	}
	
	
	public void retrievePlayListSongs(HashSet<Song> res) {
		for (Song s : songs ) {
			res.add(s);
		}
	}
	
}