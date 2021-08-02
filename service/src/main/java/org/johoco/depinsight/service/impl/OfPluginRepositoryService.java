package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfPluginRepository;
import org.johoco.depinsight.repository.arangodb.extended.OfPluginRepositoryRepository;
import org.johoco.depinsight.service.IofPluginRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author John Hoestje
 *
 */
@Service
public class OfPluginRepositoryService extends BaseService<OfPluginRepository> implements IofPluginRepositoryService {

	private OfPluginRepositoryRepository repository;

	@Autowired
	public OfPluginRepositoryService(OfPluginRepositoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public OfPluginRepository save(final OfPluginRepository ofPluginRepository) {
		OfPluginRepository toSave = ofPluginRepository;
		if (ofPluginRepository.getArangoKey() == null) {
			toSave = this.repository.getByVertexIds(ofPluginRepository).orElse(ofPluginRepository);
		}
		super.preSave(toSave);
		return repository.save(toSave);
	}

}
