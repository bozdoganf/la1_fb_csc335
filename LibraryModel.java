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
		if (songLib.contains(s)) {
			System.out.println("Song is already in the library.");
			System.out.println("Add another song. Don't forget to search first!");
			return;
		}
    	System.out.println("Song succesfully added to the library.");
    	System.out.println("If you want to add a song again, search it first!");
		songLib.add(s);
	}
	

	public void addAlbum(Album a) {
		if (albumsLib.contains(a)) {
			System.out.println("Album is alredy in the library");
			System.out.println("Add another song. Don't forget to search first!");
			return;
		}
    	System.out.println("Album succesfully added to the library.");
    	System.out.println("If you want to add a song again, search it first!");
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
		if (p.findSong(s.getSongTitle(), s.getArtistName(), s.getAlbumTitle()) != null) {
			System.out.println("The song is already in the playlist");
			System.out.println("Add another song. Don't forget to search first!");
			return;
		}
    	System.out.println("Song succesfully added to the playlist.");
    	System.out.println("If you want to add a song again, search it first!");
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
		System.out.println("The song's rating has been set at " + s.getSongRating());
	}
	
	
	public void getSongsLib() {
		// have a hash set
		HashSet<Song> res = new HashSet<Song>();

		for (Album a : albumsLib) {
			a.retrieveAlbumSongs(res);
		}
		// go over the songs
		for (Song s : songLib) {
			res.add(s);
		}
		// go over the Playlists
		for (PlayList p : playListLib) {
			p.retrievePlayListSongs(res);
		}
		
		for (Song s : res) {
			System.out.println(s.getSongTitle());
		}		
	}
	
	public HashSet<Song> getUniqueSongs() {
		// have a hash set
		HashSet<Song> res = new HashSet<Song>();

		for (Album a : albumsLib) {
			a.retrieveAlbumSongs(res);
		}
		// go over the songs
		for (Song s : songLib) {
			res.add(s);
		}
		// go over the Playlists
		for (PlayList p : playListLib) {
			p.retrievePlayListSongs(res);
		}
			
		return res;
	}
	
	public void getArtistsLib() {
		HashSet<Song> songsMap = this.getUniqueSongs();
		HashSet<String> artistMap = new HashSet<>();
		
		for (Song s : songsMap) {
			artistMap.add(s.getArtistName().strip());
		}
		
		for (String artistName : artistMap) {
			System.out.println(artistName);
		}
	}
	
	// to get all the albums, go over all the unique songs
	// get their albums into a hashset
	// print them
	public void getAlbumsLib() {
		HashSet<Song> songsMap = this.getUniqueSongs();
		HashSet<String> albumsMap = new HashSet<>();
		
		for (Song s : songsMap) {
			albumsMap.add(s.getAlbumTitle());
		}
		
		for (String albumName : albumsMap) {
			System.out.println(albumName);
		}
		
	}
	
	
}
