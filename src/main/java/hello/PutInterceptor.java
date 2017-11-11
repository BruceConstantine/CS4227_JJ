package hello;

public interface PutInterceptor {
	public void update(HomeServerRequest homeServerRequest);
	public void recieveContextObject(PutContextObject putContextObject);
}
