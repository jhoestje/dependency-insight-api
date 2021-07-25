package org.johoco.depinsight.web.dto.converter;

import org.johoco.depinsight.domain.Scm;
import org.johoco.depinsight.domain.key.ScmKey;

/**
 * 
 * @author John Hoestje
 *
 */
public class ScmConverter {
	public static Scm convert(final org.johoco.depinsight.dto.Scm dto) {
		if (dto != null) {
			ScmKey key = new ScmKey(dto.getUrl());
			Scm entity = new Scm(key);
			return entity;
		}
		return null;
	}

	public static org.johoco.depinsight.dto.Scm convert(final Scm entity) {
		if (entity != null) {
			org.johoco.depinsight.dto.Scm dto = new org.johoco.depinsight.dto.Scm();
			dto.setUrl(entity.getKey().getUrl());
			dto.setConnection(entity.getConnection());
			dto.setDeveloperConnection(entity.getDeveloperConnection());
			return dto;
		}
		return null;
	}

}
