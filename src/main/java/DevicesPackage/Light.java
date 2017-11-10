package DevicesPackage;

import Memento.*;
import Visitor.Visitor;

public class Light implements Devices{
	private int state;
	private String deviceId;
	private String deviceClass;
	private String deviceType;
	
	public Light(String deviceType, String deviceId, String deviceClass){
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
	
	public void setDeviceClass(String deviceClass){
		this.deviceClass = deviceClass;
	}
	
	public void turnOn(){
		this.state = 1;
	}
	
	public void turnOff(){
		this.state = 0;
	}
	
	public void turnUp(){
		
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
