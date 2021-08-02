package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.CiManagement;
import org.johoco.depinsight.domain.key.CiManagementKey;
import org.johoco.depinsight.repository.arangodb.extended.CiManagementRepository;
import org.johoco.depinsight.service.ICiManagementService;
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
public class CiManagementService extends BaseService<CiManagement> implements ICiManagementService {

	private CiManagementRepository repository;
	private final static Logger LOGR = LoggerFactory.getLogger(CiManagementService.class);

	@Autowired
	public CiManagementService(CiManagementRepository repository) {
		this.repository = repository;
	}

	@Override
	public CiManagement save(@NonNull final CiManagement ciManagement) {

		// TODO: move to business rule
		CiManagement save = ciManagement;
		Optional<CiManagement> existing = Optional.ofNullable(this.getByKey(ciManagement.getKey()));
		if (!existing.isEmpty()) {
			save = existing.get();
		}
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);
	}

//	@Override
//	public CiManagement save(@NonNull final Language language, @NonNull final GroupId groupId,
//			@NonNull final ArtifactId artifactId, String ciManagement) {
//		CiManagementKey key = new CiManagementKey(language.getValue(), groupId.getValue(), artifactId.getValue(), ciManagement);
//		return this.save(new CiManagement(key));
//	}

	@Override
	public CiManagement getByKey(final CiManagementKey ciManagementKey) {
		return this.repository.getByKey(ciManagementKey).orElse(null);
	}

}
