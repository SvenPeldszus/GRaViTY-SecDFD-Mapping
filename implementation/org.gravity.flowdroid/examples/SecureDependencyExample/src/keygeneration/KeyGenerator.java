package keygeneration;

import java.nio.ByteBuffer;
import java.security.Key;

import javax.crypto.spec.SecretKeySpec;

import org.gravity.security.annotations.requirements.Critical;

@Critical(secrecy = {"random():double"})
public class KeyGenerator {

	public Key newKey() {
		RandomNumber random = new RandomGenerator();
		byte[] bytes = new byte[4096];
		for(int i = 0; i< bytes.length; i += 8) {
			Double secret = random.random();
			ByteBuffer.wrap(bytes, i, 8).putDouble(secret);
			Double a = random.leaksecret(secret);
		}
		return new SecretKeySpec(bytes , "AES");
	}
	
	public static void main(String[] args) {
		System.out.println(new KeyGenerator().newKey());
	}
}
