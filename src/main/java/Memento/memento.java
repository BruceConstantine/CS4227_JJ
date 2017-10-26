package Memento;

public class memento {
	private int state;
	
	public memento(int state){
		this.state = state;
	}
	
	public int getState(){
		return state;
	}
	public void setState(int state){
		
		this.state = state;
	}
}
