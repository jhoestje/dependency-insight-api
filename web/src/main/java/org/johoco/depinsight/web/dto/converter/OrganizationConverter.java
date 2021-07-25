package org.johoco.depinsight.web.dto.converter;

import org.johoco.depinsight.domain.Organization;
import org.johoco.depinsight.domain.key.OrganizationKey;

public class OrganizationConverter {
	public static Organization convert(final org.johoco.depinsight.dto.Organization dto) {
		OrganizationKey key = new OrganizationKey(dto.getName(), dto.getUrl());
		Organization o = new Organization(key);
		return o;
	}

	public static org.johoco.depinsight.dto.Organization convert(final Organization dto) {
		org.johoco.depinsight.dto.Organization o = new org.johoco.depinsight.dto.Organization();
		o.setName(dto.getName());
		o.setUrl(dto.getUrl());
		return o;
	}

}
