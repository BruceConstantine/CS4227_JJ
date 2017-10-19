package Devices;

public class SiemensThemometer implements I_Themometer {
	String name;
	public SiemensThemometer(String name){
		this.name = name;
	}
	public void show(){
		System.out.println("this is siemens themometer");
	}
}
