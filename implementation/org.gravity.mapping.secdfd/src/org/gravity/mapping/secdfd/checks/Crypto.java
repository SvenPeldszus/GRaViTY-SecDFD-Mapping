/**
 * 
 */
package org.gravity.mapping.secdfd.checks;

import java.util.Optional;

import org.secdfd.model.ResponsibilityType;

/**
 * @author katjat
 *
 */
public class Crypto {
	private ResponsibilityType type;
	private Optional<String> file;

	public Crypto(ResponsibilityType type, Optional<String> file) {
		this.type = type;
		this.file = file;
	}
	public Crypto(ResponsibilityType type) {
		this.type = type;
	}
	public Optional<String> getFileName() {
		return file;
	}
	public ResponsibilityType getType() {
		return type;
	}
}
