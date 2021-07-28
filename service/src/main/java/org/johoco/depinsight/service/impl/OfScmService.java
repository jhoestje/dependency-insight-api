package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfScm;
import org.johoco.depinsight.repository.arangodb.extended.OfScmRepository;
import org.johoco.depinsight.service.IofScmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author John Hoestje
 *
 */
@Service
public class OfScmService extends BaseService<OfScm> implements IofScmService {

	private OfScmRepository repository;

	@Autowired
	public OfScmService(OfScmRepository repository) {
		this.repository = repository;
	}

	@Override
	public OfScm save(final OfScm ofScm) {
		OfScm toSave = ofScm;
		if (ofScm.getArangoKey() == null) {
			toSave = this.repository.getByVertexIds(ofScm).orElse(ofScm);
		}
		super.preSave(toSave);
		return repository.save(toSave);
	}

}
