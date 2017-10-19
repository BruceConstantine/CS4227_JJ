package Factory;

import Devices.*;
import Sensors.*;

public class PhilipsFactory implements AbstractFactory{

	
	@Override
	public I_Light createLight(String name){
		return new PhilipsLight(name);
	}
	@Override
	public I_Themometer createThemometer(String name){
		return new PhilipsThemometer(name);
	}
	@Override
	public I_LightSensor createLightSensor(String name){
		return new PhilipsLightSensor(name);
	}
	@Override
	public I_ThemomstateSensor createThemomstateSensor(String name){
		return new PhilipsThemomstateSensor(name);
	}
}