package la1_fbbe;

import java.util.ArrayList;
import java.util.HashSet;

public class LibraryModel {
	
	// library
	private static ArrayList<Album> albumsLib;
	private static ArrayList<PlayList> playListLib;
	private static ArrayList<Song> songLib;
	
	public LibraryModel() {
		albumsLib = new ArrayList<>();
		playListLib = new ArrayList<>();
		songLib = new ArrayList<>();
	}

	public void initializeAPlayList(String name) {
		playListLib.add(new PlayList(name));
		System.out.println("You need to search the song in the database to before you add to the playlist");
	}
	
	public void addSong(Song s) {
		songLib.add(s);
	}
	

	public void addAlbum(Album a) {
		albumsLib.add(a);
	}
	
	public PlayList findPlaylist(String name) {
		for (PlayList p : playListLib) {
			if (p.getName().equals(name)) {
				return p;
			}
		}
		return null;
	}
	
	public void addToPlayList(Song s, PlayList p) {
		p.addSong(s);
	}
	
	
	public ArrayList<Album> searchAlbumByTitleLib(String albumTitle){
		ArrayList<Boolean> found  =  new ArrayList<>();
		found.add(false);
		
		ArrayList<Album> albumSearched1 = new ArrayList<>();

		
		for (Album a : albumsLib ) {
			// call the helper search method
			if(albumTitle.equals(a.getTitle())) {
				albumSearched1.add(a);
				System.out.println(a.getTitle());
				System.out.println(a.getArtist());
				System.out.println(a.getGenre());
				System.out.println(a.getYear());
				a.getAlbumSongs();
				found.remove(false);
				found.add(true);
			}
			
		}
		if(!(found.get(0))){
			System.out.println("The search not found in your album :(");
		}
		return albumSearched1;

	}
	
	// Search Album by Artist name
	
	public ArrayList<Album> searchAlbumByArtist(String albumArtist){
		ArrayList<Boolean> found  =  new ArrayList<>();
		found.add(false);
		
		ArrayList<Album> albumSearched1 = new ArrayList<>();

		
		for (Album a : albumsLib ) {
			// call the helper search method
			if(albumArtist.equals(a.getArtist())) {
				albumSearched1.add(a);
				System.out.println(a.getTitle());
				System.out.println(a.getArtist());
				System.out.println(a.getGenre());
				System.out.println(a.getYear());
				a.getAlbumSongs();
				found.remove(false);
				found.add(true);
			}
			
		}
		if(!(found.get(0))){
			System.out.println("The search not found in your album :(");
		}
		return albumSearched1;

	}
	
	// Search Album by Artist name
	
	public HashSet<Song> searchSongByArtistLib(String songArtist){
		ArrayList<Boolean> found  =  new ArrayList<>();
		found.add(false);
		
		HashSet<Song> songsSearched1 = new HashSet<>();

		
		// albums array
		for (Album a : albumsLib ) {
			a.searchSongByArtist(songArtist, found, songsSearched1);
					
		}
		
		// song array
		for (Song s : songLib ) {
			// call the helper search method
			if(songArtist.equals(s.getArtistName())) {
				songsSearched1.add(s);
				System.out.println(s.getSongTitle());
				System.out.println(s.getArtistName());
				System.out.println(s.getAlbumTitle());
				if (found.contains(false))found.remove(false);
				found.add(true);
			}
		}
		
		// playlist array
		for (PlayList p : playListLib) {
			p.searchSongByArtist(songArtist, found, songsSearched1);
		}
		
		
		if(!(found.get(0))){
			System.out.println("The search not found in your album :(");
		}
		return songsSearched1;
	}
	
	public HashSet<Song> searchSongByTitleLib(String songTitle){
		ArrayList<Boolean> found  =  new ArrayList<>();
		found.add(false);
		
		HashSet<Song> songsSearched1 = new HashSet<>();

		
		// albums array
		for (Album a : albumsLib ) {
			a.searchSongByTitle(songTitle, found, songsSearched1);
					
		}
		
		// song array
		for (Song s : songLib ) {
			// call the helper search method
			if(songTitle.equals(s.getSongTitle())) {
				songsSearched1.add(s);
				System.out.println(s.getSongTitle());
				System.out.println(s.getArtistName());
				System.out.println(s.getAlbumTitle());
				if (found.contains(false))found.remove(false);
				found.add(true);
			}
		}
		
		// playlist array
		for (PlayList p : playListLib) {
			p.searchSongByTitle(songTitle, found, songsSearched1);
		}
		
		
		if(!(found.get(0))){
			System.out.println("The search not found in your album :(");
		}
		return songsSearched1;
	}
	
	public void searchPlaylistByNameLib(String name) {
		for (PlayList p : playListLib) {
			if (p.getName().equals(name)) {
				p.printPlaylist();
			}
		}
	}
	
	
	private Song findTheSongLM(String songTitle, String artistName, String albumTitle) {
		Song res = null;
    	for (Song s : songLib) {
    		if (s.getSongTitle().equals(songTitle) && s.getArtistName().equals(artistName) 
    				&& s.getAlbumTitle().equals(albumTitle)) {
    			return s;
    		}
    	}
    	
    	for (Album a : albumsLib) {
    		res = a.findSong(songTitle, artistName, albumTitle);
    	}
    	
    	for (PlayList p : playListLib) {
    		res = p.findSong(songTitle, artistName, albumTitle);
    	}
    	
		return res;
	}
	
	public void rateTheSong(String songTitle, String artistName, String albumTitle, Rating rating) {
		Song s = this.findTheSongLM(songTitle, artistName, albumTitle);
		// set the song rating
		s.setRating(rating);
		System.out.println(s.getSongRating());
		System.out.println(s.getFavStatus());
	}
	
	
	// testing methods to print sing list and album list
	
	public void getSongsLib() {
		// have a hash set
		
	}
	
	public ArrayList<Album> getAlbumsLib() {
		return albumsLib;
	}
	
	public ArrayList<PlayList> getPlayListLib() {
		return playListLib;
	}
	
	
}
