package org.johoco.depinsight.web.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.johoco.depinsight.domain.MailingList;

/**
 * 
 * @author John Hoestje
 *
 */
public class MailingListConverter {
	public static MailingList convert(final org.johoco.depinsight.dto.MailingLists dto) {
		if (dto != null) {
			MailingList o = MailingList.builder().name(dto.getName()).subscribe(dto.getSubscribe())
					.unsubscribe(dto.getUnsubscribe()).post(dto.getPost()).archive(dto.getArchive())
					.otherArchives(dto.getOtherArchives()).build();
			return o;
		}
		return null;
	}

	public static org.johoco.depinsight.dto.MailingLists convert(final MailingList entity) {
		if (entity != null) {
			org.johoco.depinsight.dto.MailingLists dto = org.johoco.depinsight.dto.MailingLists.builder()
					.name(entity.getName()).subscribe(entity.getSubscribe()).unsubscribe(entity.getUnsubscribe())
					.post(entity.getPost()).archive(entity.getArchive()).otherArchives(entity.getOtherArchives())
					.build();
			;
			return dto;
		}
		return null;
	}

	public static List<MailingList> convert(List<org.johoco.depinsight.dto.MailingLists> dtos) {
		if (dtos != null) {
			List<MailingList> entities = new ArrayList<>();
			for (org.johoco.depinsight.dto.MailingLists dto : dtos) {
				entities.add(convert(dto));
			}
			return entities;
		}
		return null;
	}

}
