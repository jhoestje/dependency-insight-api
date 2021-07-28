package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.IssueManagement;
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
@Edge("ofIssueManagement")
public class OfIssueManagement extends GraphData implements GraphEdge {

	@From
	@NonNull
	private Artifact artifact;

	@To
	@NonNull
	private IssueManagement issueManagement;

	public static String getName() {
		return "ofIssueManagement";
	}

	public static String getFromName() {
		return Artifact.getDocumentName();
	}

	public static String getToName() {
		return IssueManagement.getDocumentName();
	}

}
