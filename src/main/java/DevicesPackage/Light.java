package DevicesPackage;

import Memento.*;
import Visitor.Visitor;

public class Light implements Devices{
	int state;
	String name;
	String type;
	double illumination = 360;
	
	public void accept(Visitor v){
		v.visit(this);
		
	}
	public Light(String type,String name){
		this.type = type;
		this.name = name;
		this.state = -1;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public int getState(){
		return state;
	}
	
	public void setState(int state){
		this.state = state; 
	}
	
	public void setIllumination(double newIll){
		this.illumination = newIll;
	}
	
	public double getIllumination(){
		return illumination;
	}

	public memento createMemento(){
		return new LightMemento(this.state);
	}
	
	public void restoreMemento(memento m){
		
		this.setState(m.getState());
	}
	
}
