//package la1_fbbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MusicStore {
	
	private static ArrayList<Album> albums = new ArrayList<>();
	
	public void configureMS() {
					
			//go over each file
			File dir = new File("/Users/behruzernazarov/eclipse-workspace/Music/src");
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
				Song song = new Song(songTitle, album.getArtist(), album.getTitle());
				album.buildAlbum(song);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	///////////////// Search Song by Song title /////////////////
	
	public void searchSongByTitle(String songTitle){
		ArrayList<Boolean> found = new ArrayList<>();
		found.add(false);
		for (Album a : albums ) {
			// call the helper search method
			a.searchSongByTitle(songTitle, found);
		}
		if (!(found.get(0))) {
			System.out.println("The search not found in our database :(");
		}

	}
	
	///////////////// Search Song by Artist name /////////////////
	
	public void searchSongByArtist(String artist){
		ArrayList<Boolean> found = new ArrayList<>();
		found.add(false);
		for (Album a : albums ) {
			// call the helper search method
			a.searchSongByArtist(artist, found);
			
		}
		if (!(found.get(0))) {
			System.out.println("The search not found in our database :(");
		}
	}
	
	
	///////////////// Search Album by Album title /////////////////
	
	public void searchAlbumByTitle(String albumTitle){
		ArrayList<Boolean> found  =  new ArrayList<>();
		found.add(false);
		for (Album a : albums ) {
			// call the helper search method
			if(albumTitle.equals(a.getTitle())) {
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

	}
	
	///////////////// Search Album by Artist name /////////////////
	
	public void searchAlbumByArtist(String albumArtist){
		ArrayList<Boolean> found  =  new ArrayList<>();
		found.add(false);
		for (Album a : albums ) {
			// call the helper search method
			if(albumArtist.equals(a.getArtist())) {
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
				
	}
	
}
















