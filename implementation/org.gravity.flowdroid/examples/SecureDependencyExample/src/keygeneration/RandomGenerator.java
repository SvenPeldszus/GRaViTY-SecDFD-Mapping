package keygeneration;

import java.security.SecureRandom;

public class RandomGenerator implements RandomNumber {

	@Override
	public Double random() {
		return new SecureRandom().nextDouble();
	}
	
	public Double leaksecret(Double secretRandom) {
		Double stolensecret = secretRandom + 13.0;
		return stolensecret;
	}

}
