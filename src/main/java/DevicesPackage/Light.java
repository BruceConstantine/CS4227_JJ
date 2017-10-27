package DevicesPackage;

import Memento.*;

public class Light implements Devices{
	int state;
	String name;
	
	public Light(String name){
		this.name = name;
		this.state = -1;
	}
	
	public String getName(){
		return name;
	}
	
	public int getState(){
		return state;
	}
	
	public void setState(int state){
		this.state = state; 
	}
	
	public memento createMemento(){
		return new LightMemento(this.state);
	}
	
	public void restoreMemento(memento m){
		
		this.setState(m.getState());
	}
	
}
