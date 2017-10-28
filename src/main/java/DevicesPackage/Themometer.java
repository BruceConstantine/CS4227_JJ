package DevicesPackage;

import Memento.*;
import Visitor.Visitor;

public class Themometer implements Devices{
	int state;
	String name;
	String type;
	double temperature=30;
	
	public Themometer(String type,String name){
		this.type = type;
		this.name = name;
		this.state = -1;
	}
	
	public void accept(Visitor v){
		v.visit(this);
		
	}
	
	public int getState(){
		return state;
	}
	
	public void setState(int state){
		this.state = state; 
	}
	
	public void setTemperature(double newTem){
		this.temperature = newTem;
	}
	
	public double getTemperature(){
		return temperature;
	}
	
	public memento createMemento(){
		return new ThemometerMemento(this.state);
	}
	
	public void restoreMemento(memento m){
		
		this.setState(m.getState());
	}

	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
}
