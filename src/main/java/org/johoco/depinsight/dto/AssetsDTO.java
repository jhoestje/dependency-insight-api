package org.johoco.depinsight.dto;


import java.util.List;

import lombok.Data;

@Data
public class AssetsDTO {
//	{
//		  "items": [
//		   
//		  ],
//		  "continuationToken": "string"
//		}
	
	
	private String continuationToken;
	private List<AssetDTO> items;
}
