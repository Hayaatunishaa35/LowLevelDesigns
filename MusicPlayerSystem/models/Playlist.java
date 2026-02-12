package models;
import java.util.*;

public class Playlist {
    private String playlistName;
    private List<Song> songList;

    public Playlist(String playlistName){
        this.playlistName =playlistName;
        this.songList = new ArrayList<>();
    }

    public String getPlaylistName(){
        return this.playlistName;
    }

    public List<Song> getSongs(){
        return this.songList;
    }

    public int getSize(){
        return songList.size();
    }

    public void addSongToPlaylist(Song song){
        songList.add(song);
    }
}
