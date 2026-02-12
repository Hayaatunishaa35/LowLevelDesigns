package devices;

import externalDevices.BluetoothSpeakerAPI;
import models.Song;

public class BluetoothSpeakerAdapter implements IAudioOutputDevice{
    BluetoothSpeakerAPI bluetoothSpeakerAPI;

    public BluetoothSpeakerAdapter(BluetoothSpeakerAPI api){
        this.bluetoothSpeakerAPI = api;
    }

    @Override
    public void playAudio(Song song) {
        String payload = song.getTitle() + " by " + song.getArtist();
        bluetoothSpeakerAPI.playSoundViaBluetooth(payload);
    }
}
