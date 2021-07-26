package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.Developer;
import org.johoco.depinsight.domain.key.DeveloperKey;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface IDeveloperService {

	Developer getByKey(final DeveloperKey key) throws Exception;

	Developer save(final Developer developer);
}
