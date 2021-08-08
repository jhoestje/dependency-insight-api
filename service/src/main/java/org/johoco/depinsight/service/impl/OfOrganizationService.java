package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfOrganization;
import org.johoco.depinsight.repository.arangodb.extended.OfOrganizationRepository;
import org.johoco.depinsight.service.IofOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author John Hoestje
 *
 */
@Service
public class OfOrganizationService extends BaseService<OfOrganization> implements IofOrganizationService {

	private OfOrganizationRepository repository;

	@Autowired
	public OfOrganizationService(OfOrganizationRepository repository) {
		this.repository = repository;
	}

	@Override
	public OfOrganization save(final OfOrganization ofGavp) {
		OfOrganization toSave = this.repository.getByVertexIds(ofGavp).orElse(ofGavp);
		super.preSave(toSave);
		return repository.save(toSave);
	}

}
