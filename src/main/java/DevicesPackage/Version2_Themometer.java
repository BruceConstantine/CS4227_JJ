package DevicesPackage;

import Memento.I_Memento;
import Visitor.Visitor;

public class Version2_Themometer implements I_Themometer{
	private int state;
	private String deviceId;
	private String deviceClass;
	private String deviceType;
	private double temperature=30;
	
	
	public Version2_Themometer(String deviceType, String deviceId, String deviceClass){
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
	
	public void setTemperature(double newTem){
		this.temperature = newTem;
	}
	
	public double getTemperature(){
		return temperature;
	}
	public void turnOn(){
		this.state = 1;
	}
	
	public void turnOff(){
		this.state = 0;
	}
	
	public void turnDown() {
		this.temperature--;
	}

	public void turnUp() {
		this.temperature++;
	}
	
	public I_Memento createMemento(){
		return new ConcreteMemento(this.state);
	}
	
	public void restoreMemento(I_Memento m){
		
		this.setState(m.getState());
	}

	public void accept(Visitor v){
		v.visit(this);
		
	}

}
