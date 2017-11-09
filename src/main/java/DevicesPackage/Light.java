package DevicesPackage;

import Memento.*;
import Visitor.Visitor;

public class Light implements Devices{
	private int state;
	private String name;
	private String classId;
	
	public Light(String name,String classId){
		this.name = name;
		this.classId = classId;
		this.state = -1;
	}
	
	public String getName() {
		return name;
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
