package homeServer.deviceManager.devicesPackage;

import Memento.I_Memento;
import Visitor.Visitor;
import homeServer.deviceManager.devicesPackage.Devices.ConcreteMemento;

public class TemperatureSensor implements Devices{
	int state = -1;
	String name = "";
	String classId = "";
	double temperature=30;
	
	public TemperatureSensor(String name,String classId){
		this.name = name;
		this.classId = classId;
		this.state = -1;
	}
	
	public String getClassId(){
		return classId;
	}
	
	public void setClassId(String classId){
		this.classId = classId;
	}
	
	public int getState(){
		return state;
	}
	
	public void setState(int state){
		this.state = state;
	}
	
	public String getName(){
		return name;
	}
	
	public void setTemperature(double newTem){
		this.temperature = newTem;
	}
	
	public double getTemperature(){
		return temperature;
	}

	public I_Memento createMemento() {
		return new ConcreteMemento(this.state);
	}

	public void restoreMemento(I_Memento m) {
		
	}

	public void accept(Visitor v) {
		
	}
}
