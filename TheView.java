package la2;
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
				+ "Welcome to Musices Optimus!\n"
				+ "This follows Design by Contract methodology, meaning if you fail to follow the instructions, it's your responsibility\n \n"
				+ "Instructions:\n \n"
				+ "To search the database: SEARCH_DATABASE\n"
				+ "To search your library: SEARCH_LIB\n"
				+ "To add a song to your library: ADD_SONG\n"
				+ "To add an album to your library: ADD_ALBUM\n"
				+ "To create a playlist: NEW_PLAYLIST\n"
				+ "To add a song to a playlist: ADD_PLAYLIST\n"
				+ "To remove a song from a playlist: REMOVE_PLAYLIST\n"
				+ "To rate a song: RATE\n"
				+ "To get a list of: songs, albums, playlists, your favorites: GET\n"
				+ "To exit the program: EXIT\n");
				
		
		// initiate all the objects
		MusicStore mS = new MusicStore();
		String path = "/Users/fatihbozdogan/Desktop/CS/CSC335/las/la2/src";
		mS.configureMS(path);
		LibraryModel lM = new LibraryModel();
		
		
		Scanner scanner = new Scanner(System.in);        
        
        boolean programState = true;
        System.out.println("Input below:");
        
        
        while (programState) {
            String command = scanner.nextLine().strip();
            
            if (command.toLowerCase().contains("instructions")) {
        		System.out.println(""
        				+ "Instructions:\n \n"
        				+ "To search the database: SEARCH_DATABASE\n"
        				+ "To search your library: SEARCH_LIB\n"
        				+ "To add a song to your library: ADD_SONG\n"
        				+ "To add an album to your library: ADD_ALBUM\n"
        				+ "To create a playlist: NEW_PLAYLIST\n"
        				+ "To add a song to a playlist: ADD_PLAYLIST\n"
        				+ "To remove a song from a playlist: REMOVE_PLAYLIST\n"
        				+ "To rate a song: RATE\n"
        				+ "To get a list of: songs, albums, playlists, your favorites: get"
        				+ "To exit the program: EXIT\n");
            }
            
            if (command.strip().toLowerCase().contains("search_database")) {searchDatabase(scanner, mS, lM);}
            else if (command.strip().contains("search_lib")) {searchLib(scanner, lM);}
            
            else if (command.strip().toLowerCase().contains("add_song")) {addSongHelper(scanner, mS, lM);}
            else if (command.strip().toLowerCase().contains("add_album")) {addAlbumHelper(scanner, mS, lM);}
            
        	
        	else if (command.strip().toLowerCase().contains("new_playlist")) { newPlaylist(scanner, lM);}
            else if (command.strip().toLowerCase().contains("add_playlist")) {addPlaylistHelper(scanner, mS, lM);}
            else if (command.strip().toLowerCase().contains("remove_playlist")) {removePlaylist(scanner, lM);}
            	
            else if (command.strip().toLowerCase().equals("rate")) {rateASong(scanner, lM);}
            else if (command.strip().toLowerCase().contains("get")) {getFromLibrary(scanner, lM);}
            else if (command.strip().toLowerCase().equals("EXIT")) {break;}
            else {System.out.println("Invalid input. Check your spelling");}    
    		System.out.println(""
    				+ "\n\nInstructions:\n \n"
    				+ "To search the database: SEARCH_DATABASE\n"
    				+ "To search your library: SEARCH_LIB\n"
    				+ "To add a song to your library: ADD_SONG\n"
    				+ "To add an album to your library: ADD_ALBUM\n"
    				+ "To create a playlist: NEW_PLAYLIST\n"
    				+ "To add a song to a playlist: ADD_PLAYLIST\n"
    				+ "To remove a song from a playlist: REMOVE_PLAYLIST\n"
    				+ "To rate a song: RATE\n"
    				+ "To get a list of: songs, albums, playlists, your favorites: get"
    				+ "To exit the program: EXIT\n");
        	}
        System.out.println("Program terminated. Thanks for using our products!");
	}
	
	public static void searchDatabase(Scanner scanner, MusicStore mS, LibraryModel lM) {
		System.out.println("Which way do you want to search? ");
		System.out.println("* Song");
		System.out.println("* Album");
		String wayToSearch = scanner.nextLine().strip();
		
		if (wayToSearch.toLowerCase().contains("song")) {searchDatabaseSong(scanner, mS, lM);}
		else if (wayToSearch.toLowerCase().contains("album")) {searchDatabaseAlbum(scanner, mS, lM);}
	}
	
	public static void searchDatabaseSong(Scanner scanner, MusicStore mS, LibraryModel lM) {
		System.out.println("How do you want to search?");
		System.out.println("By:");
		System.out.println("* title");
		System.out.println("* artist");
		
		String command = scanner.nextLine().strip();
        if (command.toLowerCase().contains("title")) {searchDatabaseSongByTitle(scanner, mS, lM);}
        if (command.toLowerCase().contains("artist")) {searchDatabaseSongByArtist(scanner, mS, lM);}

	}
	
	public static void searchDatabaseSongByTitle(Scanner scanner, MusicStore mS, LibraryModel lM) {
        
    	System.out.println("What's the name of the song?");

    	String songTitle1 = scanner.nextLine().strip();
    	ArrayList<Song> songsFoundByTitle = mS.searchSongByTitle(songTitle1);
    	
    	// print all the songs
    	for (Song s : songsFoundByTitle) {
			System.out.println();
			System.out.println("Song title: " + s.getSongTitle());
			System.out.println("Song artist: " + s.getArtistName());
			System.out.println("Album the song belongs: " + s.getAlbumTitle());
    	}
    	
    	// if the song doesn't exist in the library
    	if (songsFoundByTitle.isEmpty()) {
    		System.out.println("The search not found in our database. Therefore, you cannot add to any playlist. Search a different song");
    		return;
    	}        	
	}
	
	public static void searchDatabaseSongByArtist(Scanner scanner, MusicStore mS, LibraryModel lM) {
    	System.out.println("Who's the artist of the song?");
    	String songArtist1 = scanner.nextLine().strip();
    	ArrayList<Song> songsFoundByArtist = mS.searchSongByArtist(songArtist1);
    	
    	for (Song s : songsFoundByArtist) {
    		System.out.println();
			System.out.println("Song title: " + s.getSongTitle());
			System.out.println("Song artist: " + s.getArtistName());
			System.out.println("Album the song belongs: " + s.getAlbumTitle());
    	}
    	
    	// if the song doesn't exist in the library
    	if (songsFoundByArtist.isEmpty()) {
    		System.out.println("The search not found in our database. Therefore, you cannot add to the playlist. Search a different song");
    		return;
    	}
	}
	
	public static void searchDatabaseAlbum(Scanner scanner, MusicStore mS, LibraryModel lM) {
		
		System.out.println("How do you want to search?");
		System.out.println("By:");
		System.out.println("* title");
		System.out.println("* artist");
		
		String command = scanner.nextLine().strip();
        if (command.toLowerCase().contains("title")) {searchDatabaseAlbumByTitle(scanner, mS, lM);}
        else if (command.toLowerCase().contains("artist")) {searchDatabaseAlbumByArtist(scanner, mS, lM);}
	}
	
	public static void searchDatabaseAlbumByTitle(Scanner scanner, MusicStore mS, LibraryModel lM) {
        	System.out.println("What's the name of the album?");
        	String albumName1 = scanner.nextLine().strip();
        	ArrayList<Album> albumsFoundByTitle = mS.searchAlbumByTitle(albumName1);
        	
        	// print all the songs
        	for (Album a : albumsFoundByTitle) {
				System.out.println();
				System.out.println("Album title: " + a.getTitle());
				System.out.println("Album artist: " + a.getArtist());
				System.out.println("Album genre: " + a.getGenre());
				System.out.println("Album year: " + a.getYear());
				System.out.println();
				ArrayList<Song> albumSongs = a.getSongs();
				for (Song s : albumSongs) {
					System.out.println(s.getSongTitle());
				}
        	}
        	
        	// if the song doesn't exist in the library
        	if (albumsFoundByTitle.isEmpty()) {
        		return;
        	}
	}
	
	public static void searchDatabaseAlbumByArtist(Scanner scanner, MusicStore mS, LibraryModel lM) {
    	System.out.println("Who's the artist?");
    	
    	String artistName1 = scanner.nextLine().strip();
    	
    	ArrayList<Album> albumsFoundByArtist = mS.searchAlbumByArtist(artistName1);
    	
    	// print all the songs
    	for (Album a : albumsFoundByArtist) {
			System.out.println();
			System.out.println("Album title: " + a.getTitle());
			System.out.println("Album artist: " + a.getArtist());
			System.out.println("Album genre: " + a.getGenre());
			System.out.println("Album year: " + a.getYear());
			System.out.println();
			
			ArrayList<Song> albumSongs = a.getSongs();
			for (Song s : albumSongs) {
				System.out.println(s.getSongTitle());
			}
    	}
    	
    	// if the song doesn't exist in the library
    	if (albumsFoundByArtist.isEmpty()) {
    		System.out.println("The search not found in our database. Therefore, you cannot add to any playlist. Search a different song");
    		return;
    	}
	}
	
	public static void searchLib(Scanner scanner, LibraryModel lM) {
		// print you can search the database like:
		// list the valid commands
		System.out.println("Which way do you want to search? ");
		System.out.println("* Song");
		System.out.println("* Album");
		System.out.println("* Playlist");
		
		String command = scanner.nextLine().strip();
    	if (command.toLowerCase().contains("song")) {searchLibSong(scanner, lM);}
    	else if (command.toLowerCase().contains("album")) {searchLibAlbum(scanner, lM);}
    	else if (command.toLowerCase().contains("playlist")) {searchLibPlaylist(scanner, lM);}	
    	return;
	}
	
	public static void searchLibSong(Scanner scanner, LibraryModel lM) {
    		// ask for all the song info and search song
    		System.out.println("How do you want to search?");
    		System.out.println("By:");
    		System.out.println("* title");
    		System.out.println("* artist");
    		String songCommand = scanner.nextLine();

    		// search by title
    		if (songCommand.toLowerCase().contains("title")) {searchLibSongByTitle(scanner, lM);} 
    		else if (songCommand.toLowerCase().contains("artist")) {searchLibSongByArtist(scanner, lM);}
    		return;
	}
	
	public static void searchLibSongByTitle(Scanner scanner, LibraryModel lM) {
		System.out.println("What's the name of the song you want to search?");
		String songName = scanner.nextLine().strip();
		ArrayList<Song> songsFoundByTitle = lM.searchSongByTitle(songName);
		
    	// print all the songs
    	for (Song s : songsFoundByTitle) {
			System.out.println();
			System.out.println("Song title: " + s.getSongTitle());
			System.out.println("Song artist: " + s.getArtistName());
			System.out.println("Album the song belongs: " + s.getAlbumTitle());
    	}
    	
    	// if the song doesn't exist in the library
    	if (songsFoundByTitle.isEmpty()) {
    		System.out.println("The search not found in your library. Add it to your library!");
    		return;
    	}
	}
	
	public static void searchLibSongByArtist(Scanner scanner, LibraryModel lM) {
		System.out.println("Who's the artist of the song you want to search?");
		String songArtist = scanner.nextLine().strip();
		ArrayList<Song> songsFoundByArtist = lM.searchSongByArtist(songArtist);
		
		
    	// print all the songs
    	for (Song s : songsFoundByArtist) {
    		System.out.println();
			System.out.println("Song title: " + s.getSongTitle());
			System.out.println("Song artist: " + s.getArtistName());
			System.out.println("Album the song belongs: " + s.getAlbumTitle());
    	}
    	
    	// if the song doesn't exist in the library
    	if (songsFoundByArtist.isEmpty()) {
    		System.out.println("The search not found in your library. Search in the Music Store and add to your library!");
    		return;
    	}
	}
	
	public static void searchLibAlbum(Scanner scanner, LibraryModel lM) {
    		// ask for all the album info and search album
    		System.out.println("How do you want to search?");
    		System.out.println("By:");
    		System.out.println("* title");
    		System.out.println("* artist");
    		String albumCommand = scanner.nextLine();
    		
    		if (albumCommand.toLowerCase().contains("title")) {searchLibAlbumByTitle(scanner, lM);}
    		else if (albumCommand.toLowerCase().contains("artist")) {searchLibAlbumByArtist(scanner, lM);}
    		return;
	}
	
	public static void searchLibAlbumByTitle(Scanner scanner, LibraryModel lM) {
		System.out.println("What's the name of the album you want to search?");
		String albumNameLib = scanner.nextLine().strip();
		
    	ArrayList<Album> albumsFoundByTitle = lM.searchAlbumByTitle(albumNameLib);
    	
    	// print all the songs
    	for (Album a : albumsFoundByTitle) {
			System.out.println("Album title: " + a.getTitle());
			System.out.println("Album artist: " + a.getArtist());
			System.out.println("Album genre: " + a.getGenre());
			System.out.println("Album year: " + a.getYear());
			System.out.println();
			
			ArrayList<Song> albumSongs = a.getSongs();
			for (Song s : albumSongs) {
				System.out.println(s.getSongTitle());
			}
    	}
    	
    	// if the song doesn't exist in the library
    	if (albumsFoundByTitle.isEmpty()) {
    		System.out.println("The search not found in our database. Therefore, you cannot add to any playlist. Search a different song");
    		return;
    	}
	}
	
	public static void searchLibAlbumByArtist(Scanner scanner, LibraryModel lM) {
		System.out.println("Who's the artist of the album you want to search?");
		String artistOfTheAlbum = scanner.nextLine().strip();
		ArrayList<Album> albumsFoundByArtist = lM.searchAlbumByArtist(artistOfTheAlbum);
		
    	// print all the songs
    	for (Album a : albumsFoundByArtist) {
			System.out.println("Album title: " + a.getTitle());
			System.out.println("Album artist: " + a.getArtist());
			System.out.println("Album genre: " + a.getGenre());
			System.out.println("Album year: " + a.getYear());
			System.out.println();
			
			ArrayList<Song> albumSongs = a.getSongs();
			for (Song s : albumSongs) {
				System.out.println(s.getSongTitle());
			}
    	}
		
    	// if the song doesn't exist in the library
    	if (albumsFoundByArtist.isEmpty()) {
    		System.out.println("The search not found in our database. Therefore, you cannot add to any playlist. Search a different song");
    		return;
    	}
	}
	
	public static void searchLibPlaylist(Scanner scanner, LibraryModel lM) {
    		System.out.println("What's the name of your playlist");
    		
    		ArrayList<String> playlistsNames = lM.getPlaylists();
    		System.out.println("Your playlists: ");
    		for (String pNames : playlistsNames) {
    			System.out.println("* " + pNames);
    		}
    		
    		String playlistName = scanner.nextLine().strip();
    		
    		if (!(lM.playlistIsInLibrary(playlistName))) {
    			System.out.println("\nThere's no such playlist in the library. Check your spelling or new_playlist");
    			return;
    		}
    		
    		ArrayList<Song> playlistSongs = lM.getSongsFromPlaylist(playlistName);
			System.out.println("Playlist: " + playlistName);
    		for (Song s : playlistSongs) {
				System.out.println("Song title: " + s.getSongTitle());
				System.out.println("Song artist: " + s.getArtistName());
    		}
    		if (playlistSongs.isEmpty()) {System.out.println("Playlist is empty.");}
	}
	
	public static void addSongHelper(Scanner scanner, MusicStore mS, LibraryModel lM) {
    	System.out.println("What's the name of the song?");
    	String songName = scanner.nextLine().strip();
    	
    	System.out.println("Who's the artist of the song?");
    	String songArtist = scanner.nextLine().strip();
    	
    	System.out.println("What album does the song belong to?");
    	String albumName = scanner.nextLine().strip();	
    	    	
    	// if not in MS, print could not in database
    	if (!(mS.songIsInMS(songName, songArtist, albumName))) {
    		System.out.println("\nThe search not found in our database. Double check your spelling or add another song!");
    		return;
    	}
    	
    			
		// check if it's in the library first
		if (lM.songIsInLibrary(songName, songArtist, albumName)) {
			System.out.println("\nSong is already in the library.");
			System.out.println("Add another song. Don't forget to search first!");
			return;
		}
		
		Album albumInMS = mS.findAlbum(albumName, songArtist);
		lM.addSongAndAlbumHandler(songName, songArtist, albumName, albumInMS);
    	System.out.println("\nSong succesfully added to the library.");
    	return;
	}	
	
	public static void addAlbumHelper(Scanner scanner, MusicStore mS, LibraryModel lM) {    	
    	System.out.println("What's the name of the album?");
    	String albumName = scanner.nextLine().strip();
    	
    	System.out.println("Who is the artist of the album?");
    	String albumArtist = scanner.nextLine().strip();
    
    	// if not in MS, print could not in database
    	if (!(mS.albumIsInMS(albumName, albumArtist))) {
    		System.out.println("\nThe search was not found in our database. Double check your spelling or add another album!");
    		return;
    	}
    	
    	// get album size in the music store
    	// have a albumIsFull(albumName, albumArtist, albumMaxSize)
    	Album albumInMS = mS.findAlbum(albumName, albumArtist);
    	
		
		if (lM.albumIsInLibrary(albumName, albumArtist)) {
			boolean handled = lM.addAlbumAndSongsHandler(albumName, albumArtist, albumInMS);
			if (handled) {System.out.println("\nThe remaining songs of the album have been filled. Album is full now");}
			else {System.out.println("\nThe album already is inside the library and full");}
		}
		else {
			lM.addAlbum(albumInMS);
			System.out.println("\nThe album has sucesfully been added to the library");
		}
	}	
	
	public static void newPlaylist(Scanner scanner, LibraryModel lM) {
		System.out.println("What's the name of the playlist?");
		String name = scanner.nextLine().strip();
		lM.initializeAPlayList(name);
		System.out.println("\nPlaylist successfully initialized!");
	}
	
	public static void addPlaylistHelper(Scanner scanner, MusicStore mS, LibraryModel lM) {
		
    	System.out.println("\nWhat's the name of the playlist you want to add songs to?");
    	
		ArrayList<String> playlistsNames = lM.getPlaylists();
		System.out.println("Your playlists: ");
		for (String pNames : playlistsNames) {
			System.out.println("* " + pNames);
		}
    	
    	String playlistName = scanner.nextLine().strip();
    	
    	// check if such playlist exists in the library
    	if (!(lM.playlistIsInLibrary(playlistName))) {
    		System.out.println("\nNo such playlist exists in the library.");
    		System.out.println("Type new_playlist to create a new playlist");
    		return;
    	}
    	
    	// find out what song the user wants to add
    	System.out.println("What song do you want to add to this playlist");
		
    	String songToAddTitle = scanner.nextLine().strip();
    	
    	System.out.println("Who is the artist?");
    	String songToAddArtist = scanner.nextLine().strip();

    	System.out.println("What album does this song belong to?");
    	String songToAddAlbumTitle = scanner.nextLine().strip();    	
    	    	
    	// if not in MS, print could not in database
    	if (!(mS.songIsInMS(songToAddTitle, songToAddArtist, songToAddAlbumTitle))) {
    		System.out.println("\nThe search not found in our database. Double check your spelling or add another song!");
    		return;
    	}
    	
    	// check if that songs exists in the library
		if (!(lM.songIsInLibrary(songToAddTitle, songToAddArtist, songToAddAlbumTitle))) {
			System.out.println("\nYou need to add the song to the library before you add to the playlist.");
			System.out.println("To add a song to a library: add_song");
			return;
		}
		
		// you cannot add the exact same song to the playlist, so check if the playlist contains the exact same song
		if (lM.songIsInPlaylist(songToAddTitle, songToAddArtist, songToAddAlbumTitle, playlistName)) {
			System.out.println("\nThis song already exists in the playlist. Add a different song!");
			return;
		}
	
		// add to the playlist
		
		lM.addToPlayList(songToAddTitle, songToAddArtist, songToAddAlbumTitle, playlistName);
    	System.out.println("\nSong succesfully added to the playlist.");
	}
	
	public static void removePlaylist(Scanner scanner, LibraryModel lM) {
    	System.out.println("What's the name of the playlist you want to remove songs from?");
    	
		ArrayList<String> playlistsNames = lM.getPlaylists();
		System.out.println("Your playlists: ");
		for (String pNames : playlistsNames) {
			System.out.println("* " + pNames);
		}
    	
    	String playlistName = scanner.nextLine().strip();
    	
    	// check if the playlist is in library
    	if (!(lM.playlistIsInLibrary(playlistName))) {
    		System.out.println("\nThe playlist is not in library");
    		return;
    	}
    	
    	// find out what song the user wants to add
    	System.out.println("What song do you want to remove from this playlist");
    	String songToRemoveName = scanner.nextLine().strip();
    	
    	System.out.println("Who is the artist of this song you want to remove?");
    	String songToRemoveArtist = scanner.nextLine().strip();

    	System.out.println("What album does this song you want to remove belong to?");
    	String songToRemoveAlbum = scanner.nextLine().strip();
    	
    	
    	if (!lM.songIsInLibrary(songToRemoveName, songToRemoveArtist, songToRemoveAlbum)) {
    		System.out.println("\nThe song is not in the library. Check your spelling or add the song to the library");
    		return;
    	}
    	
    	boolean handled = lM.removeFromPlaylist(playlistName, songToRemoveName, songToRemoveArtist, songToRemoveAlbum);
    	if (handled) {System.out.println("\nSong succesfully removed from the playlist");}
    	else {System.out.println("\nNo such song exists in the playlist");}
    	
    }
	
	public static void rateASong(Scanner scanner, LibraryModel lM) {    	
    	System.out.println("What's the song name?");
    	String songName = scanner.nextLine().strip();
    	
    	System.out.println("Who's the artist of the song?");
    	String songArtist = scanner.nextLine().strip();
    	
    	System.out.println("What's the album the song belongs to?");
    	String songAlbum = scanner.nextLine().strip();
    	
    	
    	if (!lM.songIsInLibrary(songName, songArtist, songAlbum)) {
    		System.out.println("\nThe song could not be found in the library. Add to the library, then rate");
    		return;
    	}
    	
    	System.out.println("Choose a rating from 1-5");
    	String songRating = scanner.nextLine();
    	int rating  = Integer.valueOf(songRating);
    	
    	lM.rateTheSong(songName, songArtist, songAlbum, rating);
		System.out.println("\nThe song's rating has been set at " + songRating);
	}
	
	
	
	public static void getFromLibrary(Scanner scanner, LibraryModel lM) {
    	// ask what they want to get from the library
    	System.out.println("You can get the following from your library:\nsongs, artists, albums, playlists, favorite");
    	
    	String gettersCommand = scanner.nextLine().strip();
    	if (gettersCommand.toLowerCase().contains("songs")) {
    		ArrayList<String> songsArr = lM.getSongsLib();
    		for (String song : songsArr) {
    			System.out.println(song);
    		}
    		if (songsArr.isEmpty()) {
    			System.out.println("\nNothing to get. Search and then add a song to the library.");
    			return;
    		}
    		
    	}
    	else if (gettersCommand.toLowerCase().contains("artists")) {
    		ArrayList<String> artistsArr = lM.getArtistsLib();
    		for (String artist : artistsArr) {
    			System.out.println(artist);
    		}
    		if (artistsArr.isEmpty()) {System.out.println("Nothing to get. Search and then add a song or an album to the library.");}
    	}
    	else if (gettersCommand.toLowerCase().contains("albums")) {
    		// to get all the albums
    		ArrayList<String> albumsArr = lM.getAlbumsLib();
    		for (String album : albumsArr) {
    			System.out.println(album);
    		}
    		if (albumsArr.isEmpty()) {System.out.println("Nothing to get. Search and then add an album to the library.");}
    	}
    	else if (gettersCommand.toLowerCase().contains("playlists")) {
    		
    		ArrayList<String> playlistsArr = lM.getPlaylists();
    		for (String playlist : playlistsArr) {
    			System.out.println(playlist);
    		}
    		
    		if (playlistsArr.isEmpty()) {System.out.println("Nothing to get. Create a playlist through new_playlist");}

    		
    	}
    	else if (gettersCommand.toLowerCase().contains("favorite")) {
    		// go over the fav arr and print it
    		ArrayList<String> favArr = lM.getFavArr();
    		for (String favSong : favArr) {
    			System.out.println(favSong);
    		}
    		if (favArr.isEmpty()) {System.out.println("Nothing to get. Search and add songs. Then rate, and then get your favorites");}
    	}
	}
	
}