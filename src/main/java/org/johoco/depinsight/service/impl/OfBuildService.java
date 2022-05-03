package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfBuild;
import org.johoco.depinsight.repository.arangodb.extended.OfBuildRepository;
import org.johoco.depinsight.service.IofBuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author John Hoestje
 *
 */
@Service
public class OfBuildService extends BaseService<OfBuild> implements IofBuildService {

	private OfBuildRepository repository;

	@Autowired
	public OfBuildService(OfBuildRepository repository) {
		this.repository = repository;
	}

	@Override
	public OfBuild save(final OfBuild ofBuild) {
		OfBuild toSave = this.repository.getByVertexIds(ofBuild).orElse(ofBuild);
		super.preSave(toSave);
		return repository.save(toSave);
	}

}
