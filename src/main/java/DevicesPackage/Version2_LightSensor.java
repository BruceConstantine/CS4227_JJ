package DevicesPackage;

import java.util.ArrayList;
import java.util.List;

import Memento.I_Memento;
import Visitor.Visitor;

public class Version2_LightSensor implements I_Version2_LightSensor{
	private int state;
	private String deviceId;
	private String deviceClass;
	private String deviceType;
	private List<I_Light> lights = new ArrayList<I_Light>();
	
	public Version2_LightSensor(String deviceType, String deviceId, String deviceClass){
		this.deviceType = deviceType;
		this.deviceId = deviceId;
		this.deviceClass = deviceClass;
		this.state = -1;
	}
	
	public String getDeviceType() {
		return deviceType;
	}
	
	public String getDeviceId() {
		return deviceId;
	}
	
	public String getDeviceClass(){
		return deviceClass;
	}
	public int getState(){
		return state;
	}
	
	public void setState(int state){
		this.state = state;
	}
	
	public void turnOn(){
		this.state = 1;
	}
	
	public void turnOff(){
		this.state = 0;
	}
	public void registerLight(I_Light light){
		lights.add(light);
	}
	public List<I_Light> getLights(){
		return lights;
	}
	
	public void checkIllumination(List<I_Light> light){
		for(I_Light l: light){
			if(l.getIllumination()>350.00){
			l.turnDown();
		}
		else if(l.getIllumination()<300.00){
			l.turnUp();
		}
		}

		
	}
	public I_Memento createMemento() {
		return new ConcreteMemento(this.state);
	}

	public void restoreMemento(I_Memento m) {
		this.state = m.getState();
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

}
