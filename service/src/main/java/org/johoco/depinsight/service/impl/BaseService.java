package org.johoco.depinsight.service.impl;

import org.joda.time.DateTime;
import org.johoco.depinsight.domain.GraphData;

public abstract class BaseService<E extends GraphData> {

	protected E preSave(final E data) {
		if(data.getCreatedDate() == null) {
			data.setCreatedDate(new DateTime());
		}
		data.setLastUpdatedDate(new DateTime());
		return data;
	}
	
}
