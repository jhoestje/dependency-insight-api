package org.johoco.depinsight.repository.arangodb.extended;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.johoco.depinsight.domain.License;
import org.johoco.depinsight.domain.key.LicenseKey;
import org.johoco.depinsight.repository.arangodb.LicenseArangoRepository;
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
public class LicenseRepository extends BaseCompositeRepository<License, LicenseArangoRepository> {

	private final static Logger LOGR = LoggerFactory.getLogger(LicenseRepository.class);

	@Autowired
	public LicenseRepository(@Value("#{licensequeries}") final Map<String, String> queries,
			final ArangoOperations aranngoDB, final LicenseArangoRepository licenseRepository) {
		super(queries, aranngoDB, licenseRepository);
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public Optional<License> getByKey(final LicenseKey key) {
		String query = getQuery("getByKey");
		Map<String, Object> bindVars = new HashMap<String, Object>();
		bindVars.put("name", key.getName());
		bindVars.put("url", key.getUrl());
		bindVars.put("distribution", key.getDistribution());

		ArangoCursor<License> cursor = getArangoDb().query(query, bindVars, null, License.class);
		if (cursor.hasNext()) {
			return Optional.of(cursor.next());
		}
		return Optional.empty();
	}

	public License save(final License license) {
		LOGR.debug("Saving License id {} - from {} to {}:  ", license.getArangoKey(), license.getKey());
		return this.getRepository().save(license);
	}

	public void delete(final LicenseKey key) {
	}

	public void delete(final License license) {
		this.delete(license.getKey());
	}

	public void update() {
	}

}
