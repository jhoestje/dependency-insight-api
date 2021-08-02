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
@Deprecated
public abstract class BaseEdgeCompositeRepository<E extends GraphData, R extends ArangoRepository<E, String>>
		extends BaseCompositeRepository<E, R> {

	public BaseEdgeCompositeRepository(final Map<String, String> queries, final ArangoOperations arangodb,
			final ArangoRepository<E, String> repository) {
		super(queries, arangodb, repository);
	}

//	public Object getByVertexIds(E ofEntity) {
////		try {
//		String query = getQuery("getByVertexIds");
//		Map<String, Object> bindVars = new HashMap<String, Object>();
//		bindVars.put("licVertexId", ofEntity.getLicense().getArangoId());
//		bindVars.put("artifactVertexId", ofEntity.getArtifact().getArangoId());
//
//		ArangoCursor<E> cursor = getArangoDb().query(query, bindVars, null,
//				ClassUtils.getClass(ofEntity.getClass().getName()));
//		if (cursor.hasNext()) {
//			return Optional.of(cursor.next());
//		}
//		return Optional.empty();
////		} catch (ArangoDBException e) {
////			System.err.println("Failed to execute query. " + e.getMessage());
////		}
////		return null;
//	}

	// in service for now
//	protected void preSave(final T graphData) {
//		if (StringUtils.isBlank(graphData.getId())) {
//			graphData.setCreatedDate(DateTime.now());
//		}
//		graphData.setLastUpdatedDate(DateTime.now());
//	}
}
