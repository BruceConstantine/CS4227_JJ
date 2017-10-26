package DevicesPackage;

public class Themometer implements Devices{
	int state;
	String name;
	
	public Themometer(String name){
		this.name = name;
	}
	
	public int getState(){
		return state;
	}
	
	public void setState(int state){
		this.state = state; 
	}
}
