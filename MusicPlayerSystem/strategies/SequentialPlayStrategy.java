package strategies;


import models.Playlist;
import models.Song;

public class SequentialPlayStrategy implements PlayStrategy{

    private Playlist playlist;
    private int currentSongIndex;

    @Override
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
        currentSongIndex = -1;
    }


    @Override
    public Song playNext() {
        if(currentSongIndex+1 < playlist.getSize()){
            currentSongIndex++;
        }
        else{
            currentSongIndex = 0;
        }
        
        return playlist.getSongs().get(currentSongIndex);
    }


    @Override
    public Song playPrevious() {
        if(currentSongIndex == 0){
            currentSongIndex = playlist.getSongs().size() - 1;
        }
        else{
            currentSongIndex--;
        }
        
        return playlist.getSongs().get(currentSongIndex);
    }
    
}
