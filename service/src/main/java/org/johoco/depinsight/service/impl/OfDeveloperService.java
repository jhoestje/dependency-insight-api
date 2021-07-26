package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfDeveloper;
import org.johoco.depinsight.repository.arangodb.extended.OfDeveloperRepository;
import org.johoco.depinsight.service.IofDeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author John Hoestje
 *
 */
@Service
public class OfDeveloperService extends BaseService<OfDeveloper> implements IofDeveloperService {

	private OfDeveloperRepository repository;

	@Autowired
	public OfDeveloperService(OfDeveloperRepository repository) {
		this.repository = repository;
	}

	@Override
	public OfDeveloper save(final OfDeveloper ofDeveloper) {
		OfDeveloper toSave = ofDeveloper;
		if (ofDeveloper.getArangoKey() == null) {
			toSave = this.repository.getByVertexIds(ofDeveloper).orElse(ofDeveloper);
		}
		super.preSave(toSave);
		return repository.save(toSave);
	}

}
