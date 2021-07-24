package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfGavp;
import org.johoco.depinsight.repository.arangodb.extended.OfGavpRepository;
import org.johoco.depinsight.service.IofGavpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfGavpService extends BaseService<OfGavp> implements IofGavpService {

	private OfGavpRepository repository;

	@Autowired
	public OfGavpService(OfGavpRepository repository) {
		this.repository = repository;
	}

	@Override
	public OfGavp save(final OfGavp ofGavp) {
		OfGavp toSave = ofGavp;
		if (ofGavp.getId() == null) {
			toSave = this.repository.getByVertexIds(ofGavp).orElse(ofGavp);
		}
		super.preSave(toSave);
		return repository.save(toSave);
	}

}
