package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.composite.Artifact;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * This represents the relationship between parent and child artifact or aka
 * POMs
 * 
 * @author John Hoestje
 *
 */
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Getter
@Edge("ofChildArtifact")
public class OfChildArtifact extends GraphData implements GraphEdge {

	@From
	@NonNull
	private Artifact child;

	@To
	@NonNull
	private Artifact parent;

	public static String getName() {
		return "ofChildArtifact";
	}

	public static String getFromName() {
		return Artifact.getDocumentName();
	}

	public static String getToName() {
		return Artifact.getDocumentName();
	}

}
