package la1_fbbe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MusicStore {
	
	private static ArrayList<Album> albums = new ArrayList<>();
	
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
				Song song = new Song(songTitle, album.getArtist(), album.getTitle());
				album.buildAlbum(song);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
