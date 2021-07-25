package org.johoco.depinsight.web.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.johoco.depinsight.domain.Notifier;
import org.johoco.depinsight.domain.key.NotifierKey;

/**
 * 
 * @author John Hoestje
 *
 */
public class NotifierConverter {
	public static Notifier convert(final org.johoco.depinsight.dto.Notifier dto) {
		if (dto != null) {
			NotifierKey key = new NotifierKey(dto.getAddress());
			Notifier entity = new Notifier(key);
			entity.setType(dto.getType());
			entity.setSendOnError(Boolean.valueOf(dto.getSendOnError()));
			entity.setSendOnFailure(Boolean.valueOf(dto.getSendOnFailure()));
			entity.setSendOnSuccess(Boolean.valueOf(dto.getSendOnSuccess()));
			entity.setSendOnWarning(Boolean.valueOf(dto.getSendOnWarning()));

			return entity;

		}
		return null;
	}

	public static org.johoco.depinsight.dto.Notifier convert(final Notifier entity) {
		if (entity != null) {
			org.johoco.depinsight.dto.Notifier dto = org.johoco.depinsight.dto.Notifier.builder()
					.address(entity.getKey().getAddress()).type(entity.getType())
					.sendOnError(Boolean.toString(entity.getSendOnError()))
					.sendOnFailure(Boolean.toString(entity.getSendOnFailure()))
					.sendOnSuccess(Boolean.toString(entity.getSendOnSuccess()))
					.sendOnWarning(Boolean.toString(entity.getSendOnWarning())).build();
			return dto;
		}
		return null;
	}

	public static List<Notifier> convert(final List<org.johoco.depinsight.dto.Notifier> dtos) {
		if (dtos != null) {
			List<Notifier> entities = new ArrayList<>();
			for (org.johoco.depinsight.dto.Notifier dto : dtos) {
				entities.add(convert(dto));
			}
			return entities;
		}
		return null;
	}

	public static List<org.johoco.depinsight.dto.Notifier> convertz(final List<Notifier> entities) {
		if (entities != null) {
			List<org.johoco.depinsight.dto.Notifier> dtos = new ArrayList<>();
			for (Notifier entity : entities) {
				dtos.add(convert(entity));
			}
			return dtos;
		}
		return null;
	}

}
