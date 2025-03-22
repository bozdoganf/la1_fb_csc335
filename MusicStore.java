package la2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MusicStore {
	
	private ArrayList<Album> albums;
	
	public MusicStore() {
		albums = new ArrayList<>();
	}
	
	
	public void configureMS(String filePath) {
		
		File dir = new File(filePath);
	    File[] filesArr = dir.listFiles();
	    
	    
	    // go over each file in the list of files we have in the directory
	    for (File f : filesArr) {
	    	if (!f.getName().equals("albums.txt")) {
	    		if (f.getName().contains(".txt")) {
	    			// 
	    			try {
						this.processFile(f);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
	    		}
	    	}
	    }
	}
	private void processFile(File f) throws FileNotFoundException {
			
			Scanner scanner = new Scanner(f);
			
			
			// create an album class and fill its info with the first line of each file
			Album album;
			String line = scanner.nextLine();
			String[] lineArr = line.strip().split(",");
			String albumTitle = lineArr[0];
			String artistName = lineArr[1];
			String genre = lineArr[2];
			String year = lineArr[3];
			
			album = new Album(albumTitle, artistName, genre, year);
		
			// add the album to our database
			albums.add(album);
			
			
			// go over all the lines after the first one, build song objects with them and add them to the album
			while(scanner.hasNext()) {
				
				line = scanner.nextLine();
				
				String songTitle = line.strip();
								
				album.addSong(songTitle, album.getArtist(), album.getTitle());
			}
	}		
	
	// SEARCH
	public ArrayList<Song> searchSongByTitle(String songTitle){
		
		ArrayList<Song> songsFoundByTitle = new ArrayList<>();
		
		for (Album a : albums ) {
			// this finds all the songs with that title in that album and returns a deep copy of themn
			ArrayList<Song> songsFoundCopy = a.findSongsByTitle(songTitle);
			// now go over all the songs found in that album with that title and add them to the list
			for (Song s : songsFoundCopy) {
				songsFoundByTitle.add(s);
			}
		}
		return songsFoundByTitle;
	}
	
	public ArrayList<Song> searchSongByArtist(String songArtist){
		
		ArrayList<Song> songsFoundByArtist = new ArrayList<>();
		
		for (Album a : albums ) {
			if (songArtist.equals(a.getArtist())) {
				ArrayList<Song> songsToAdd = a.getSongs();
				for (Song s : songsToAdd) {
					songsFoundByArtist.add(s);
				}
			}
		}
		return songsFoundByArtist;
	}
	
	public ArrayList<Album> searchAlbumByTitle(String albumTitle){
		ArrayList<Album> albumsFoundByTitle = new ArrayList<>();
		for (Album a : albums ) {
			if(albumTitle.equals(a.getTitle())) {albumsFoundByTitle.add(a);}
		}		
		return this.deepCopyAlbum(albumsFoundByTitle);
	}
	
	public ArrayList<Album> searchAlbumByArtist(String albumArtist){
		ArrayList<Album> albumsFoundByArtist = new ArrayList<>();
		for (Album a : albums ) {
			if(albumArtist.equals(a.getArtist())) {albumsFoundByArtist.add(a);}
		}		
		return this.deepCopyAlbum(albumsFoundByArtist);
	}
	
	private ArrayList<Album> deepCopyAlbum(ArrayList<Album> albumsFoundByOriginal) {
		ArrayList<Album> albumsFoundByDeepCopy = new ArrayList<>();
		
		
		for (Album a : albumsFoundByOriginal) {
			Album aCopy = new Album(a.getTitle(), a.getArtist(), a.getGenre(), a.getYear(), a.getSongs());
			albumsFoundByDeepCopy.add(aCopy);
		}
		return albumsFoundByDeepCopy;
	}
	
	public boolean songIsInMS(String songTitle, String songArtist, String albumItBelongs) {
		// go over the albums
		for (Album a : albums) {
			ArrayList<Song> songsInAlbum = a.getSongs();
			for (Song s : songsInAlbum) {
				if (s.getSongTitle().equals(songTitle) && s.getArtistName().equals(songArtist) && s.getAlbumTitle().equals(albumItBelongs)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean albumIsInMS(String albumName, String albumArtist) {
		// go over the albums
		for (Album a : albums) {
			if (a.getTitle().equals(albumName) && a.getArtist().equals(albumArtist)) {
				return true;
			}
		}
		return false;
	}
	
	public Album findAlbum(String albumName, String artistName) {
		for (Album a : albums) {
			if (a.getTitle().equals(albumName) && a.getArtist().equals(artistName)) {
				return a;
			}
		}
		return null;
	}
	
	
}

