package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.IssueManagement;
import org.johoco.depinsight.repository.arangodb.extended.IssueManagementRepository;
import org.johoco.depinsight.service.IIssueManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;

/**
 * 
 * @author John Hoestje
 *
 */
@Service
public class IssueManagementService extends BaseService<IssueManagement> implements IIssueManagementService {

	private IssueManagementRepository repository;
	private final static Logger LOGR = LoggerFactory.getLogger(IssueManagementService.class);

	@Autowired
	public IssueManagementService(IssueManagementRepository repository) {
		this.repository = repository;
	}

	@Override
	public IssueManagement save(@NonNull final IssueManagement entity) {
		IssueManagement save = this.repository.findOne(entity).orElse(entity);
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);
	}

}
