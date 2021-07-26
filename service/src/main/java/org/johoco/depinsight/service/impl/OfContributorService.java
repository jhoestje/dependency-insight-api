package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfContributor;
import org.johoco.depinsight.repository.arangodb.extended.OfContributorRepository;
import org.johoco.depinsight.service.IofContributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author John Hoestje
 *
 */
@Service
public class OfContributorService extends BaseService<OfContributor> implements IofContributorService {

	private OfContributorRepository repository;

	@Autowired
	public OfContributorService(OfContributorRepository repository) {
		this.repository = repository;
	}

	@Override
	public OfContributor save(final OfContributor ofContributor) {
		OfContributor toSave = ofContributor;
		if (ofContributor.getArangoKey() == null) {
			toSave = this.repository.getByVertexIds(ofContributor).orElse(ofContributor);
		}
		super.preSave(toSave);
		return repository.save(toSave);
	}

}
