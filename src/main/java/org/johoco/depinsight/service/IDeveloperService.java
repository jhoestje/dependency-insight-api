package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.Developer;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface IDeveloperService {

	Developer findOne(final Developer developer) throws Exception;

	Developer save(final Developer developer);
}
