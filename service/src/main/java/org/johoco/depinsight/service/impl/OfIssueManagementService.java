package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfIssueManagement;
import org.johoco.depinsight.repository.arangodb.extended.OfIssueManagementRepository;
import org.johoco.depinsight.service.IOfIssueManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author John Hoestje
 *
 */
@Service
public class OfIssueManagementService extends BaseService<OfIssueManagement> implements IOfIssueManagementService {

	private OfIssueManagementRepository repository;

	@Autowired
	public OfIssueManagementService(OfIssueManagementRepository repository) {
		this.repository = repository;
	}

	@Override
	public OfIssueManagement save(final OfIssueManagement ofIssueManagement) {
		OfIssueManagement toSave = ofIssueManagement;
		if (ofIssueManagement.getArangoKey() == null) {
			toSave = this.repository.getByVertexIds(ofIssueManagement).orElse(ofIssueManagement);
		}
		super.preSave(toSave);
		return repository.save(toSave);
	}

}
