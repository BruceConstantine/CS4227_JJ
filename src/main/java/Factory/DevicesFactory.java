package Factory;
import DevicesPackage.*;

public class DevicesFactory {
	
	public Devices createDevices(String type, String name){
		switch(type){
			case "LIGHT": return new Light(type,name);
			case "THEMOMETER": return new Themometer(type,name);
			default: return new Light(type,name);
		}
			
		
	}
}
