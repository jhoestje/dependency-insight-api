package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfArtifactId;
import org.johoco.depinsight.repository.arangodb.OfArtifactIdArangoRepository;
import org.johoco.depinsight.service.IofArtifactIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfArtifactIdService extends BaseService<OfArtifactId> implements IofArtifactIdService {

	private OfArtifactIdArangoRepository repo;

	@Autowired
	public OfArtifactIdService(OfArtifactIdArangoRepository repo) {
		this.repo = repo;
	}

	@Override
	public Iterable<OfArtifactId> findAll() {
		return repo.findAll();
	}

	@Override
	public OfArtifactId save(final OfArtifactId ofArtifactId) {
		// TODO: move to business rule
//		assert ofLanguage.getValue() != null;
		// upsert
		super.preSave(ofArtifactId);
		return repo.save(ofArtifactId);
//		Optional<OfLanguage> existing = repo.findByGroupIdAndLanguage(ofLanguage.getGroupId(),
//				ofLanguage.getLanguage());
//		if (existing.isEmpty()) {
//			return repo.save(ofLanguage);
//		}
//		return existing.get();
	}

}
