package DevicesPackage;

import java.util.ArrayList;
import java.util.List;

public interface I_Version1_LightSensor extends I_Devices{
	List<I_Light> lights = new ArrayList<I_Light>();
	
	public void turnOn();
	public void turnOff();
}
