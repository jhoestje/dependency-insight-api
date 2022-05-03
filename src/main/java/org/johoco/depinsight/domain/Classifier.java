package org.johoco.depinsight.domain;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Document("classifiers")
public class Classifier extends GraphData {

	private String value;

	public static String getDocumentName() {
		return "classifiers";
	}
}
