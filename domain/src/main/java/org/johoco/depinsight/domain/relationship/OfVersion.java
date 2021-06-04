package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = true)
//@RelationshipEntity(type = "PART_OF_GROUP")
@Edge("ofVersion")
public class OfVersion extends GraphData implements GraphEdge {

	@From
	@NonNull
	private GroupId groupId;

	@To
	@NonNull
	private Language language;

	public static String getName() {
		return "ofVersion";
	}

	public static String getFromName() {
		return GroupId.getName();
	}

	public static String getToName() {
		return Language.getName();
	}

	// neo4j annotations
//	@Id
//	@GeneratedValue
//	private Long relationshipId;
//	
//	@StartNode
//	private Packaging packaging;
//	
//	@EndNode
//	private Version version;

}
