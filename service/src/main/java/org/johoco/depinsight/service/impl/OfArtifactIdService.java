package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfArtifactId;
import org.johoco.depinsight.repository.arangodb.extended.OfArtifactIdRepository;
import org.johoco.depinsight.service.IofArtifactIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
@Service
public class OfArtifactIdService extends BaseService<OfArtifactId> implements IofArtifactIdService {

	private OfArtifactIdRepository repository;

	@Autowired
	public OfArtifactIdService(OfArtifactIdRepository repository) {
		this.repository = repository;
	}

	@Override
	public Iterable<OfArtifactId> findAll() {
		return repository.findAll();
	}

	@Override
	public OfArtifactId save(final OfArtifactId ofArtifactId) {
		OfArtifactId toSave = ofArtifactId;
		if (ofArtifactId.getArangoKey() == null) {
			toSave = this.repository.getByVertexIds(ofArtifactId).orElse(ofArtifactId);
		}
		super.preSave(toSave);
		return repository.save(toSave);
	}

}
