package org.johoco.depinsight.web.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.johoco.depinsight.domain.PluginRepository;
import org.johoco.depinsight.domain.key.RepositoryKey;

/**
 * 
 * @author John Hoestje
 *
 */
public class PluginRepositoryConverter {
	public static PluginRepository convert(final org.johoco.depinsight.dto.Repository dto) {
		if (dto != null) {
			RepositoryKey key = new RepositoryKey(dto.getUrl());
			PluginRepository entity = new PluginRepository(key);
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			entity.setLayout(dto.getLayout());
			entity.setReleases(RepositoryPolicyConverter.convert(dto.getReleases()));
			entity.setSnapshots(RepositoryPolicyConverter.convert(dto.getSnapshots()));
			return entity;
		}
		return null;
	}

	public static org.johoco.depinsight.dto.Repository convert(final PluginRepository entity) {
		if (entity != null) {
			org.johoco.depinsight.dto.Repository dto = org.johoco.depinsight.dto.Repository.builder().id(entity.getId())
					.name(entity.getName()).url(entity.getKey().getUrl()).layout(entity.getLayout())
					.releases(RepositoryPolicyConverter.convert(entity.getReleases()))
					.snapshots(RepositoryPolicyConverter.convert(entity.getSnapshots())).build();
			return dto;
		}
		return null;
	}

	public static List<PluginRepository> convert(List<org.johoco.depinsight.dto.Repository> dtos) {
		if (dtos != null) {
			List<PluginRepository> entities = new ArrayList<>();
			for (org.johoco.depinsight.dto.Repository dto : dtos) {
				entities.add(convert(dto));
			}
			return entities;
		}
		return null;
	}

	public static List<org.johoco.depinsight.dto.Repository> convertz(final List<PluginRepository> entities) {
		if (entities != null) {
			List<org.johoco.depinsight.dto.Repository> dtos = new ArrayList<>();
			for (PluginRepository entity : entities) {
				dtos.add(convert(entity));
			}
			return dtos;
		}
		return null;
	}

}
