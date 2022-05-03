package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.repository.arangodb.extended.BaseEdgeCompositeRepository;

import com.arangodb.springframework.repository.ArangoRepository;

import lombok.Getter;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
@Deprecated
@Getter
public abstract class BaseEdgeService<E extends GraphData, A extends ArangoRepository<E, String>, R extends BaseEdgeCompositeRepository<E, A>>
		extends BaseService<E> {

	private R repository;

	public BaseEdgeService(final R repository) {
		this.repository = repository;
	}

//	@Override
//	public E save(final E ofEntity) {
//		E toSave = ofEntity;
//		if (ofEntity.getArangoKey() == null) {
//			toSave = this.repository.getByVertexIds(ofEntity).orElse(ofEntity);
//		}
//		super.preSave(toSave);
//		return repository.save(toSave);
//	}

}
