package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.CiManagement;
import org.johoco.depinsight.domain.key.CiManagementKey;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface ICiManagementService {

	CiManagement getByKey(final CiManagementKey key) throws Exception;

	CiManagement save(final CiManagement ciManagement);

}
