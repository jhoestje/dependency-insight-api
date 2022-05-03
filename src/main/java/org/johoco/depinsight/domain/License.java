package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.LicenseKey;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document("licenses")
public class License extends Entity<LicenseKey> {

	private String distribution;

	public License(@NonNull final LicenseKey key) {
		super(key);
	}

	public static String getDocumentName() {
		return "licenses";
	}

	public String getName() {
		return this.getKey().getName();
	}

	public String getUrl() {
		return this.getKey().getUrl();
	}

}
