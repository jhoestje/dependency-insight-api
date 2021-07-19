package org.johoco.depinsight.domain;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.ArangoId;

import lombok.Data;

@Data
public abstract class GraphData {

	@Id // db document field: _key -- ex:1051180
	private String id;

	@ArangoId // db document field: _id -- ex:groupIds/1051180
	private String arangoId;

	private DateTime createdDate;
	private DateTime lastUpdatedDate;

}
