package org.johoco.depinsight.web.dto.converter;

import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.web.dto.ArtifactDTO;

public class ArtifactKeyConverter {
	public static ArtifactKey convert(final ArtifactDTO dto) {
		return new ArtifactKey(dto.getGroupId(), dto.getArtifactId(), dto.getVersion(), dto.getPackaging());
	}

//	public static ArtifactDTO convert(final ArtifactKey ak) {
//		return ArtifactDTO.builder().language("").groupId(a.getKey().getGroupId())
//				.artifactId(a.getKey().getArtifactId()).version(a.getKey().getVersion())
//				.packaging(a.getKey().getPackaging()).build();
//	}
}
