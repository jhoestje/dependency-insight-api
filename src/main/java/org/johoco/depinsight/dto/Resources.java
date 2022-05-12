package org.johoco.depinsight.dto;

import java.util.List;

import lombok.Data;

/**
 * Per https://maven.apache.org/xsd/maven-4.0.0.xsd
 * 
 * @author John Hoestje
 *
 */
@Data
public class Resources {
	private String targetPath;
	private String filtering;
	private String directory;
	// includes pattern: A list of patterns to exclude, e.g.
	// <code>**&#47;*.xml</code>
	// IncludesPattern or String?
	List<String> includes;
	// excludes pattern: A list of patterns to excludes, e.g.
	// <code>**&#47;*.xml</code>
	// ExcludesPattern or String?
	List<String> excludes;
}
