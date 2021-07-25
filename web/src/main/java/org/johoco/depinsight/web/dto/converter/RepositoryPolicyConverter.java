package org.johoco.depinsight.web.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.johoco.depinsight.domain.RepositoryPolicy;

/**
 * 
 * @author John Hoestje
 *
 */
public class RepositoryPolicyConverter {
	public static RepositoryPolicy convert(final org.johoco.depinsight.dto.RepositoryPolicy dto) {
		if (dto != null) {

			RepositoryPolicy entity = RepositoryPolicy.builder().enabled(dto.getEnabled())
					.updatePolicy(dto.getUpdatePolicy()).checksumPolicy(dto.getChecksumPolicy()).build();
			return entity;
		}
		return null;
	}

	public static org.johoco.depinsight.dto.RepositoryPolicy convert(final RepositoryPolicy entity) {
		if (entity != null) {
			org.johoco.depinsight.dto.RepositoryPolicy dto = org.johoco.depinsight.dto.RepositoryPolicy.builder()
					.enabled(entity.getEnabled()).updatePolicy(entity.getUpdatePolicy())
					.checksumPolicy(entity.getChecksumPolicy()).build();
			return dto;
		}
		return null;
	}

	public static List<RepositoryPolicy> convert(List<org.johoco.depinsight.dto.RepositoryPolicy> dtos) {
		if (dtos != null) {
			List<RepositoryPolicy> entities = new ArrayList<>();
			for (org.johoco.depinsight.dto.RepositoryPolicy dto : dtos) {
				entities.add(convert(dto));
			}
			return entities;
		}
		return null;
	}

	public static List<org.johoco.depinsight.dto.RepositoryPolicy> convertz(final List<RepositoryPolicy> entities) {
		if (entities != null) {
			List<org.johoco.depinsight.dto.RepositoryPolicy> dtos = new ArrayList<>();
			for (RepositoryPolicy entity : entities) {
				dtos.add(convert(entity));
			}
			return dtos;
		}
		return null;
	}

}
