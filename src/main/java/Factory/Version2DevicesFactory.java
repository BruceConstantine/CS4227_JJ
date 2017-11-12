package Factory;

import java.util.HashMap;

import DevicesPackage.I_Devices;
import DevicesPackage.Version2_Light;
import DevicesPackage.Version2_LightSensor;
import DevicesPackage.Version2_TemperatureSensor;
import DevicesPackage.Version2_Themometer;

public class Version2DevicesFactory implements AbstractFactory{
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
				return new Version2_Themometer(deviceType,deviceId,deviceClass);
			else if(deviceType.equals(devicesType.get(1).toString()))
				return new Version2_Light(deviceType,deviceId,deviceClass);
			else if(deviceType.equals(devicesType.get(2).toString()))
				return new Version2_LightSensor(deviceType,deviceId,deviceClass); 
			else
				return new Version2_TemperatureSensor(deviceType,deviceId,deviceClass);
	}
}
