package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfArtifactId;
import org.johoco.depinsight.repository.arangodb.extended.OfArtifactIdRepository;
import org.johoco.depinsight.service.IofArtifactIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// TODO: move to business rule
//		assert ofLanguage.getValue() != null;
		// upsert
		super.preSave(ofArtifactId);
		return repository.save(ofArtifactId);
//		Optional<OfLanguage> existing = repo.findByGroupIdAndLanguage(ofLanguage.getGroupId(),
//				ofLanguage.getLanguage());
//		if (existing.isEmpty()) {
//			return repo.save(ofLanguage);
//		}
//		return existing.get();
	}

}
