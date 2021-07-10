package org.johoco.depinsight.web.dto.converter;

import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.dto.ArtifactKeyDTO;
import org.johoco.depinsight.dto.Pom;

public class ArtifactKeyConverter {
	public static ArtifactKey convert(final ArtifactKeyDTO dto) {
		return new ArtifactKey("java", dto.getGroupId(), dto.getArtifactId(), dto.getVersion(), dto.getPackaging());
	}

	public static ArtifactKey convert(final Pom dto) {
		return new ArtifactKey("java", dto.getGroupId(), dto.getArtifactId(), dto.getVersion(), dto.getPackaging());
	}

//	public static ArtifactDTO convert(final ArtifactKey ak) {
//		return ArtifactDTO.builder().language("").groupId(a.getKey().getGroupId())
//				.artifactId(a.getKey().getArtifactId()).version(a.getKey().getVersion())
//				.packaging(a.getKey().getPackaging()).build();
//	}
}
