package org.johoco.depinsight.web.dto.converter;

import org.apache.commons.lang3.StringUtils;
import org.johoco.depinsight.domain.Organization;
import org.johoco.depinsight.domain.key.OrganizationKey;

/**
 * 
 * @author John Hoestje
 *
 */
public class OrganizationConverter {
	public static Organization convert(final org.johoco.depinsight.dto.Organization dto) {
		if (dto != null) {
			if (StringUtils.isBlank(dto.getUrl())) {
				// add debugging message for this
				dto.setUrl("_url:" + dto.getName());
			}
			OrganizationKey key = new OrganizationKey(dto.getName(), dto.getUrl());
			Organization o = new Organization(key);
			return o;
		}
		return null;
	}

	public static org.johoco.depinsight.dto.Organization convert(final Organization entity) {
		if (entity != null) {
			org.johoco.depinsight.dto.Organization dto = new org.johoco.depinsight.dto.Organization();
			dto.setName(entity.getName());
			dto.setUrl(entity.getUrl());
			return dto;
		}
		return null;
	}

}
