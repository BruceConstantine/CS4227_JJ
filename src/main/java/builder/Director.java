package builder;

public class Director {
	
	private AbsBuilder builder;
	
	public Director(AbsBuilder builder){
		this.builder = builder;
	}
	
	public SystemComponent createAComponent() {
		
		return builder.build();
	}
	
}
