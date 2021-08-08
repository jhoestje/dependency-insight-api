package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfDistributionManagement;
import org.johoco.depinsight.repository.arangodb.extended.OfDistributionManagementRepository;
import org.johoco.depinsight.service.IofDistributionManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author John Hoestje
 *
 */
@Service
public class OfDistributionManagementService extends BaseService<OfDistributionManagement>
		implements IofDistributionManagementService {

	private OfDistributionManagementRepository repository;

	@Autowired
	public OfDistributionManagementService(OfDistributionManagementRepository repository) {
		this.repository = repository;
	}

	@Override
	public OfDistributionManagement save(final OfDistributionManagement ofDistributionManagement) {
		OfDistributionManagement toSave = this.repository.getByVertexIds(ofDistributionManagement)
				.orElse(ofDistributionManagement);
		super.preSave(toSave);
		return repository.save(toSave);
	}

}
