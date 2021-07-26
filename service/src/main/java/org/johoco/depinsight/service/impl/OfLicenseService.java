package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfLicense;
import org.johoco.depinsight.repository.arangodb.extended.OfLicenseRepository;
import org.johoco.depinsight.service.IofLicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author John Hoestje
 *
 */
@Service
public class OfLicenseService extends BaseService<OfLicense> implements IofLicenseService {

	private OfLicenseRepository repository;

	@Autowired
	public OfLicenseService(OfLicenseRepository repository) {
		this.repository = repository;
	}

	@Override
	public OfLicense save(final OfLicense ofLicense) {
		OfLicense toSave = ofLicense;
		if (ofLicense.getArangoKey() == null) {
			toSave = this.repository.getByVertexIds(ofLicense).orElse(ofLicense);
		}
		super.preSave(toSave);
		return repository.save(toSave);
	}

}
