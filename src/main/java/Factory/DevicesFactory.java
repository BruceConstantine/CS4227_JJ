package Factory;
import DevicesPackage.*;

public class DevicesFactory {
	
	public Devices createDevices(String type, String name){
		switch(type){
			case "LIGHT": return new Light(name);
			case "THEMOMETER": return new Themometer(name);
			default: return new Light(name);
		}
			
		
	}
}
