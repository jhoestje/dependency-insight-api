package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.Contributor;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface IContributorService {

	Contributor findOne(final Contributor contributor) throws Exception;

	Contributor save(final Contributor contributor);
}
