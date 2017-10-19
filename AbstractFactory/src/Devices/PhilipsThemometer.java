package Devices;

public class PhilipsThemometer implements I_Themometer{
	String name;
	public PhilipsThemometer(String name){
		this.name = name;
	}
	public void show(){
		System.out.println("this is philips themometer");
	}
}
