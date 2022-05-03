package org.johoco.depinsight.domain;

import java.util.List;

import com.arangodb.springframework.annotation.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("contributors")
public class Contributor extends GraphData {

	private String name;
	private String email;
	private String url;
	private String organization;
	private String organizationUrl;
	private List<String> roles;
	private String timezone;

	public static String getDocumentName() {
		return "contributors";
	}

}
