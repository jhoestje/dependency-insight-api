package org.johoco.depinsight.web.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.johoco.depinsight.domain.Developer;

/**
 * 
 * @author John Hoestje
 *
 */
public class DeveloperConverter {
	public static Developer convert(final org.johoco.depinsight.dto.Developer dto) {
		if (dto != null) {
//			DeveloperKey key = new DeveloperKey(dto.getId());
			Developer entity = new Developer();
			entity.setId(dto.getId());
			entity.setName(dto.getName());
			entity.setEmail(dto.getEmail());
			entity.setOrganization(dto.getOrganization());
			entity.setOrganizationUrl(dto.getOrganizationUrl());

			return entity;
		}
		return null;
	}

	public static org.johoco.depinsight.dto.Developer convert(final Developer entity) {
		if (entity != null) {
			org.johoco.depinsight.dto.Developer dto = new org.johoco.depinsight.dto.Developer();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setEmail(entity.getEmail());
			dto.setOrganization(entity.getOrganization());
			dto.setOrganizationUrl(entity.getOrganizationUrl());
			return dto;
		}
		return null;
	}

	public static List<Developer> convert(List<org.johoco.depinsight.dto.Developer> dtos) {
		if (dtos != null) {
			List<Developer> entities = new ArrayList<>();
			for (org.johoco.depinsight.dto.Developer dto : dtos) {
				entities.add(convert(dto));
			}
			return entities;
		}
		return null;
	}

}
