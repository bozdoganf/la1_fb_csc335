
import java.util.ArrayList;
import java.util.Scanner;

public class TheView {
	public static void main(String[] args) {
		musicesOptimus(args);
		
		// run the program in the terminal
		
	}
	
	
	public static void musicesOptimus(String[] args) {
		// you started the program
		
		System.out.println(""
				+ "Welcome to Musices Optimus! To use this program please follow the instructions strictly.\n"
				+ "This program follows the design by contract methodology, so if you don't follow instructions\n"
				+ "and your program doesn't run, it's on you.\n"
				+ "Instructions:\n"
				+ "search_song_title [title of the song you want to search]\n"
				+ "search_song_artist [name of the artist you want to search]\n"
				+ "search_album_title [title of the album you want to search]\n"
				+ "search_album_artist [artist of the album you want to search]\n"
				+ "new_playlist [name of the playlist you want to create]\n"
				+ "Please note that if you want to add to a song to a playlist, you need to search it first.\n"
				+ "So afte you search, you either one of these or multiple: \n"
				+ "add_Playlist [name of the song / artist / album] [name of the playlist you want to add the song to]\n"
				+ "remove_Playlist [name of the song / artist / album you want to remove from] [name of the play you want to remove from\n"
				+ "add_Song [name of the song / artist / album  you want to add to your library] \n"
				+ "remove_Song [name of the song / artist / album you want to remove from your library]\n"
				+ "add_Album [name of the album / artist / album you want to add to your library]\n"
				+ "remove_Album [name of the album / artist / album] you want to remove from your library\n"
				+ "rate [name of the song / artist / album] you want to rate in your library\n"
				+ "EXIT [exits the program]"
				+ "");
		 
		
		// initiate all the objects
		MusicStore mS = new MusicStore();
		mS.configureMS();
		LibraryModel lM = new LibraryModel();
		
		
		
		// ai generated
        Scanner scanner = new Scanner(System.in);        
        
        boolean programState = true;
        System.out.println("Input:");
        
        
        while (programState) {
            String command = scanner.nextLine().strip();
            
            if (command.equals("EXIT")) break;
            
            if (command.contains("new_playlist")) {
            	// ask what the name is 
            	System.out.println("What's the name of the playlist?");
            	String name = scanner.nextLine().strip();
            	lM.initializeAPlayList(name);
            	continue;
            }
            
            if (command.contains("search_song_title")) {
            	System.out.println("What's the name of the song?");
            	String songTitle1 = scanner.nextLine().strip();
            	ArrayList<Song> songsSearched1 = mS.searchSongByTitle(songTitle1);

            	String command2 = scanner.nextLine().strip();
            	if (command2.contains("add_Song")); addSongHelper(scanner, songsSearched1, lM, command2);
            	if (command2.contains("add_Playlist")); addPlaylistHelper(scanner, songsSearched1, lM, command2);
            }
            
            if (command.contains("search_song_artist")) {
            	System.out.println("What's the artist of the song?");
            	String songArtist1 = scanner.nextLine().strip();
            	ArrayList<Song> songsSearched2 = mS.searchSongByArtist(songArtist1);
            	
            	String command3 = scanner.nextLine().strip();
            	if (command3.contains("add_Song")); addSongHelper(scanner, songsSearched2, lM, command3);
            	if (command3.contains("add_Playlist")); addPlaylistHelper(scanner, songsSearched2, lM, command3);
            	
            }
            
            if (command.contains("search_album_title")) {
            	System.out.println("What's the name of the album?");
            	String albumName1 = scanner.nextLine().strip();
            	ArrayList<Album> albumsSearched1 = mS.searchAlbumByTitle(albumName1);
            	
            	addAlbumHelper(scanner, albumsSearched1, lM);
            	
            }
            
            if (command.contains("search_album_artist")) {
            	System.out.println("What's the name of the album artist?");
            	String albumArtist1 = scanner.nextLine().strip();
            	ArrayList<Album> albumsSearched2 = mS.searchAlbumByArtist(albumArtist1);
            	
            	addAlbumHelper(scanner, albumsSearched2, lM);
            }
            
            if (command.contains("remove_Playlist")) {
            	System.out.println("What's the name of the playlist you want to remove songs from?");
            	String playListName2 = scanner.nextLine().strip();
            	PlayList playList2 = lM.findPlaylist(playListName2);
            	
            	// find out what song the user wants to add
            	System.out.println("What song do you want to remove from this play list");
            	String songToAddName2 = scanner.nextLine().strip();
            	
            	System.out.println("Who is the artist of this song you want to remove?");
            	String songToAddArtist2 = scanner.nextLine().strip();

            	System.out.println("What album does this song you want to remove belong to?");
            	String songToAddAlbum2 = scanner.nextLine().strip();
            	            	
            	// go over the songsSearched
            	if (!(playList2.isEmpty())); playList2.removeSong(songToAddName2, songToAddArtist2, songToAddAlbum2);
            	System.out.println(playList2.getSongs());
            	
            	// if the playlist is empty, then it's empty
            	
            }
            
            // if command is equal to search lib, search lib
            
            if (command.contains("search_lib")) {
            	// ask if they want to search a song
            	System.out.println("Song or Album?");
            	String typeToSearch = scanner.nextLine();
            	
            	if (typeToSearch.contains("album")) {
            		// ask for all the album info and search album
            		System.out.println("Do you want to search by title or artist");
            		String command4 = scanner.nextLine();
            		if (command4.contains("title")) {
            			System.out.println("What's the name of the album you want to search?");
            			String command5 = scanner.nextLine().strip();
            			ArrayList<Album> albumsSearched = lM.searchAlbumByTitleLib(command5);
            		} // call the search by title method
            		 // call the search by artist
            		
            		
            	}
            	
            	if (typeToSearch.contains("song")) {
            		// ask for all the song info and search song
            		
            		// song by title, artist
            	}
            	if (typeToSearch.contains("playlist")) {
            		// search the playlist by its name
            	}
            }
            
            
        }     
        
        System.out.println("Program terminated. Thanks for using our products!");
		
	}
	public static void addSongHelper(Scanner scanner, ArrayList<Song> songsSearched1, LibraryModel lM, String command2) {
		
        if (command2.contains("add_Song")) {
        	System.out.println("What's the name of the song?");
        	String nameSongLib1 = scanner.nextLine().strip();
        	
        	System.out.println("What's the artist of the song?");
        	String nameArtistLib1 = scanner.nextLine().strip();
        	
        	System.out.println("What album does the song belong to?");
        	String nameAlbumLib1 = scanner.nextLine().strip();	
        	
        	// go over the songsSearched
        	// if that has the same song name, same artist, same album
        	// call the library model method addSong
        	for (Song s : songsSearched1) {
        		if (s.getSongTitle().equals(nameSongLib1) && s.getArtistName().equals(nameArtistLib1) 
        				&& s.getAlbumTitle().equals(nameAlbumLib1)) {
        			lM.addSong(s);
        		}
        	}
        	System.out.println(lM.getSongsLib());
        	
        }
	}
	
