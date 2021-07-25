package org.johoco.depinsight.domain;

import java.util.List;

import org.johoco.depinsight.domain.key.ContributorKey;

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
@Document("contributors")
public class Contributor extends Entity<ContributorKey> {

	private List<String> roles;
	private String timezone;

	public Contributor(final ContributorKey key) {
		super(key);
	}

	public static String getDocumentName() {
		return "contributors";
	}

	public String getName() {
		return this.getKey().getName();
	}

	public String getEmail() {
		return this.getKey().getEmail();
	}

	public String getUrl() {
		return this.getKey().getUrl();
	}

	public String getOrganization() {
		return this.getKey().getOrganization();
	}

	public String getOrganizationUrl() {
		return this.getKey().getOrganizationUrl();
	}

}
