package Devices;

public class SiemensLight implements I_Light{
	String name;
	public SiemensLight(String name){
		this.name = name;
	}
	public void show(){
		System.out.println("this is siemens light");
	}
}
