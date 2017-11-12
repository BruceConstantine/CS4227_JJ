package Factory;

import java.util.HashMap;

import DevicesPackage.I_Devices;
import DevicesPackage.Version1_Light;
import DevicesPackage.Version1_LightSensor;
import DevicesPackage.Version1_TemperatureSensor;
import DevicesPackage.Version1_Themometer;

public class Version1DevicesFactory implements AbstractFactory{
	private static final HashMap<Integer, String> devicesType;
	static{
		devicesType = new HashMap<Integer, String>();
		devicesType.put(0, "THEMOMETER");
		devicesType.put(1, "LIGHT");
		devicesType.put(2, "LIGHTSENSOR");
		devicesType.put(3, "TEMPERATURESENSOR");
		
	}
	
	public I_Devices createDevices(String deviceType, String deviceId,String deviceClass){
		
			if(deviceType.equals(devicesType.get(0).toString()))
				return new Version1_Themometer(deviceType,deviceId,deviceClass);
			else if(deviceType.equals(devicesType.get(1).toString()))
				return new Version1_Light(deviceType,deviceId,deviceClass);
			else if(deviceType.equals(devicesType.get(2).toString()))
				return new Version1_LightSensor(deviceType,deviceId,deviceClass); 
			else
				return new Version1_TemperatureSensor(deviceType,deviceId,deviceClass);
	}
}
