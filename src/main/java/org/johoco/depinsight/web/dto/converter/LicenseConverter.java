package org.johoco.depinsight.web.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.johoco.depinsight.domain.License;
import org.johoco.depinsight.domain.key.LicenseKey;

/**
 * 
 * @author John Hoestje
 *
 */
public class LicenseConverter {
	public static License convert(final org.johoco.depinsight.dto.License dto) {
		if (dto != null) {
			LicenseKey key = new LicenseKey(dto.getName(), dto.getUrl());
			License l = new License(key);
			l.setDistribution(dto.getDistribution());
			return l;
		}
		return null;
	}

	public static org.johoco.depinsight.dto.License convert(final License entity) {
		if (entity != null) {
			org.johoco.depinsight.dto.License dto = new org.johoco.depinsight.dto.License();
			dto.setName(entity.getName());
			dto.setUrl(entity.getUrl());
			dto.setDistribution(entity.getDistribution());
			return dto;
		}
		return null;
	}

	public static List<License> convert(final List<org.johoco.depinsight.dto.License> dtos) {
		if (dtos != null) {
			List<License> entities = new ArrayList<>();
			for (org.johoco.depinsight.dto.License dto : dtos) {
				entities.add(convert(dto));
			}
			return entities;
		}
		return null;
	}

	public static List<org.johoco.depinsight.dto.License> convertz(final List<License> entities) {
		if (entities != null) {
			List<org.johoco.depinsight.dto.License> dtos = new ArrayList<>();
			for (License e : entities) {
				dtos.add(convert(e));
			}
			return dtos;
		}
		return null;
	}

}
