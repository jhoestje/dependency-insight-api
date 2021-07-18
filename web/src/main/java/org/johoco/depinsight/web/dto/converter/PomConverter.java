package org.johoco.depinsight.web.dto.converter;

import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.dto.Pom;

public class PomConverter {
	public static Pom convert(final Artifact a) {
		// .language("")
		// .createdDate(a.getCreatedDate())
		// .lastUpdatedDate(a.getLastUpdatedDate())
		return Pom.builder().groupId(a.getKey().getGroupId()).artifactId(a.getKey().getArtifactId())
				.version(a.getKey().getVersion()).packaging(a.getKey().getPackaging()).build();
	}

	public static Artifact convert(final Pom p) {
		ArtifactKey ak = ArtifactKey.builder().language(p.getLanguage()).groupId(p.getGroupId())
				.artifactId(p.getArtifactId()).version(p.getVersion()).packaging(p.getPackaging()).build();

		Artifact a = new Artifact(ak);

		a.setDescription(p.getDescription());
		a.setInceptionYear(p.getInceptionYear());

		// finish this

		return a;
	}
}
