package homeServer.deviceManager.devicesPackage;


import Memento.I_Memento;
import Visitor.Visitor;

public class LightSensor implements Devices{
	
	int state = -1;
	String name = "";
	String classId = "";
	double illumination = 360;
	
	public LightSensor(String name,String classId){
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

	public void setIllumination(double newIll){
		this.illumination = newIll;
	}
	
	public double getIllumination(){
		return illumination;
	}
	
	public I_Memento createMemento() {
		return new ConcreteMemento(this.state);
	}

	public void restoreMemento(I_Memento m) {
		
	}

	public void accept(Visitor v) {
		
	}
}
