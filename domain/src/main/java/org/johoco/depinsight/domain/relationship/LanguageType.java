package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper = true)
@Edge("language_type")
public class LanguageType extends GraphData {

	@From
	@NonNull
	private GroupId groupId;

	@To
	@NonNull
	private Language language;

}
