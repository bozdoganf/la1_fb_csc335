package la1_fbbe;

public class Song {
	private String songTitle;
	private String artistName;
	private boolean favStatus;
	private int rating; // change this to enum later
	private String albumTitle;
	
	public Song(String songTitle, String artistName, String albumTitle) {
		this.songTitle = songTitle;
		this.artistName = artistName;
		this.albumTitle = albumTitle;
		rating = 0;
		favStatus = false;
	}
	
	public String getSongTitle() {return songTitle;}
	public String getArtistName() {return artistName;}
	public String getAlbumTitle() {return albumTitle;}
	
}
