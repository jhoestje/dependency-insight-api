package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfVersion;
import org.johoco.depinsight.repository.OfVersionRepository;
import org.johoco.depinsight.service.IofVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfVersionService extends BaseService<OfVersion> implements IofVersionService {

	private OfVersionRepository repo;

	@Autowired
	public OfVersionService(OfVersionRepository repo) {
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