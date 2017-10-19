package Sensors;

public class PhilipsLightSensor implements I_LightSensor{
	String name;
	public PhilipsLightSensor(String name){
		this.name = name;
	}
	public void show(){
		System.out.println("this is philips sensor");
	}
}
