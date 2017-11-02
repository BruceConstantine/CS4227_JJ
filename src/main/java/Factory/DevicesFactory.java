package Factory;
import java.util.Stack;

import DevicesPackage.*;

public class DevicesFactory {
	
	
	
	public Devices createDevices(String type, String name){
		Stack s = new Stack();
		s.push(new String("THEMOMETER"));
		s.push(new String("LIGHT"));
		
		if(type == s.pop().toString()){
			return new Light(type,name);
		}
		else{
			return new Themometer(type,name);
		}
	}
}
