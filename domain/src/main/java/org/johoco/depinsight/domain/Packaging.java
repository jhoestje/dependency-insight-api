package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.relationship.OfVersion;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Document("packagings")
public class Packaging extends GraphData {

	private String value;

	public static String getName() {
		return "packagings";
	}
	
	@Relations(edges = OfVersion.class, lazy = false)
	private Version version;
}
