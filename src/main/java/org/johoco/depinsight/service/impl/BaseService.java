package org.johoco.depinsight.service.impl;

import java.util.Date;

import org.johoco.depinsight.domain.GraphData;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
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
		final Date dt = Date.now();
		if (data.getCreatedDate() == null) {
			data.setCreatedDate(dt);
		}
		data.setLastUpdatedDate(dt);
		return data;
	}

}
