package org.johoco.depinsight.dto;

import lombok.Data;

@Data
public class Developer {

	private String id;
	private String name;
	private String email;
	// some don't follow the schema:
	private String organization;
	private String organizationUrl;
}
