package org.johoco.depinsight.web.dto.converter;

import org.johoco.depinsight.domain.IssueManagement;
import org.johoco.depinsight.domain.key.IssueManagementKey;

/**
 * 
 * @author John Hoestje
 *
 */
public class IssueManagementConverter {
	public static IssueManagement convert(final org.johoco.depinsight.dto.IssueManagement dto) {
		if (dto != null) {
			IssueManagementKey key = new IssueManagementKey(dto.getUrl());
			IssueManagement entity = new IssueManagement(key);
			entity.setSystem(dto.getSystem());
			return entity;
		}
		return null;
	}

	public static org.johoco.depinsight.dto.IssueManagement convert(final IssueManagement entity) {
		if (entity != null) {
			org.johoco.depinsight.dto.IssueManagement dto = new org.johoco.depinsight.dto.IssueManagement();
			dto.setUrl(entity.getKey().getUrl());
			dto.setSystem(entity.getSystem());
			return dto;
		}
		return null;
	}

}
