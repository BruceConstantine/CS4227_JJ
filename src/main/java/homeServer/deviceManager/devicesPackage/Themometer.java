package homeServer.deviceManager.devicesPackage;

import Memento.*;
import Visitor.Visitor;

public class Themometer implements Devices{
	int state;
	String name;
	String classId;

/** TEMP ***/
	int Temperature = 0; 
	public int getTemperature() {
		return Temperature;
	}
	
	public void setTemperature(int temperature) {
		Temperature = temperature;
	}

/** TEMP ***/
	
	
	public Themometer(String name, String classId){
		this.name = name;
		this.classId = classId;
		this.state = -1;
	}
	
	public void accept(Visitor v){
		v.visit(this);
		
	}
	
	public int getState(){
		return state;
	}
	
	public void setState(int state){
		this.state = state; 
	}
	
	
	
	public String getClassId(){
		return classId;
	}
	
	public void setClassId(String classId){
		this.classId = classId;
	}
	
	public I_Memento createMemento(){
		return new ConcreteMemento(this.state);
	}
	
	public void restoreMemento(I_Memento m){
		
		this.setState(m.getState());
	}

	
	public String getName() {
		return name;
	}

}
