package Factory;
import Devices.*;
import Sensors.*;

public class SiemensFactory implements AbstractFactory{

	public I_Light createLight(String name){
		return new SiemensLight(name);
	}
	public I_Themometer createThemometer(String name){
		return new SiemensThemometer(name);
	}
	public I_LightSensor createLightSensor(String name){
		return new SiemensLightSensor(name);
	}
	public I_ThemomstateSensor createThemomstateSensor(String name){
		return new SiemensThemomstateSensor(name);
	}
}
