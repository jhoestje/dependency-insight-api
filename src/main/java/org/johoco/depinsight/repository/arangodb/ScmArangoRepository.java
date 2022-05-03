package org.johoco.depinsight.repository.arangodb;

import org.johoco.depinsight.domain.Scm;

import com.arangodb.springframework.repository.ArangoRepository;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface ScmArangoRepository extends ArangoRepository<Scm, String> {

}
