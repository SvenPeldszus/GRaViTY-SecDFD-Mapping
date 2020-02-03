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
			ByteBuffer.wrap(bytes, i, 8).putDouble(random.random());
		}
		return new SecretKeySpec(bytes , "AES");
	}
	
	public static void main(String[] args) {
		System.out.println(new KeyGenerator().newKey());
	}
}
