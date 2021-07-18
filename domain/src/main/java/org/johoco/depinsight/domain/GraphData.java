package org.johoco.depinsight.domain;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public abstract class GraphData {

	@Id // db document field: _key
	private String id;

//	@ArangoId // db document field: _id
//    private String arangoId;

	private DateTime createdDate;
	private DateTime lastUpdatedDate;

}
