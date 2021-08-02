package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.Build;
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
 * 
 * @author John Hoestje
 *
 */
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Getter
@Edge("ofBuild")
public class OfBuild extends GraphData implements GraphEdge {

	@From
	@NonNull
	private Artifact artifact;

	@To
	@NonNull
	private Build build;

	public static String getName() {
		return "ofBuild";
	}

	public static String getFromName() {
		return Artifact.getDocumentName();
	}

	public static String getToName() {
		return Build.getDocumentName();
	}

}
