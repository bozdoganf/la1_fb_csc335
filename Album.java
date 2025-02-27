package la1_fbbe;

import java.util.ArrayList;

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
	
	public void getAlbumSongs() {
		for (int i = 0; i < songs.size(); i++) {
			System.out.println(songs.get(i).getSongTitle());
		}
	}

	
}
