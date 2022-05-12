package org.johoco.depinsight.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Per https://maven.apache.org/xsd/maven-4.0.0.xsd
 *
 * @author John Hoestje
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contributor {
	private String name;
	private String email;
	private String url;
	private String organization;
	private String organizationUrl;
	private List<String> roles;
	private String timezone;
// properties element <xs:any minOccurs="0" maxOccurs="unbounded" processContents="skip"/>
}
