package org.johoco.depinsight.web.dto.converter;

import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.dto.ArtifactKeyDTO;
import org.johoco.depinsight.dto.Pom;

public class ArtifactConverter {
	public static Artifact convert(final Pom dto) {
		final ArtifactKey key = ArtifactKeyConverter.convert(dto);
		return new Artifact(key);
	}

	public static Pom convert(final Artifact a) {
		// .language("")
		// .createdDate(a.getCreatedDate())
		// .lastUpdatedDate(a.getLastUpdatedDate())
		return Pom.builder().groupId(a.getKey().getGroupId()).artifactId(a.getKey().getArtifactId())
				.version(a.getKey().getVersion()).packaging(a.getKey().getPackaging()).build();
	}

	public static ArtifactKeyDTO convertToKey(final Artifact a) {
		return ArtifactKeyDTO.builder().language("").groupId(a.getKey().getGroupId())
				.artifactId(a.getKey().getArtifactId()).version(a.getKey().getVersion())
				.packaging(a.getKey().getPackaging()).createdDate(a.getCreatedDate())
				.lastUpdatedDate(a.getLastUpdatedDate()).build();
	}

	public static Artifact convert(ArtifactKeyDTO artifactDto) {
		// TODO Auto-generated method stub
		return null;
	}
}
