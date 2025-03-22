package la2;


public class Song {
	private String songTitle;
	private String artistName;
	private boolean favStatus;
	private Rating rating;
	private String albumTitle;
	
	public Song(String songTitle, String artistName, String albumTitle) {
		this.songTitle = songTitle;
		this.artistName = artistName;
		this.albumTitle = albumTitle;
		favStatus = false;
	}
	
	// copy constructor
	public Song(String songTitle, String artistName, String albumTitle, Rating rating, boolean favStatus) {
		this.songTitle = songTitle;
		this.artistName = artistName;
		this.albumTitle = albumTitle;
		this.rating = rating;
		this.favStatus = favStatus;
	}
	
	public String getSongTitle() {return songTitle;}
	public String getArtistName() {return artistName;}
	public String getAlbumTitle() {return albumTitle;}
	public Rating getSongRating() {return rating;}
	public boolean getFavStatus() {return favStatus;}
	
	
	
	public void setRating(int ratingInt) {
		Rating rating = this.convertToEnums(ratingInt);
		if (rating == Rating.FIVE) {
			this.favStatus = true;
		}
		this.rating = rating;
	}
	
	private Rating convertToEnums(int num) {		
		Rating rating = null;
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
		else if (num == 5) {
			rating = Rating.FIVE;
		}
		return rating;
	}
	
}
