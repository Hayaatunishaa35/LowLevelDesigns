package factory;

import devices.BluetoothSpeakerAdapter;
import devices.HeadphonesAdapter;
import devices.IAudioOutputDevice;
import devices.WiredSpeakerAdapter;
import enums.DeviceType;
import externalDevices.BluetoothSpeakerAPI;
import externalDevices.HeadphonesAPI;
import externalDevices.WiredSpeakerAPI;

public class DeviceFactory {
    public IAudioOutputDevice createDevice(DeviceType deviceType){
        switch (deviceType) {
            case BLUETOOTH:
                return new BluetoothSpeakerAdapter(new BluetoothSpeakerAPI());
            case HEADPHONES:
                return new HeadphonesAdapter(new HeadphonesAPI());
            case WIRED:
                return new WiredSpeakerAdapter(new WiredSpeakerAPI());
            default:
                break;
        }

        return null;
    }
}
