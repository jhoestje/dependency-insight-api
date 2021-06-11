package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.Classifier;
import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.composite.Artifact;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper = true)
@Edge("ofClassifier")
public class OfClassifier extends GraphData implements GraphEdge {

	@From
	@NonNull
	private Classifier classifier;

	@To
	@NonNull
	private Artifact artifact;

	public static String getName() {
		return "ofClassifier";
	}

	public static String getFromName() {
		return Classifier.getName();
	}

	public static String getToName() {
		return Artifact.getName();
	}

}
