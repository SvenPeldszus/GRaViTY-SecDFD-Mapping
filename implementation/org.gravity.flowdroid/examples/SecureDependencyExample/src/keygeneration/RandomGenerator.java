package keygeneration;

import java.security.SecureRandom;

public class RandomGenerator implements RandomNumber {

	@Override
	public Double random() {
		return new SecureRandom().nextDouble();
	}

}
