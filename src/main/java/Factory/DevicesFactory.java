package Factory;

import java.util.HashMap;

import DevicesPackage.*;

public class DevicesFactory {
	
	private static final HashMap<Integer, String> devicesType;
	static{
		devicesType = new HashMap<Integer, String>();
		devicesType.put(0, "THEMOMETER");
		devicesType.put(1, "LIGHT");
		devicesType.put(2, "LIGHTSENSOR");
		devicesType.put(3, "TEMPERATURESENSOR");
		
	}
	
	public Devices createDevices(String deviceType, String deviceId,String deviceClass){
		
			if(deviceType==devicesType.get(0))
				return new Themometer(deviceType,deviceId,deviceClass);
			else if(deviceType==devicesType.get(1))
				return new Light(deviceType,deviceId,deviceClass);
			else if(deviceType==devicesType.get(2))
				return new LightSensor(deviceType,deviceId,deviceClass); 
			else
				return new TemperatureSensor(deviceType,deviceId,deviceClass);
	}
}
