package org.johoco.depinsight.dto;


import java.util.List;

import lombok.Data;

@Data
public class ComponentsDTO {
//	{
//		  "items": [
//		   
//		  ],
//		  "continuationToken": "string"
//		}
	
	
	private String continuationToken;
	private List<ComponentDTO> items;
}
