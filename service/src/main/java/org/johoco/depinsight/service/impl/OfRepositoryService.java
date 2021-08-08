package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfRepository;
import org.johoco.depinsight.repository.arangodb.extended.OfRepositoryRepository;
import org.johoco.depinsight.service.IofRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author John Hoestje
 *
 */
@Service
public class OfRepositoryService extends BaseService<OfRepository> implements IofRepositoryService {

	private OfRepositoryRepository repository;

	@Autowired
	public OfRepositoryService(OfRepositoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public OfRepository save(final OfRepository ofRepository) {
		OfRepository toSave = this.repository.getByVertexIds(ofRepository).orElse(ofRepository);
		super.preSave(toSave);
		return repository.save(toSave);
	}

}
