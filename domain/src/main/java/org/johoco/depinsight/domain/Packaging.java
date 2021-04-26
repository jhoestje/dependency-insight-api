package org.johoco.depinsight.domain;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//NodeEntity
@Document
public class Packaging { // extends GraphData {

	// neo4j attributes
//	@Id
	private String value;
}
