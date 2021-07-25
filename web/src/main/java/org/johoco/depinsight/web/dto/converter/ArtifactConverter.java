package org.johoco.depinsight.web.dto.converter;

import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.dto.ArtifactKeyDTO;
import org.johoco.depinsight.dto.Pom;

public class ArtifactConverter {
	public static Artifact convert(final Pom dto) {
		final ArtifactKey key = ArtifactKeyConverter.convert(dto);
		Artifact a = new Artifact(key);
		a.setOrganization(OrganizationConverter.convert(dto.getOrganization()));
		a.setLicenses(LicenseConverter.convert(dto.getLicenses()));

		return a;
	}

	public static ArtifactKeyDTO convertToKey(final Artifact a) {
		return ArtifactKeyDTO.builder().language("").groupId(a.getKey().getGroupIdValue())
				.artifactId(a.getKey().getArtifactIdValue()).version(a.getKey().getVersion())
				.packaging(a.getKey().getPackaging()).createdDate(a.getCreatedDate())
				.lastUpdatedDate(a.getLastUpdatedDate()).build();
	}

	public static Artifact convert(ArtifactKeyDTO artifactDto) {
		ArtifactKey ak = ArtifactKey.builder().groupIdValue(artifactDto.getGroupId())
				.artifactIdValue(artifactDto.getArtifactId()).version(artifactDto.getVersion())
				.language(artifactDto.getLanguage()).packaging(artifactDto.getPackaging()).build();

		return new Artifact(ak);
	}
}
