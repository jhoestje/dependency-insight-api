package org.johoco.depinsight.domain;

import java.util.List;

import org.johoco.depinsight.domain.key.CiManagementKey;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Maybe just store this on Artifact.
 * 
 * @author John Hoestje
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document("ciManagements")
public class CiManagement extends Entity<CiManagementKey> {

	private String system;
	List<Notifier> notifiers;

	public CiManagement(final CiManagementKey key) {
		super(key);
	}

	public static String getDocumentName() {
		return "ciManagements";
	}

}