	public static void addAlbumHelper(Scanner scanner, ArrayList<Album> albumsSearched2, LibraryModel lM) {
		String command3 = scanner.nextLine().strip();
    	
    	if (command3.contains("add_Album")) {
        	System.out.println("What's the name of the album?");
        	String nameAlbumLib1 = scanner.nextLine().strip();
        	
        	System.out.println("What's the artist of the album?");
        	String nameArtistLib1 = scanner.nextLine().strip();
        
        	
        	// go over the albumsSearched
        	// if that has the same album name, album artist,
        	// call the library model method add Album
        	for (Album a : albumsSearched2) {
        		if (a.getTitle().equals(nameAlbumLib1) && a.getArtist().equals(nameArtistLib1)) {
        			lM.addAlbum(a);
        		}
        	}
        }
	}
	
	public static void addPlaylistHelper(Scanner scanner, ArrayList<Song> songsSearched1, LibraryModel lM, String command2) {
		if (command2.contains("add_Playlist")) {
        	System.out.println("What's the name of the playlist you want to add songs to?");
        	String playListName = scanner.nextLine().strip();
        	PlayList playList1 = lM.findPlaylist(playListName);
        	
        	// find out what song the user wants to add
        	System.out.println("What song do you want to add to this play list");
        	String songToAddName = scanner.nextLine().strip();
        	
        	System.out.println("Who is the artist?");
        	String songToAddArtist = scanner.nextLine().strip();

        	System.out.println("What album does this song belong to?");
        	String songToAddAlbum = scanner.nextLine().strip();
        	            	
        	// go over the songsSearched
        	for (Song s : songsSearched1) {
        		if (s.getSongTitle().equals(songToAddName) && s.getArtistName().equals(songToAddArtist) && 
        				s.getAlbumTitle().equals(songToAddAlbum)) {
        			lM.addToPlayList(s, playList1);
        		}
        	}
        	System.out.println(lM.getPlayListLib());
        }
	}
	
	
	
	
}
