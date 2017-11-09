package Memento;

public class Caretaker {
	private I_Memento m;
	
	public I_Memento getMemento(){
		return m;
	}
	
	public void setmemento(I_Memento m){
		this.m=m;
	}
	
	
}
