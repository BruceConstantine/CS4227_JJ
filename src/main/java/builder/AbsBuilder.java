package builder;

public interface AbsBuilder {
	
	AbsBuilder createInstance();
	SystemComponent build();
	 
}
