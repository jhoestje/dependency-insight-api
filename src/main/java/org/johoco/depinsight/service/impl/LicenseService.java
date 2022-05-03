package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.License;
import org.johoco.depinsight.domain.key.LicenseKey;
import org.johoco.depinsight.repository.arangodb.extended.LicenseRepository;
import org.johoco.depinsight.service.ILicenseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NonNull;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
@Service
public class LicenseService extends BaseService<License> implements ILicenseService {

	private LicenseRepository repository;
	private final static Logger LOGR = LoggerFactory.getLogger(LicenseService.class);

	@Autowired
	public LicenseService(LicenseRepository repository) {
		this.repository = repository;
	}

	@Override
	public License save(@NonNull final License license) {

		// TODO: move to business rule
		License save = license;
		Optional<License> existing = Optional.ofNullable(this.getByKey(license.getKey()));
		if (!existing.isEmpty()) {
			save = existing.get();
		}
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);
	}

//	@Override
//	public License save(@NonNull final Language language, @NonNull final GroupId groupId,
//			@NonNull final ArtifactId artifactId, String license) {
//		LicenseKey key = new LicenseKey(language.getValue(), groupId.getValue(), artifactId.getValue(), license);
//		return this.save(new License(key));
//	}

	@Override
	public License getByKey(final LicenseKey licenseKey) {
		return this.repository.getByKey(licenseKey).orElse(null);
	}

}
