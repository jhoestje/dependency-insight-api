package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.License;
import org.johoco.depinsight.domain.key.LicenseKey;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface ILicenseService {

	License getByKey(final LicenseKey licenseKey);

	License save(final License license);
}
