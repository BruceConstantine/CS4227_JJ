package Memento;

public class ThemometerMemento implements memento{
private int state;
	
	public ThemometerMemento(int state){
		this.state = state;
	}
	
	public int getState(){
		return state;
	}
	public void setState(int state){
		
		this.state = state;
	}
}
