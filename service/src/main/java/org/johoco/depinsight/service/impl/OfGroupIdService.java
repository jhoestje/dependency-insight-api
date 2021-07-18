package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfGroupId;
import org.johoco.depinsight.repository.arangodb.OfGroupIdArangoRepository;
import org.johoco.depinsight.service.IofGroupIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfGroupIdService extends BaseService<OfGroupId> implements IofGroupIdService {

	private OfGroupIdArangoRepository repo;

	@Autowired
	public OfGroupIdService(OfGroupIdArangoRepository repo) {
		this.repo = repo;
	}

	@Override
	public OfGroupId save(final OfGroupId ofLanguage) {
		// TODO: move to business rule
//		assert ofLanguage.getValue() != null;
		// upsert
		super.preSave(ofLanguage);
		return repo.save(ofLanguage);
//		Optional<OfLanguage> existing = repo.findByGroupIdAndLanguage(ofLanguage.getGroupId(),
//				ofLanguage.getLanguage());
//		if (existing.isEmpty()) {
//			return repo.save(ofLanguage);
//		}
//		return existing.get();
	}

}
