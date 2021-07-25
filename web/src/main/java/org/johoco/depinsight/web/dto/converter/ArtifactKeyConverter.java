package org.johoco.depinsight.web.dto.converter;

import org.apache.commons.lang3.StringUtils;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.dto.ArtifactKeyDTO;
import org.johoco.depinsight.dto.Pom;

/**
 * 
 * @author John Hoestje
 *
 */
public class ArtifactKeyConverter {
	public static ArtifactKey convert(final ArtifactKeyDTO dto) {
		return new ArtifactKey("java", dto.getGroupId(), dto.getArtifactId(), dto.getVersion(), dto.getPackaging());
	}

	/**
	 * Some values may be inherited.
	 * 
	 * @param dto
	 * @return
	 */
	public static ArtifactKey convert(final Pom dto) {
		if (StringUtils.isBlank(dto.getGroupId()) && dto.getParent() != null) {
			dto.setGroupId(dto.getParent().getGroupId());
		}
		if (StringUtils.isBlank(dto.getVersion()) && dto.getParent() != null) {
			dto.setVersion(dto.getParent().getVersion());
		}

		return new ArtifactKey("java", dto.getGroupId(), dto.getArtifactId(), dto.getVersion(), dto.getPackaging());
	}

//	public static ArtifactDTO convert(final ArtifactKey ak) {
//		return ArtifactDTO.builder().language("").groupId(a.getKey().getGroupId())
//				.artifactId(a.getKey().getArtifactId()).version(a.getKey().getVersion())
//				.packaging(a.getKey().getPackaging()).build();
//	}
}
