package Devices;

public class PhilipsLight implements I_Light{
	String name;
	
	public PhilipsLight(String name){
		this.name = name;
	}
	public void show(){
		System.out.println("this is philips light");
	}
}
