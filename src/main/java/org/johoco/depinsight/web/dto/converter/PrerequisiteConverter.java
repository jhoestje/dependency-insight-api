package org.johoco.depinsight.web.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.johoco.depinsight.domain.Prerequisite;

/**
 * 
 * @author John Hoestje
 *
 */
public class PrerequisiteConverter {
	public static Prerequisite convert(final org.johoco.depinsight.dto.Prerequisites dto) {
		if (dto != null) {
			Prerequisite entity = new Prerequisite(dto.getMaven());
			return entity;
		}
		return null;
	}

	public static org.johoco.depinsight.dto.Prerequisites convert(final Prerequisite entity) {
		if (entity != null) {
			org.johoco.depinsight.dto.Prerequisites dto = new org.johoco.depinsight.dto.Prerequisites();
			dto.setMaven(entity.getMaven());
			return dto;
		}
		return null;
	}

	public static List<Prerequisite> convert(List<org.johoco.depinsight.dto.Prerequisites> dtos) {
		if (dtos != null) {
			List<Prerequisite> entities = new ArrayList<>();
			for (org.johoco.depinsight.dto.Prerequisites dto : dtos) {
				entities.add(convert(dto));
			}
			return entities;
		}
		return null;
	}

}
