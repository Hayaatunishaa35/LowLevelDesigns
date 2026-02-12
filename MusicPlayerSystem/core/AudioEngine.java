package core;

import devices.IAudioOutputDevice;
import models.Song;

public class AudioEngine {
    private Song currentSong;
    private boolean isSongPaused;

    public AudioEngine(){
        currentSong = null;
        isSongPaused = false;
    }

    public void play(Song song, IAudioOutputDevice aod){

        if(song==null){return;}

        currentSong = song;
        isSongPaused = false;
        aod.playAudio(song);
        System.out.println("Current playing song: "+currentSong.getTitle());
    }

    public void pause(){
        if(currentSong!=null){
            isSongPaused = true;
            System.out.println(currentSong.getTitle()+" Song Paused");
        }
    }
}
