package interceptor.config;

import java.util.Iterator;
import java.util.Stack;
 
import interceptor.interceptors.AbsInterceptor;

public class InterceptorStack implements Iterable<AbsInterceptor> {  
	private Stack<AbsInterceptor> interceptorStack; 	//Define a interceptor stack
	
	public InterceptorStack() {			
		interceptorStack = new Stack<AbsInterceptor>(); 
	}
	
	public InterceptorStack( Stack<AbsInterceptor> interceptorStack) {			
		this.interceptorStack = interceptorStack; 
	}
	
	public void push( AbsInterceptor interceptor ){
		interceptorStack.push( interceptor );
	}  

	public Stack<AbsInterceptor> getInterceptorStack(){
		return interceptorStack;
	}
	
	public boolean isEmpty(){
		return interceptorStack.isEmpty();
	}

	@Override
	public Iterator<AbsInterceptor> iterator() { 
		return new InterceptorIterator() ;
	}
	
	private class InterceptorIterator implements Iterator<AbsInterceptor> {

		private Stack<AbsInterceptor> interceptorStack_ite;
		
		public InterceptorIterator() {
			interceptorStack_ite = new Stack();
			interceptorStack_ite.addAll(interceptorStack);
		}
		
		@Override
		public boolean hasNext() {
			return !interceptorStack_ite.isEmpty();
		}

		@Override
		public AbsInterceptor next() { 
			if(hasNext())
				return interceptorStack_ite.pop();
			else
				return null; 
		}
		
	}
	
}