package Sensors;

public class SiemensLightSensor implements I_LightSensor{
	String name;
	public SiemensLightSensor(String name){
		this.name = name;
	}
	public void show(){
		System.out.println("this is siemens light sensor");
	}
}
