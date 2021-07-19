package org.johoco.depinsight.repository.arangodb.extended;

import java.util.Map;

import org.johoco.depinsight.domain.GraphData;

import com.arangodb.springframework.core.ArangoOperations;
import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public abstract class BaseCompositeRepository<T extends GraphData, R extends ArangoRepository<T, String>> {

	private Map<String, String> queries;
	private ArangoOperations arangodb;
	private ArangoRepository<T, String> repository;

	public BaseCompositeRepository(final Map<String, String> queries, final ArangoOperations arangodb,
			final ArangoRepository<T, String> repository) {
		this.queries = queries;
		this.arangodb = arangodb;
		this.repository = repository;
	}

	protected Map<String, String> getQueries() {
		return this.queries;
	}

	protected ArangoOperations getArangoDb() {
		return this.arangodb;
	}

	protected ArangoRepository<T, String> getRepository() {
		return this.repository;
	}

	protected String getQuery(final String queryName) {
		return this.queries.get(queryName);
	}

	protected T save(final T graphData) {
		return this.repository.save(graphData);
	}

	// in service for now
//	protected void preSave(final T graphData) {
//		if (StringUtils.isBlank(graphData.getId())) {
//			graphData.setCreatedDate(DateTime.now());
//		}
//		graphData.setLastUpdatedDate(DateTime.now());
//	}
}
