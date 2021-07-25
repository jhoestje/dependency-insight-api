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
@Document("organizations")
public class Organization extends Entity<OrganizationKey> {

	public Organization(OrganizationKey key) {
		super(key);
	}

	public static String getDocumentName() {
		return "organizations";
	}

	public String getName() {
		return this.getKey().getName();
	}

	public String getUrl() {
		return this.getKey().getUrl();
	}
}
