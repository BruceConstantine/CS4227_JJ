package homeServer.deviceManager.devicesPackage;

import Memento.*;
import Visitor.Visitor;

public class Light implements Devices{
	int state;
	String name;
	String classId;
	
	
/** TEMP **/
	int illumination  = 555;
	
	public int getIllumination() {
		return illumination;
	}
	public void setIllumination(int illumination) {
		this.illumination = illumination;
	}
/** TEMP **/
	
	
	public void accept(Visitor v){
		v.visit(this);
		
	}
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
	
	public I_Memento createMemento(){
		return new ConcreteMemento(this.state);
	}
	
	public void restoreMemento(I_Memento m){
		
		this.setState(m.getState());
	}
	
	
}
