package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.Packaging;
import org.johoco.depinsight.domain.composite.Artifact;

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
@Edge("ofGavp")
public class OfGavp extends GraphData implements GraphEdge {

	@From
	@NonNull
	private Artifact artifact;

	@To
	@NonNull
	private Packaging packaging;

	public static String getName() {
		return "ofGavp";
	}

	public static String getFromName() {
		return Artifact.getDocumentName();
	}

	public static String getToName() {
		return Packaging.getDocumentName();
	}

}
