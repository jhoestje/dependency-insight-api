package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.Organization;
import org.johoco.depinsight.domain.key.OrganizationKey;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface IOrganizationService {

	Organization getByKey(final OrganizationKey organizationKey);

	Organization save(final Organization organization);
}
