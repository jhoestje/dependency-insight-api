package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfVersion;
import org.johoco.depinsight.repository.arangodb.OfVersionArangoRepository;
import org.johoco.depinsight.service.IofVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfVersionService extends BaseService<OfVersion> implements IofVersionService {

	private OfVersionArangoRepository repo;

	@Autowired
	public OfVersionService(OfVersionArangoRepository repo) {
		this.repo = repo;
	}

	@Override
	public OfVersion save(final OfVersion ofVersion) {
		// TODO: move to business rule
//		assert ofLanguage.getValue() != null;
		// upsert
		super.preSave(ofVersion);
		return repo.save(ofVersion);
	}

}
