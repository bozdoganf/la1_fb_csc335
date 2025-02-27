public class myMain {

	public static void main(String[] args) {
		MusicStore ms = new MusicStore();
		ms.configureMS();
//		System.out.println("Hi, MS is working! Yay!");
		
		ms.searchAlbumByArtist("Fatih King");
	}

}