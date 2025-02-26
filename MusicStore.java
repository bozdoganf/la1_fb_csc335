package la1

import java.util.*;
import java.io.*;


public class MusicStore {
	
	/* INSTANCE VARIABLES */
    private HashMap<String, Object> albums;

	/* CONSTRUCTORS */
	public MusicStore(String albumsFilePath) {
		 albums = new HashMap<>();
	     loadAlbums(albumsFilePath);
	}
	
	private void loadAlbums(String albumsFilePath) {
        // ...
    }

    private void loadAlbum(String fileName) {
        // ...
    }


	
	/* METHODS */

    public HashMap<String, Object> getAlbum(String title) {
        for (HashMap<String, Object> album : albums) {
            if (album.get("title").equals(title)) {
                return album;
            }
        }
        return null;
    }


}
