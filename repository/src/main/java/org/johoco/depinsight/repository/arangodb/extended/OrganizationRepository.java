package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.Organization;
import org.johoco.depinsight.domain.key.OrganizationKey;
import org.johoco.depinsight.repository.arangodb.OrganizationArangoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.arangodb.ArangoCursor;
import com.arangodb.springframework.core.ArangoOperations;

/**
 * 
 * Using AQL literal queries instead of @Query annotation on the method in order
 * to be able to use the same query in the AQL query runner.
 * 
 * @author John Hoestje
 *
 */
@Repository
public class OrganizationRepository extends BaseCompositeRepository<Organization, OrganizationArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(OrganizationRepository.class);

	@Autowired
	public OrganizationRepository(@Value("#{organizationqueries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final OrganizationArangoRepository OrganizationRepository) {
		super(queries, aranngoDB, OrganizationRepository);
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public Optional<Organization> getByKey(final OrganizationKey key) {
		String query = getQuery("getByKey");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("name", key.getName());
		bindVars.put("url", key.getUrl());
//		bindVars.put("distribution", key.getDistribution());

		ArangoCursor<Organization> cursor = getArangoDb().query(query, bindVars, null, Organization.class);
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
	}

	public Organization save(final Organization organization) {
		LOGR.debug("Saving Organization id {} - from {} to {}:  ", organization.getArangoKey(), organization.getKey());
		return this.getRepository().save(organization);
	}

	public void delete(final OrganizationKey key) {
	}

	public void delete(final Organization Organization) {
		this.delete(Organization.getKey());
	}

	public void update() {
	}

}
