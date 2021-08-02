package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.DistributionManagement;
import org.johoco.depinsight.repository.arangodb.extended.DistributionManagementRepository;
import org.johoco.depinsight.service.IDistributionManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
@Service
public class DistributionManagementService extends BaseService<DistributionManagement>
		implements IDistributionManagementService {

	private DistributionManagementRepository repository;
	private final static Logger LOGR = LoggerFactory.getLogger(DistributionManagementService.class);

	@Autowired
	public DistributionManagementService(DistributionManagementRepository repository) {
		this.repository = repository;
	}

	/**
	 * TODO: change exception to daoexception
	 */
	@Override
	public DistributionManagement findOne(final DistributionManagement distributionManagement) {
		return this.repository.findOne(distributionManagement).orElse(null);

//		Optional<DistributionManagement> dev = repository.getByKey(key);
//		if (dev.isEmpty()) {
//			LOGR.warn("An existing DistributionManagement of {} wasn't getByKey", key);
//			throw new Exception("no DistributionManagement key for " + key);
//		}
//		return dev.get();
	}

	/**
	 * This needs to be protected so only an admin can perform it
	 */
//	@Override
//	public DistributionManagement save(final DistributionManagement distributionManagement) {
//		// TODO: move to business rule
//		assert distributionManagement.getValue() != null;
//		super.preSave(distributionManagement);
//		// upsert
//		return repo.save(distributionManagement);
//	}

	@Override
	public DistributionManagement save(final DistributionManagement distributionManagement) {
		// TODO: move to business rule
		DistributionManagement save = distributionManagement;
		Optional<DistributionManagement> existing = Optional.ofNullable(this.findOne(distributionManagement));
		if (!existing.isEmpty()) {
			save = existing.get();
		}
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);

	}

}
