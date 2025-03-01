package la1_fbbe;

import java.util.ArrayList;
import java.util.HashSet;
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
				+ "and your program doesn't run, it's on you.\n \n"
				+ "Instructions:\n \n"
				+ "To search: type SEARCH ");
					
		
//				+ "search_song_title [title of the song you want to search]\n"
//				+ "search_song_artist [name of the artist you want to search]\n"
//				+ "search_album_title [title of the album you want to search]\n"
//				+ "search_album_artist [artist of the album you want to search]\n"
//				+ "new_playlist [name of the playlist you want to create]\n"
//				+ "Please note that if you want to add to a song to a playlist, you need to search it first.\n"
//				+ "So afte you search, you either one of these or multiple: \n"
//				+ "add_Playlist [name of the song / artist / album] [name of the playlist you want to add the song to]\n"
//				+ "remove_Playlist [name of the song / artist / album you want to remove from] [name of the play you want to remove from\n"
//				+ "add_Song [name of the song / artist / album  you want to add to your library] \n"
//				+ "remove_Song [name of the song / artist / album you want to remove from your library]\n"
//				+ "add_Album [name of the album / artist / album you want to add to your library]\n"
//				+ "remove_Album [name of the album / artist / album] you want to remove from your library\n"
//				+ "rate [name of the song / artist / album] you want to rate in your library\n"
//				+ "EXIT [exits the program]"
//				+ "");
					
		
				
		
		// initiate all the objects
		MusicStore mS = new MusicStore();
		mS.configureMS();
		LibraryModel lM = new LibraryModel();
		
		
		Scanner scanner = new Scanner(System.in);        
        
        boolean programState = true;
        System.out.println("Input:");
        
        
        while (programState) {
            String command = scanner.nextLine().strip();
            
            if (command.equals("EXIT")) {break;}
            
            
            else if (command.toLowerCase().equals("rate")) {
            	System.out.println("In order to rate, you must have songs in the library"); // be at the top
            	
            	System.out.println("Choose a rating from 1-5");
            	String ratingCommand = scanner.nextLine();
            	Rating rating  = convertToEnums(Integer.valueOf(ratingCommand));
            	
            	System.out.println("What's the song name?");
            	String songNameCommand = scanner.nextLine().strip();
            	
            	System.out.println("Who's the artist of the song?");
            	String songArtistCommand = scanner.nextLine().strip();
            	
            	System.out.println("What's the album the song belongs to?");
            	String songAlbumCommand = scanner.nextLine().strip();
            	
            	// search in the library
            	lM.rateTheSong(songNameCommand, songArtistCommand, songAlbumCommand, rating);
            	continue;
            	
            }
            
            
            // get a list of song titles from the library
            else if (command.toLowerCase().contains("get")) {
            	// ask what they want to get from the library
            	System.out.println("You can get the following from your library:\nsongs, artists, albums, playlists, favorite");
            	
            	String gettersCommand = scanner.nextLine().strip();
            	if (gettersCommand.toLowerCase().contains("songs")) {
            		lM.getSongsLib();
            	}
            	else if (gettersCommand.toLowerCase().contains("artists")) {
            		lM.getArtistsLib();
            	}
            	else if (gettersCommand.toLowerCase().contains("albums")) {
            		// to get all the albums
            		lM.getAlbumsLib();
            	}
            	else if (gettersCommand.toLowerCase().contains("playlists")) {}
            	else if (gettersCommand.toLowerCase().contains("favorite")) {}
            }

            
            
            else if (command.contains("search")) {
            	
            	System.out.println("What do you want to search? Database or library?");
            	String searchCommand = scanner.nextLine().strip();
            	
            	if (searchCommand.toLowerCase().contains("database")) { searchDatabase(scanner, mS, lM);}
            	
            	else if (searchCommand.toLowerCase().contains("library")) { 
            		searchLib(scanner, lM);
            		continue;
            	}
            	
            }
            else if (command.contains("add_Song")) { 
            	System.out.println("You need to search the song first, then add.");
            	continue;
            }
            else if (command.toLowerCase().contains("new_playlist")) { newPlaylistExecuter(scanner, lM);}
            else if (command.toLowerCase().contains("remove_Playlist")) {
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
            	if (!(playList2.isEmpty())) { 
            		playList2.removeSong(songToAddName2, songToAddArtist2, songToAddAlbum2);
            	}
            	
            	// if the playlist is empty, then it's empty
            	
            }
            
            
            
        }     
        
        System.out.println("Program terminated. Thanks for using our products!");
		
	}
	
	
	
	public static void searchDatabase(Scanner scanner, MusicStore mS, LibraryModel lM) {
		// print you can search the database like: 
		// list the valid commands
		System.out.println("Which way do you want to search? ");
		System.out.println("* Song");
		System.out.println("* Album");
		String wayToSearch = scanner.nextLine().strip();
		
		if (wayToSearch.toLowerCase().contains("song")) {searchDatabaseSong(scanner, mS, lM);}
		else if (wayToSearch.toLowerCase().contains("album")) {searchDatabaseAlbum(scanner, mS, lM);}
		
		
		// title, artist
		// ask title or artist
		// implement the search
	}
	
	public static void searchDatabaseSong(Scanner scanner, MusicStore mS, LibraryModel lM) {
		System.out.println("How do you want to search?");
		System.out.println("By:");
		System.out.println("* title");
		System.out.println("* artist");
		
		String command = scanner.nextLine().strip();
		
        if (command.toLowerCase().contains("title")) {
        	System.out.println("What's the name of the song?");

        	String songTitle1 = scanner.nextLine().strip();
        	ArrayList<Song> songsSearched1 = mS.searchSongByTitle(songTitle1);

        	System.out.println("If you want to add to your library, type ADD");
        	
        	String command2 = scanner.nextLine().strip();
        	
        	if(command2.toLowerCase().contains("add")) {
        		
            	System.out.println("Type SONG to add your library as a song");
            	System.out.println("Type PLAYLIST to add to your playlist");
            	
            	String commandSong = scanner.nextLine().strip();
            	
            	if (commandSong.toLowerCase().contains("song")) {addSongHelper(scanner, songsSearched1, lM);}
            	if (commandSong.toLowerCase().contains("playlist")) { addPlaylistHelper(scanner, songsSearched1, lM);}
        	}
        	
        }
        
        else if (command.toLowerCase().contains("artist")) {
        	System.out.println("Who's the artist of the song?");
        	String songArtist1 = scanner.nextLine().strip();
        	ArrayList<Song> songsSearched2 = mS.searchSongByArtist(songArtist1);
        	
        	System.out.println("\nIf you want to add to your library, type ADD");
        	
        	String command3 = scanner.nextLine().strip();
        	if(command3.toLowerCase().contains("add")) {
        		
            	System.out.println("Type SONG to add your library as a song");
            	System.out.println("Type PLAYLIST to add to your playlist");
            	
            	String commandSong = scanner.nextLine().strip();
            	
            	if (commandSong.toLowerCase().contains("song")) {addSongHelper(scanner, songsSearched2, lM);}
            	if (commandSong.toLowerCase().contains("playlist")) { addPlaylistHelper(scanner, songsSearched2, lM);}
        	}
        	

        }
	}
	
	public static void searchDatabaseAlbum(Scanner scanner, MusicStore mS, LibraryModel lM) {
		
		System.out.println("How do you want to search?");
		System.out.println("By:");
		System.out.println("* title");
		System.out.println("* artist");
		
		String command = scanner.nextLine().strip();
        if (command.toLowerCase().contains("title")) {
        	System.out.println("What's the name of the album?");
        	String albumName1 = scanner.nextLine().strip();
        	ArrayList<Album> albumsSearched1 = mS.searchAlbumByTitle(albumName1);
        	
        	System.out.println("Type ADD ALBUM to add your library as a song");

        	String addAlbumCommand1 = scanner.nextLine().strip();
        	
        	if(addAlbumCommand1.toLowerCase().contains("add album")) {addAlbumHelper(scanner, albumsSearched1, lM);}
        	else {System.out.println("Invalid input. You are now back at the initial directory. Type SEARCH to search");}
        }
        else if (command.toLowerCase().contains("artist")) {
        	System.out.println("Who's the artist?");
        	
        	String artistName1 = scanner.nextLine().strip();
        	
        	ArrayList<Album> albumsSearched1 = mS.searchAlbumByArtist(artistName1);
        	
        	System.out.println("Type ADD ALBUM to add your library as a song");
        	String addAlbumCommand2 = scanner.nextLine().strip();
        	
        	if(addAlbumCommand2.toLowerCase().contains("add album")) { addAlbumHelper(scanner, albumsSearched1, lM);}
        	else {System.out.println("Invalid input. You are now back at the initial directory. Type SEARCH to search");}
        }
	}
	
	
	public static void searchLib(Scanner scanner, LibraryModel lM) {
		// print you can search the database like:
		// list the valid commands
		System.out.println("Which way do you want to search? ");
		System.out.println("* Song");
		System.out.println("* Album");
		System.out.println("* Playlist");
		// System.out.println("* Favorite");
		
		String command = scanner.nextLine().strip();
		
    	// Search Album from your lib by title and artist
    	
    	if (command.toLowerCase().contains("album")) {
    		// ask for all the album info and search album
    		System.out.println("Do you want to search by title or artist");
    		String albumCommand = scanner.nextLine();
    		
    		// search album by title 
    		if (albumCommand.toLowerCase().contains("title")) {
    			System.out.println("What's the name of the album you want to search?");
    			String command5 = scanner.nextLine().strip();
    			ArrayList<Album> albumsSearched = lM.searchAlbumByTitleLib(command5);
    			System.out.println(albumsSearched);
    		} 
    		
    		
    		// search album by artist
    		else if (albumCommand.toLowerCase().contains("artist")) {
    			System.out.println("Who's the artist of the album you want to search?");
    			String command5 = scanner.nextLine().strip();
    			ArrayList<Album> albumsSearched = lM.searchAlbumByArtist(command5);
    			System.out.println(albumsSearched);
    		} 
    	
        }	
    	
    	
    	// Search Song from your lib by title and song
    	
    	else if (command.toLowerCase().contains("song")) {
    		// ask for all the song info and search song
    		System.out.println("Do you want to search by title or artist");
    		String songCommand = scanner.nextLine();

    		// search by title
    		if (songCommand.toLowerCase().contains("title")) {
    			System.out.println("What's the name of the song you want to search?");
    			String command5 = scanner.nextLine().strip();
    			HashSet<Song> songsSearched1 = lM.searchSongByTitleLib(command5);
    			System.out.println(songsSearched1);
    		} 
    		// search by artist
    		else if (songCommand.toLowerCase().contains("artist")) {
    			System.out.println("Who's the artist of the song you want to search?");
    			String command5 = scanner.nextLine().strip();
    			HashSet<Song> songsSearched2 = lM.searchSongByArtistLib(command5);
    			System.out.println(songsSearched2);
    		}
    	}
    	
    	// Search playlist from your lib 
    
    	else if (command.contains("playlist")) {
    		// search the playlist by its name
    		// ask what playlist 
    		// check that user has playlists 
    		System.out.println("Did you create any playlists?");
    		System.out.println("In order to use this, you need to have a playlist");
    		System.out.print("which you can create through NEW_PLAYLIST. \n");
    		System.out.println("What's the name of your playlist");
    		String playListNameCommand = scanner.nextLine().strip();
    		// call a method in the library model that searches the playlist, finds the one with the name, 
    		// print the playlist
    		lM.searchPlaylistByNameLib(playListNameCommand);
    	}
		
	}
	
	
	public static void newPlaylistExecuter(Scanner scanner, LibraryModel lM) {
		System.out.println("What's the name of the playlist?");
		String name = scanner.nextLine().strip();
		lM.initializeAPlayList(name);
	}
	
	public static void addSongHelper(Scanner scanner, ArrayList<Song> songsSearched1, LibraryModel lM) {
    	System.out.println("What's the name of the song?");
    	String nameSongLib1 = scanner.nextLine().strip();
    	
    	System.out.println("Who's the artist of the song?");
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
    	    	return;
    		}
    	}
    	System.out.println("Couldn't add the song. Check your responses. Now you are at the initial directory.");
	}
	
	public static void addAlbumHelper(Scanner scanner, ArrayList<Album> albumsSearched2, LibraryModel lM) {    	
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
    	System.out.println("Album succesfully added to the library.");
	}
	
	
	public static void addPlaylistHelper(Scanner scanner, ArrayList<Song> songsSearched1, LibraryModel lM) {
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
    	System.out.println("Playlist succesfully added to the library.");

	}
	
	public static Rating convertToEnums(int num) {
		Rating rating = Rating.NULL;
		if (num == 1) {
			rating = Rating.ONE;
		}
		else if (num == 2) {
			rating = Rating.TWO;
		}
		else if (num == 3) {
			rating = Rating.THREE;
		}
		else if (num == 4) {
			rating = Rating.FOUR;
		}
		else if (num >= 5) {
			rating = Rating.FIVE;
		}
		return rating;
	}
	
	
	
}
