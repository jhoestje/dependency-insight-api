package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.DistributionManagement;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface IDistributionManagementService {

	DistributionManagement findOne(final DistributionManagement distributionManagement) throws Exception;

	DistributionManagement save(final DistributionManagement distributionManagement);
}
