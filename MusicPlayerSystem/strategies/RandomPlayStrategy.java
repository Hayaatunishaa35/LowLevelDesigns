package strategies;

import java.util.*;

import models.Playlist;
import models.Song;

public class RandomPlayStrategy implements PlayStrategy{
    private List<Song> shuffledPlaylist;
    private int currentIndex;

    @Override
    public void setPlaylist(Playlist playlist) {
        if(playlist==null||playlist.getSongs().size()==0){
            throw new RuntimeException("Playlist is empty.");
        }
        shuffledPlaylist = new ArrayList<>(playlist.getSongs());
        Collections.shuffle(shuffledPlaylist);
        currentIndex = -1;
    }

    @Override
    public Song playNext() {
        currentIndex++;
        if(currentIndex==shuffledPlaylist.size()){
            Collections.shuffle(shuffledPlaylist);
            currentIndex = 0;
        }

        return shuffledPlaylist.get(currentIndex);
    }

    @Override
    public Song playPrevious() {
        currentIndex--;
        if(currentIndex==0){
            Collections.shuffle(shuffledPlaylist);
            currentIndex = shuffledPlaylist.size()-1;
        }

        return shuffledPlaylist.get(currentIndex);
    }

    
    
}
