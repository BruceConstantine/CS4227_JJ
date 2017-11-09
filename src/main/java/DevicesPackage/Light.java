package DevicesPackage;

import Memento.*;
import Visitor.Visitor;

public class Light implements Devices{
	int state;
	String name;
	String classId;
	
	
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
