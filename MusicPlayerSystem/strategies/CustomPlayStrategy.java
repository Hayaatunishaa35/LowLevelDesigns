package strategies;

import java.util.*;

import models.Playlist;
import models.Song;

public class CustomPlayStrategy implements PlayStrategy {
    private Playlist currenPlaylist;
    LinkedList<Song> songList;
    
    @Override
    public void setPlaylist(Playlist playlist) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPlaylist'");
    }

    @Override
    public Song playNext() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'playNext'");
    }

    @Override
    public Song PlayPrevious() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'PlayPrevious'");
    }
    
}
