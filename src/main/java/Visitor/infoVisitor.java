package Visitor;

import DevicesPackage.*;

public class InfoVisitor implements Visitor {
	public void visit(LightSensor ls){
		if(ls.getIllumination()>350.00){
			System.out.println("you should turn down the light to protect your eye");
		}
		else if(ls.getIllumination()<300.00){
			System.out.println("you should turn up the light to protect your eye");
		}
	}
	
	public void visit(TemperatureSensor ts){
		if(ts.getTemperature()>23.00){
			System.out.println("temperature is higher than comfortable temperature");
		}
		
		else if(ts.getTemperature()<18.00){
			System.out.println("temperature is lower than comfortable temperature");
		}
	}

	public void visit(Light light) {
		
	}

	public void visit(Themometer t) {
		
	}
}
