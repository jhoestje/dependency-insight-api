package org.johoco.depinsight.domain;

import com.arangodb.springframework.annotation.Document;

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
}
