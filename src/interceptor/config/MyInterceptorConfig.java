package config;
//
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
 

/**
 * ���ڴ�������������	�� �����Ƿ����������ʱ�����������Ĺ��ܺ͸�����
 * 		Ҳ����˵			�� ���е��������������Ƿ����ڳ�����б��벿���ʱ����Ѿ������������
 * ����ǣ� ������IterceptorConfig��ȥ��ȡxml�����ļ�/���������ļ����ã��Ӷ�����ע����������Dispatcher��
 *   ���� Ҫ��Reflect��̬����ȥʵ��һ���ɶ�̬��ɾ����������ȥʵ����������ע�� .>>> �����Ҿ��ò���
 */
/*
class MyInterceptorConfig { 
	//   ����ջ����ָ����������ṩ�ķ���/�����¼���Request������Ӧ�������Ĺ�ϵ -> һ�������Ӧ����Ҫ��ִ�е�������

	//   ������ָ ���ڿ���Ѿ�����ķ����в�ͬ��������ִ�в��ԣ� ���磬�û���½�¼���Ҫ����logging�������֤�ȵȣ�
	//�������ҵ���漰����interceptor�Ƚ϶ࣻȻ���е�ҵ���������ջ��һ�㣬���Ҫ�Բ�ͬ�Ľ���ҵ���߼�������������ӳ��
	private static Map<ServiceDefinedInFramework, MyInterceptorStack> proxyMap = new HashMap<ServiceDefinedInFramework, MyInterceptorStack >();
	  
	//��proxy�������÷���->�Դ�����������������ã�������Ӧ���¼����������Ķ�Ӧ��ϵ.
	public static void //���� Object ?
						bind( ServiceDefinedInFramework serviceInFramework, MyInterceptorStack interceptorStack ) {
		proxyMap.put(serviceInFramework, interceptorStack);
	} 
	
	public Map<ServiceDefinedInFramework, MyInterceptorStack> getProxyMap() {
		return proxyMap;
	}
	
	public static class MyInterceptorStack {  
		private Stack<MyInterceptor> interceptorStack; 	//����һ��������ջ
		
		public MyInterceptorStack() {			
			interceptorStack = new Stack<MyInterceptor>(); 
		}

		public void attach( MyInterceptor interceptor ){
			interceptorStack.push( interceptor );
		}  
		
		public Stack<MyInterceptor> getInterceptorStack(){
			return interceptorStack;
		}
	}
}
*/