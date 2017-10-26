package DevicesPackage;

import Memento.memento;

public class Themometer implements Devices{
	int state;
	String name;
	
	public Themometer(String name){
		this.name = name;
		this.state = -1;
	}
	
	public int getState(){
		return state;
	}
	
	public void setState(int state){
		this.state = state; 
	}
	
	public memento createMemento(){
		return new memento(this.state);
	}
	
	public void restoreMemento(memento m){
		
		this.setState(m.getState());
	}
}
