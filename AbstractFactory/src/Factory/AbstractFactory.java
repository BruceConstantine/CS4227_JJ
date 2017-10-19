package Factory;
import Devices.*;
import Sensors.*;
public interface AbstractFactory {
	
	public I_Light createLight(String name);
	public I_Themometer createThemometer(String name);
	public I_LightSensor createLightSensor(String name);
	public I_ThemomstateSensor createThemomstateSensor(String name);
	
}
