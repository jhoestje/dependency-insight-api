package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.Repository;
import org.johoco.depinsight.domain.key.RepositoryKey;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface IRepositoryService {

	Repository getByKey(final RepositoryKey key) throws Exception;

	Repository save(final Repository repository);

}
