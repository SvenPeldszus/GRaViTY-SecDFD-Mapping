
public class Main {
	
	public static void main(String[] args) {
		Main main = new Main();
				
		String joined = main.join(main.getAsset(), getValue());
		main.exit(joined);
	}

	private static String getValue() {
		return "";
	}

	private Asset getAsset() {
		return new Asset();
	}
	
	String join(Asset a, String s) {
		return (a.value + s);
	}
		
	void exit(String a) {
		
	}

}
