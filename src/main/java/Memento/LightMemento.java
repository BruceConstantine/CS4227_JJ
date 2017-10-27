package Memento;

public class LightMemento implements memento{
	private int state;
	
	public LightMemento(int state){
		this.state = state;
	}
	
	public int getState(){
		return state;
	}
	public void setState(int state){
		
		this.state = state;
	}
}