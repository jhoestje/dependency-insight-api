package org.johoco.depinsight.web.dto.converter;

import org.johoco.depinsight.domain.CiManagement;
import org.johoco.depinsight.domain.key.CiManagementKey;

/**
 * 
 * @author John Hoestje
 *
 */
public class CiManagementConverter {
	public static CiManagement convert(final org.johoco.depinsight.dto.CiManagement dto) {
		if (dto != null) {
			CiManagementKey key = new CiManagementKey(dto.getUrl());
			CiManagement entity = new CiManagement(key);
			entity.setSystem(dto.getSystem());
			entity.setNotifiers(NotifierConverter.convert(dto.getNotifiers()));
			return entity;
		}
		return null;
	}

	public static org.johoco.depinsight.dto.CiManagement convert(final CiManagement entity) {
		if (entity != null) {
			org.johoco.depinsight.dto.CiManagement dto = new org.johoco.depinsight.dto.CiManagement();
			dto.setUrl(entity.getKey().getUrl());
			dto.setSystem(entity.getSystem());
			dto.setNotifiers(NotifierConverter.convertz(entity.getNotifiers()));
			return dto;
		}
		return null;
	}

}
