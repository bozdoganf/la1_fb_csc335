import java.util.ArrayList;
import java.util.HashSet;

public class Album {
	private String title;
	private String artistName;
	private String genre;
	private String year;
	private ArrayList<Song> songs;
	
	
	public Album(String title, String artistName, String genre, String year) {
		this.title = title;
		this.artistName = artistName;
		this.genre = genre;
		this.year = year;
		songs = new ArrayList<>();
	}
	
	
	
	public String getTitle() { return title;}
	public String getArtist() { return artistName;}
	public String getGenre() { return genre;}
	public String getYear() { return year;}
	
	
	public void buildAlbum(Song s) {
		songs.add(s);
	}

	public void retrieveAlbumSongs(HashSet<Song> res) {
		for (Song s : songs ) {
			res.add(s);
		}
	}
	
	public void printAllSongs() {
		for (Song s : songs) {
			System.out.println(s.getSongTitle());
		}
	}
	
	public void searchSongByTitle(String songTitle, ArrayList<Boolean> found, ArrayList<Song> songsSearched1) {
		for(Song song: songs) {
			if(songTitle.equals(song.getSongTitle())) {
				songsSearched1.add(song);
				System.out.println("Song title: " + song.getSongTitle());
				System.out.println("Song artist: " + song.getArtistName());
				System.out.println("Album the song belongs: " + song.getAlbumTitle());
				found.remove(false);
				found.add(true);
			}
		}
	}
	
	public void searchSongByTitle(String songTitle, ArrayList<Boolean> found, HashSet<Song> songsSearched1) {
		for(Song song: songs) {
			if(songTitle.equals(song.getSongTitle())) {
				songsSearched1.add(song);
				System.out.println("Song title: " + song.getSongTitle());
				System.out.println("Song artist: " + song.getArtistName());
				System.out.println("Album the song belongs: " + song.getAlbumTitle());
				found.remove(false);
				found.add(true);
			}
		}
	}
	
	public void searchSongByArtist(String artist, ArrayList<Boolean> found, ArrayList<Song> songsSearched2) {
		
		for(Song song: songs) {
			if(artist.equals(song.getArtistName())) {
				songsSearched2.add(song);
				System.out.println("Song title: " + song.getSongTitle());
				System.out.println("Song artist: " + song.getArtistName());
				System.out.println("Album the song belongs: " + song.getAlbumTitle());
				if (found.contains(false))found.remove(false);
				found.add(true);
			}
			
		}
	}
	
	public void searchSongByArtist(String artist, ArrayList<Boolean> found, HashSet<Song> songsSearched2) {
		
		for(Song song: songs) {
			if(artist.equals(song.getArtistName())) {
				songsSearched2.add(song);
				System.out.println("Song title: " + song.getSongTitle());
				System.out.println("Song artist name: " + song.getArtistName());
				System.out.println("Album the song belongs: " + song.getAlbumTitle());
				if (found.contains(false))found.remove(false);
				found.add(true);
			}
			
		}
	}
	
	public Song findSong(String songName, String songArtist, String albumItBelongsTo) {
		for (Song s : songs) {
			if (s.getSongTitle().equals(songName) && s.getArtistName().equals(songArtist)
					&& s.getAlbumTitle().equals(albumItBelongsTo)) {
				return s;
			}
		}
		return null;
	}

	
	
}