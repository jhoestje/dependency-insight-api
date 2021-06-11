package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.Packaging;
import org.johoco.depinsight.domain.composite.Artifact;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper = true)
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
		return Artifact.getName();
	}

	public static String getToName() {
		return Packaging.getName();
	}

}