package org.johoco.depinsight.web.dto.converter;

import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.web.dto.ArtifactDTO;

public class ArtifactConverter {
	public static Artifact convert(final ArtifactDTO dto) {
		final ArtifactKey key = ArtifactKeyConverter.convert(dto);
		return new Artifact(key);
	}

	public static ArtifactDTO convert(final Artifact a) {
		return ArtifactDTO.builder().language("").groupId(a.getKey().getGroupId())
				.artifactId(a.getKey().getArtifactId()).version(a.getKey().getVersion())
				.packaging(a.getKey().getPackaging()).createdDate(a.getCreatedDate())
				.lastUpdatedDate(a.getLastUpdatedDate()).build();
	}
}
