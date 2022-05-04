package org.johoco.depinsight.dto;


import java.util.List;

import lombok.Data;

@Data
public class ComponentDTO {
	private String id;
    private String repository;
    private String format;
	private String group;
	private String name;
	private String version;
	private List<AssetDTO> assets;
    
//	{
//	      "id": "string",
//	      "repository": "string",
//	      "format": "string",
//	      "group": "string",
//	      "name": "string",
//	      "version": "string",
//	      "assets": [
//	        {
//	          "downloadUrl": "string",
//	          "path": "string",
//	          "id": "string",
//	          "repository": "string",
//	          "format": "string",
//	          "checksum": {
//	            "additionalProp1": {},
//	            "additionalProp2": {},
//	            "additionalProp3": {}
//	          },
//	          "contentType": "string",
//	          "lastModified": "2021-07-08T16:15:55.568Z"
//	        }
//	      ]
//	    }
}
