package hello;

import java.util.ArrayList;
import java.util.List;

public class PutDispatcher implements PutServerDispatcher{
	private List<PutInterceptor> putDisListener =  new ArrayList<PutInterceptor>();

	@Override
	public void notify(HomeServerRequest homeServerRequest) {
		for(int i = 0 ; i < putDisListener.size(); i ++)
			putDisListener.get(i).update(homeServerRequest);
	}
	
	public void attach(PutInterceptor putInterceptor) {
		
		putInterceptor.recieveContextObject(new PutContextObject());
		putDisListener.add(putInterceptor);
	}
}
