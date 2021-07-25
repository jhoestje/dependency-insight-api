package org.johoco.depinsight.web.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.johoco.depinsight.domain.Contributor;

/**
 * 
 * @author John Hoestje
 *
 */
public class ContributorConverter {
	public static Contributor convert(final org.johoco.depinsight.dto.Contributor dto) {
		if (dto != null) {
			Contributor entity = Contributor.builder().name(dto.getName()).email(dto.getEmail()).url(dto.getUrl())
					.organization(dto.getOrganization()).organizationUrl(dto.getOrganizationUrl()).build();
			return entity;
		}
		return null;
	}

	public static org.johoco.depinsight.dto.Contributor convert(final Contributor entity) {
		if (entity != null) {
			org.johoco.depinsight.dto.Contributor dto = org.johoco.depinsight.dto.Contributor.builder()
					.name(entity.getName()).email(entity.getEmail()).url(entity.getUrl())
					.organization(entity.getOrganization()).organizationUrl(entity.getOrganizationUrl()).build();
			return dto;
		}
		return null;
	}

	public static List<Contributor> convert(List<org.johoco.depinsight.dto.Contributor> dtos) {
		if (dtos != null) {
			List<Contributor> entities = new ArrayList<>();
			for (org.johoco.depinsight.dto.Contributor dto : dtos) {
				entities.add(convert(dto));
			}
			return entities;
		}
		return null;
	}

}
