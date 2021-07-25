package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.OrganizationKey;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document("extensions")
public class Extension extends Entity<OrganizationKey> {

	public Extension(OrganizationKey key) {
		super(key);
	}

	public static String getDocumentName() {
		return "extensions";
	}

//	public String getName() {
//		return this.getKey().getName();
//	}
//
//	public String getUrl() {
//		return this.getKey().getUrl();
//	}
}
