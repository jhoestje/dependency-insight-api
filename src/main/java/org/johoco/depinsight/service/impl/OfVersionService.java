package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfVersion;
import org.johoco.depinsight.repository.arangodb.extended.OfVersionRepository;
import org.johoco.depinsight.service.IofVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
@Service
public class OfVersionService extends BaseService<OfVersion> implements IofVersionService {

	private OfVersionRepository repository;

	@Autowired
	public OfVersionService(OfVersionRepository repository) {
		this.repository = repository;
	}

	@Override
	public OfVersion save(final OfVersion ofVersion) {
		OfVersion toSave = this.repository.getByVertexIds(ofVersion).orElse(ofVersion);
		super.preSave(toSave);
		return repository.save(toSave);
	}

}
