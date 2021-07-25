package org.johoco.depinsight.domain;

import java.security.cert.Extension;
import java.util.List;

import org.johoco.depinsight.domain.composite.Plugin;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * Not sure how to store this... with links to plugins.
 * 
 * @author John Hoestje
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document("builds")
public class Build extends GraphData {

	private String sourceDirectory;
	private String scriptSourceDirectory;
	private String testSourceDirectory;
	private String outputDirectory;
	private String testOutputDirectory;
	private List<Extension> extensions;
	private String defaultGoal;
	private List<Resources> resources;
	private List<Resources> testResources;
	private String directory;
	private String finalName;
	private List<String> filters;
	private List<Plugin> pluginManagement;
	private List<Plugin> plugins;

	@NonNull
	private List<String> maven;

	public static String getDocumentName() {
		return "builds";
	}

}
