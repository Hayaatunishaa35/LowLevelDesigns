package devices;

import externalDevices.BluetoothSpeakerAPI;

public class BluetoothSpeakerAdapter {
    private BluetoothSpeakerAPI bluetoothSpeakerAPI;

    public BluetoothSpeakerAdapter(BluetoothSpeakerAPI bluetoothSpeakerAPI){
        this.bluetoothSpeakerAPI = bluetoothSpeakerAPI;
    }

    


    public void playSoundViaBluetooth(String data){
        System.out.println("Playing music via Bluetooth Speaker : "+data );
    }
}
