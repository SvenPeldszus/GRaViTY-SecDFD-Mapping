
public class Main {
	
	public void start() {
		method1(new Asset());
	}
	
	void method1(Asset a) {
		Asset l = method2(a);
		exit(l);
	}
	
	Asset method2(Asset a) {
		return a;
	}
	
	void exit(Asset a) {
		
	}

}
