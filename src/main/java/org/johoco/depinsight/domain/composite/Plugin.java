package org.johoco.depinsight.domain.composite;

import java.util.List;

import org.johoco.depinsight.domain.Entity;
import org.johoco.depinsight.domain.PluginExecution;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;

import com.arangodb.springframework.annotation.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author John Hoestje
 *
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@Document("plugins")
public class Plugin extends Entity<ArtifactKey> {
	private String groupId;
	private String artifactId;
	private String version;
	private String extensions;
	List<PluginExecution> executions;
	// aether
	List<Dependency> dependencies;
	// goals element per XSD: <b>Deprecated</b>. Unused by Maven
	private String inherited;
	// configuration element per XSD: <xs:any minOccurs="0" maxOccurs="unbounded"
	// processContents="skip"/>

	public Plugin(ArtifactKey key) {
		super(key);
	}

	public static String getDocumentName() {
		return "plugins";
	}

}
