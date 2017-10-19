package Sensors;

public class SiemensThemomstateSensor implements I_ThemomstateSensor{
	String name;
	public SiemensThemomstateSensor(String name){
		this.name = name;
	}
	public void show(){
		System.out.println("this is siemens Themomstate sensor");
	}
}
