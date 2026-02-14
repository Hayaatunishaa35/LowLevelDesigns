package strategies;

import models.Playlist;
import models.Song;

public interface PlayStrategy {
    void setPlaylist(Playlist playlist);
    Song playNext();
    Song playPrevious();
    default void addToQueue(Song song){}
}
