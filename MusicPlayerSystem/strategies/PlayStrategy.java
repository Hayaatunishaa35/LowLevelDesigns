package strategies;

import models.Playlist;
import models.Song;

public interface PlayStrategy {
    void setPlaylist(Playlist playlist);
    Song playNext();
    Song PlayPrevious();
    default void addToQueue(Song song){}
}
