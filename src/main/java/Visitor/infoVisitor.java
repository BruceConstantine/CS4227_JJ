package Visitor;


import homeServer.deviceManager.devicesPackage.*; 


public class infoVisitor implements Visitor {
	
	public void visit(Light light){
		if(light.getIllumination()>350.00){
			System.out.println("you should turn down the light to protect your eye");
		}
		else if(light.getIllumination()<300.00){
			System.out.println("you should turn up the light to protect your eye");
		}
	}
	
	public void visit(Themometer t){
		if(t.getTemperature()>23.00){
			System.out.println("temperature is higher than comfortable temperature");
		}
		
		else if(t.getTemperature()<18.00){
			System.out.println("temperature is lower than comfortable temperature");
		}
	}
}
