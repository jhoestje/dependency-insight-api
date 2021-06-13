package org.johoco.depinsight.service.impl;

import org.joda.time.DateTime;
import org.johoco.depinsight.domain.GraphData;

public abstract class BaseService<E extends GraphData> {

	/**
	 * This is here due to arangodb having interface based repos and cannot have
	 * this logic there.
	 * 
	 * If all repos eventually have a wrapper/super repo around the arangodb, then
	 * this can be moved.
	 * 
	 * @param data
	 * @return
	 */
	protected E preSave(final E data) {
		if (data.getCreatedDate() == null) {
			data.setCreatedDate(new DateTime());
		}
		data.setLastUpdatedDate(new DateTime());
		return data;
	}

}
