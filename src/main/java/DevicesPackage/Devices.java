package DevicesPackage;

import Memento.I_Memento;
import Visitor.Visitor;

public interface Devices {
	int state = -1;
	String deviceId = "";
	String deviceClass = "";
	String deviceType = "";
	
	
	public String getDeviceClass();
	public int getState();
	public void setState(int state);
	public String getDeviceId();
	public String getDeviceType();
	
	public void turnOn();
	public void turnOff();
	
	public I_Memento createMemento();
	public void restoreMemento(I_Memento m);
	
	public void accept(Visitor v);
	
	//memento inner class
			public class ConcreteMemento implements I_Memento{
				private int state;
				
				public ConcreteMemento(int state){
					this.state = state;
				}
				
				public int getState(){
					return state;
				}
				public void setState(int state){
					
					this.state = state;
				}
			}
}
