package homeServer.deviceManager.factory;

import homeServer.deviceManager.devicesPackage.*;

public class DevicesFactory {
	
	
	public Devices createDevices(String type, String name,String classId){
		
			switch(type){
			
			case "THEMOMETER": return new Themometer(name,classId);
			
			case "LIGHT": return new Light(name,classId);
			
			case "LIGHTSENSOR": return new LightSensor(name,classId); 
			
			case "TEMPERATURESENSOR": return new TemperatureSensor(name,classId);
			
			default: return new Light(name,classId);
			}
	}
}
