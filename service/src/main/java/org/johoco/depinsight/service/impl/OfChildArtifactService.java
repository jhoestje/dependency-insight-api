package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfChildArtifact;
import org.johoco.depinsight.repository.arangodb.extended.OfChildArtifactRepository;
import org.johoco.depinsight.service.IofChildArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
@Service
public class OfChildArtifactService extends BaseService<OfChildArtifact> implements IofChildArtifactService {

	private OfChildArtifactRepository repository;

	@Autowired
	public OfChildArtifactService(OfChildArtifactRepository repository) {
		this.repository = repository;
	}

	@Override
	public OfChildArtifact save(final OfChildArtifact ofChildArtifact) {
		OfChildArtifact toSave = this.repository.getByVertexIds(ofChildArtifact).orElse(ofChildArtifact);
		super.preSave(toSave);
		return repository.save(toSave);
	}

}
