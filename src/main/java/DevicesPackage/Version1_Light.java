package DevicesPackage;

import Memento.I_Memento;
import Visitor.Visitor;

public class Version1_Light implements I_Light{
	private int state;
	private String deviceId;
	private String deviceClass;
	private String deviceType;
	private double illumination = 360;
	
	public Version1_Light(String deviceType, String deviceId, String deviceClass){
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
	
	/*public void addDeviceClass(String deviceType) {
		
	}

	public void removeDeviceClass() {
		
	}*/
	public void setIllumination(double newIll){
		this.illumination = newIll;
	}
	
	public double getIllumination(){
		return illumination;
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
	
	public void turnUp(){
		this.illumination+=10;
	}
	
	public void turnDown(){
		this.illumination-=10;
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
