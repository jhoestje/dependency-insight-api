package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.Dependency;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper = true)
@Edge("ofBackingArtifact")
public class OfBackingArtifact extends GraphData implements GraphEdge {

	@From
	@NonNull
	private Dependency dependency;

	@To
	@NonNull
	private Artifact backingArtifact;

	public static String getName() {
		return "ofBackingArtifact";
	}

	public static String getFromName() {
		return Dependency.getName();
	}

	public static String getToName() {
		return Artifact.getName();
	}

}
