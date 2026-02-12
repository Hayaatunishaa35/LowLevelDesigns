package devices;

import externalDevices.HeadphonesAPI;
import models.Song;

public class HeadphonesAdapter implements IAudioOutputDevice{
    HeadphonesAPI headphonesAPI;

    public HeadphonesAdapter(HeadphonesAPI api){
        this.headphonesAPI = api;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        headphonesAPI.playSoundViaHeadphones(payload);
    }
}
