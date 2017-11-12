package DevicesPackage;

import java.util.List;

public interface I_Version2_LightSensor extends I_Devices{
	public void checkIllumination(List<I_Light> light);
	
	public void turnOn();
	public void turnOff();
}
