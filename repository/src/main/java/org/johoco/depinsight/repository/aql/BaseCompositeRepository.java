package org.johoco.depinsight.repository.aql;

import java.util.Map;

import com.arangodb.springframework.core.ArangoOperations;

public abstract class BaseCompositeRepository {

	private Map<String, String> queries;
	private ArangoOperations arangodb;

	public BaseCompositeRepository(final Map<String, String> queries, final ArangoOperations arangodb) {
		this.queries = queries;
		this.arangodb = arangodb;
	}

	protected Map<String, String> getQueries() {
		return this.queries;
	}

	protected ArangoOperations getArangoDb() {
		return this.arangodb;
	}

	protected String getQuery(final String queryName) {
		return this.queries.get(queryName);
	}
}
