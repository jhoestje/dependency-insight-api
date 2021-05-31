package org.johoco.depinsight.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public abstract class GraphData {

	@Id // db document field: _key
	private String id;

//	@ArangoId // db document field: _id
//    private String arangoId;

	private Date createdDate;

}
