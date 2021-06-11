package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.Packaging;
import org.johoco.depinsight.domain.Version;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper = true)
@Edge("ofVersion")
public class OfVersion extends GraphData implements GraphEdge {

	@From
	@NonNull
	private Packaging packaging;

	@To
	@NonNull
	private Version version;

	public static String getName() {
		return "ofVersion";
	}

	public static String getFromName() {
		return Packaging.getName();
	}

	public static String getToName() {
		return Version.getName();
	}

}
