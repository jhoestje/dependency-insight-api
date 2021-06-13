package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.Version;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Getter
@Edge("ofArtifactId")
public class OfArtifactId extends GraphData implements GraphEdge {

	@From
	@NonNull
	private Version version;

	@To
	@NonNull
	private ArtifactId artifactId;

	public static String getName() {
		return "ofArtifactId";
	}

	public static String getFromName() {
		return Version.getName();
	}

	public static String getToName() {
		return ArtifactId.getName();
	}

}
