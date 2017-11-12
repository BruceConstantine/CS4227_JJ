package Visitor;

import DevicesPackage.*;

public class InfoVisitor implements Visitor {
	public void visit(Version1_LightSensor ls){
		
	}
	
	public void visit(Version1_TemperatureSensor ts){
		
	}

	public void visit(Version1_Light light) {
		if(light.getIllumination()>350.00){
			System.out.println("you should turn down the light to protect your eye");
		}
		else if(light.getIllumination()<300.00){
			System.out.println("you should turn up the light to protect your eye");
		}
	}

	public void visit(Version1_Themometer t) {
		if(t.getTemperature()>23.00){
			System.out.println("temperature is higher than comfortable temperature");
		}
		
		else if(t.getTemperature()<18.00){
			System.out.println("temperature is lower than comfortable temperature");
		}
	}
	
	
	
	public void visit(Version2_LightSensor ls){
		
	}
	
	public void visit(Version2_TemperatureSensor ts){
		
	}

	public void visit(Version2_Light light) {
		if(light.getIllumination()>350.00){
			System.out.println("you should turn down the light to protect your eye");
		}
		else if(light.getIllumination()<300.00){
			System.out.println("you should turn up the light to protect your eye");
		}
	}

	public void visit(Version2_Themometer t) {
		if(t.getTemperature()>23.00){
			System.out.println("temperature is higher than comfortable temperature");
		}
		
		else if(t.getTemperature()<18.00){
			System.out.println("temperature is lower than comfortable temperature");
		}
	}
}
