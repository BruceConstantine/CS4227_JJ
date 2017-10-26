package Memento;

import DevicesPackage.Devices;

public class originator {
	Devices d;
	private int state;
	
	public originator(Devices d){
		this.d = d;
		this.state = d.getState();
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

