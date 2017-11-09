package DevicesPackage;

import DevicesPackage.Devices.ConcreteMemento;
import Memento.I_Memento;
import Visitor.Visitor;

public class TemperatureSensor implements Devices{
	private int state = -1;
	private String name = "";
	private String classId = "";
	private double temperature=30;
	
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

	public void turnOn(){
		this.state = 1;
	}
	
	public void turnOff(){
		this.state = 0;
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
