package la1_fbbe;

public class myMain {

	public static void main(String[] args) {
		MusicStore ms = new MusicStore();
		ms.configureMS();
		// System.out.println("Hi, MS is working! Yay!");
		
		System.out.println(ms.searchAlbumByArtist("Norah Jones"));
	}
}