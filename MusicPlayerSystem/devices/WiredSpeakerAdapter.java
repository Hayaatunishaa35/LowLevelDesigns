package devices;

import externalDevices.WiredSpeakerAPI;
import models.Song;

public class WiredSpeakerAdapter implements IAudioOutputDevice{
    WiredSpeakerAPI wiredSpeakerAPI;

    public WiredSpeakerAdapter(WiredSpeakerAPI api){
        this.wiredSpeakerAPI = api;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        wiredSpeakerAPI.playSoundViaWire(payload);
    }
}
