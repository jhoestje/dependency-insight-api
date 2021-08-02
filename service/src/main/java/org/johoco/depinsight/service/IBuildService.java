package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.Build;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface IBuildService {

	Build findOne(final Build build) throws Exception;

	Build save(final Build build);
}
