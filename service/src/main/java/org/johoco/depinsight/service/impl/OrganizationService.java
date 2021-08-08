package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.Organization;
import org.johoco.depinsight.domain.key.OrganizationKey;
import org.johoco.depinsight.repository.arangodb.extended.OrganizationRepository;
import org.johoco.depinsight.service.IOrganizationService;
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
public class OrganizationService extends BaseService<Organization> implements IOrganizationService {

	private OrganizationRepository repository;
	private final static Logger LOGR = LoggerFactory.getLogger(OrganizationService.class);

	@Autowired
	public OrganizationService(OrganizationRepository repository) {
		this.repository = repository;
	}

	@Override
	public Organization save(@NonNull final Organization organization) {

		// TODO: move to business rule
		Organization save = organization;
		Optional<Organization> existing = Optional.ofNullable(this.getByKey(organization.getKey()));
		if (!existing.isEmpty()) {
			save = existing.get();
		}
		super.preSave(save);
		// upsert - save new or save with last updated timestamp
		return this.repository.save(save);
	}

//	@Override
//	public Organization save(@NonNull final Language language, @NonNull final GroupId groupId,
//			@NonNull final ArtifactId artifactId, String organization) {
//		OrganizationKey key = new OrganizationKey(language.getValue(), groupId.getValue(), artifactId.getValue(), organization);
//		return this.save(new Organization(key));
//	}

	@Override
	public Organization getByKey(final OrganizationKey organizationKey) {
		return this.repository.getByKey(organizationKey).orElse(null);
	}

}
