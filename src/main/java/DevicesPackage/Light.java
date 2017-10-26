package DevicesPackage;

public class Light implements Devices{
	int state;
	String name;
	
	public Light(String name){
		this.name = name;
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
	
}
