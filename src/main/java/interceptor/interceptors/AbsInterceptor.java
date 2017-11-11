package interceptor.interceptors;
 
import interceptor.message.*; 
//define the integrated out-of-band services into this interface
public interface AbsInterceptor { 

	void intercept( Message message  );
}
