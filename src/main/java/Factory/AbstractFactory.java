package Factory;

import DevicesPackage.I_Devices;

public interface AbstractFactory {
	
	public I_Devices createDevices(String deviceType, String deviceId,String deviceClass);

}
