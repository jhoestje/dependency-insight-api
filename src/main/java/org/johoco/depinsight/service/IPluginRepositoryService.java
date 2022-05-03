package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.PluginRepository;
import org.johoco.depinsight.domain.key.RepositoryKey;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface IPluginRepositoryService {

	PluginRepository getByKey(final RepositoryKey key) throws Exception;

	PluginRepository save(final PluginRepository repository);

}
