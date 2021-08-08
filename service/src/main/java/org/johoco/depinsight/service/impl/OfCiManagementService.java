package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfCiManagement;
import org.johoco.depinsight.repository.arangodb.extended.OfCiManagementRepository;
import org.johoco.depinsight.service.IOfCiManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author John Hoestje
 *
 */
@Service
public class OfCiManagementService extends BaseService<OfCiManagement> implements IOfCiManagementService {

	private OfCiManagementRepository repository;

	@Autowired
	public OfCiManagementService(OfCiManagementRepository repository) {
		this.repository = repository;
	}

	@Override
	public OfCiManagement save(final OfCiManagement ofCiManagement) {
		OfCiManagement toSave = this.repository.getByVertexIds(ofCiManagement).orElse(ofCiManagement);
		super.preSave(toSave);
		return repository.save(toSave);
	}

}
