package Sensors;

public class PhilipsThemomstateSensor implements I_ThemomstateSensor{
	String name;
	public PhilipsThemomstateSensor(String name){
		this.name = name;
	}
	public void show(){
		System.out.println("this is philips themomstate sensor");
	}
}
