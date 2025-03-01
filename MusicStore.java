package la1_fbbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MusicStore {
	
	private static ArrayList<Album> albums;
	
	public MusicStore() {
		albums = new ArrayList<>();
	}
	
	public void configureMS() {
					
			//go over each file
			File dir = new File("/Users/fatihbozdogan/Desktop/CS/CSC335/la_1_csc335/la1_fbbe/src");
		    File[] filesArr = dir.listFiles();
		    
		    
		    for (File f : filesArr) {
		    	if (!f.getName().equals("albums.txt")) {
		    		if (f.getName().contains(".txt")) {
		    			processFile(f);
		    		}
		    		
		    	}
		    }
	}
	private static void processFile(File f) {
		try {
			Scanner scanner = new Scanner(f);

			Album album;
			String line = scanner.nextLine();
			String[] lineArr = line.strip().split(",");
			String albumTitle = lineArr[0];
			String artistName = lineArr[1];
			String genre = lineArr[2];
			String year = lineArr[3];
			
			album = new Album(albumTitle, artistName, genre, year);
		
			albums.add(album);
			
			while(scanner.hasNext()) {
				line = scanner.nextLine();
				String songTitle = line.strip();
				Song song = new Song(songTitle.strip(), album.getArtist(), album.getTitle());
				album.buildAlbum(song);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}	
	///////////////// Search Song by Song title /////////////////
	
	public ArrayList<Song> searchSongByTitle(String songTitle){
		ArrayList<Boolean> found = new ArrayList<>();
		found.add(false);
		
		ArrayList<Song> songsSearched1 = new ArrayList<>();
		
		for (Album a : albums ) {
			// call the helper search method
			a.searchSongByTitle(songTitle, found, songsSearched1);
		}
		if (!(found.get(0))) {
			System.out.println("The search not found in our database :(");
		}
		return songsSearched1;
	}
	
	///////////////// Search Song by Artist name /////////////////
	
	public ArrayList<Song> searchSongByArtist(String artist){
		
		
		ArrayList<Boolean> found = new ArrayList<>();
		found.add(false);
		
		ArrayList<Song> songsSearched2 = new ArrayList<>();
		
		
		for (Album a : albums ) {
			// call the helper search method
			a.searchSongByArtist(artist, found, songsSearched2);
			
		}
		if (!(found.get(0))) {
			System.out.println("The search not found in our database :(");
		}
		return songsSearched2;
	}
	
	
	///////////////// Search Album by Album title /////////////////
	
	public ArrayList<Album> searchAlbumByTitle(String albumTitle){
		ArrayList<Boolean> found  =  new ArrayList<>();
		found.add(false);
		
		ArrayList<Album> albumSearched1 = new ArrayList<>();

		
		for (Album a : albums ) {
			// call the helper search method
			if(albumTitle.equals(a.getTitle())) {
				albumSearched1.add(a);

				System.out.println(a.getTitle());
				System.out.println(a.getArtist());
				System.out.println(a.getGenre());
				System.out.println(a.getYear());
				
				
				
				if (found.contains(false))found.remove(false);
				found.add(true);
			}
			
		}
		if(!(found.get(0))){
			System.out.println("The search not found in our database :(");
		}
		return albumSearched1;

	}
	
	///////////////// Search Album by Artist name /////////////////
	
	public ArrayList<Album> searchAlbumByArtist(String albumArtist){
		ArrayList<Boolean> found  =  new ArrayList<>();
		found.add(false);
		
		ArrayList<Album> albumSearched2 = new ArrayList<>();

		
		for (Album a : albums ) {
			// call the helper search method
			if(albumArtist.equals(a.getArtist())) {
				
				albumSearched2.add(a);
				System.out.println(a.getTitle());
				System.out.println(a.getArtist());
				System.out.println(a.getGenre());
				System.out.println(a.getYear());
				
				if (found.contains(false))found.remove(false);
				found.add(true);
				
				a.printAllSongs();
			}
		}
		
		if(!(found.get(0))){
			System.out.println("The search not found in our database :(");
		}
		
		return albumSearched2;
				
	}
	
}
