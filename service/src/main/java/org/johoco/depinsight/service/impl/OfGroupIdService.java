package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfGroupId;
import org.johoco.depinsight.repository.arangodb.extended.OfGroupIdRepository;
import org.johoco.depinsight.service.IofGroupIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfGroupIdService extends BaseService<OfGroupId> implements IofGroupIdService {

	private OfGroupIdRepository repository;

	@Autowired
	public OfGroupIdService(OfGroupIdRepository repository) {
		this.repository = repository;
	}

	@Override
	public OfGroupId save(final OfGroupId ofGroupId) {
		// upsert
		OfGroupId toSave = ofGroupId;
		if (ofGroupId.getId() == null) {
			toSave = this.repository.getByVertexIds(ofGroupId).orElse(ofGroupId);
		}
		super.preSave(toSave);
		return repository.save(toSave);
	}

}
