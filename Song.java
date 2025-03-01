// package la1_fbbe;

public class Song {
	private String songTitle;
	private String artistName;
	private boolean favStatus;
	private Rating rating; // change this to enum later
	private String albumTitle;
	
	public Song(String songTitle, String artistName, String albumTitle) {
		this.songTitle = songTitle;
		this.artistName = artistName;
		this.albumTitle = albumTitle;
		favStatus = false;
	}
	
	public String getSongTitle() {return songTitle;}
	public String getArtistName() {return artistName;}
	public String getAlbumTitle() {return albumTitle;}
	public Rating getSongRating() {return rating;}
	public boolean getFavStatus() {return favStatus;}
	
	
	
	public void setRating(Rating rating) {
		if (rating == Rating.FIVE) {
			this.favStatus = true;
		}
		this.rating = rating;
	}
}
