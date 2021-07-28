package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.IssueManagement;
import org.johoco.depinsight.domain.key.IssueManagementKey;
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
public class CiIssueManagementService extends BaseService<IssueManagement> implements IIssueManagementService {

	private IssueManagementRepository repository;
	private final static Logger LOGR = LoggerFactory.getLogger(CiIssueManagementService.class);

	@Autowired
	public CiIssueManagementService(IssueManagementRepository repository) {
		this.repository = repository;
	}

	@Override
	public IssueManagement save(@NonNull final IssueManagement issueManagement) {

		// TODO: move to business rule
		IssueManagement save = issueManagement;
		Optional<IssueManagement> existing = Optional.ofNullable(this.getByKey(issueManagement.getKey()));
		if (!existing.isEmpty()) {
			save = existing.get();
		}
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);
	}

//	@Override
//	public IssueManagement save(@NonNull final Language language, @NonNull final GroupId groupId,
//			@NonNull final ArtifactId artifactId, String issueManagement) {
//		IssueManagementKey key = new IssueManagementKey(language.getValue(), groupId.getValue(), artifactId.getValue(), issueManagement);
//		return this.save(new IssueManagement(key));
//	}

	@Override
	public IssueManagement getByKey(final IssueManagementKey issueManagementKey) {
		return this.repository.getByKey(issueManagementKey).orElse(null);
	}

}
