package la1_fbbe;

import java.util.ArrayList;

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
			System.out.println("The search not found in our database :(");
		}
		return albumSearched1;

	}
	
	
	
	// testing methods to print sing list and album list
	
	public ArrayList<Song> getSongsLib() {
		return songLib;
	}
	
	public ArrayList<Album> getAlbumsLib() {
		return albumsLib;
	}
	
	public ArrayList<PlayList> getPlayListLib() {
		return playListLib;
	}
	
	
}
