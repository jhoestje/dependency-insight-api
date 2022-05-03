package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.Scm;
import org.johoco.depinsight.domain.key.ScmKey;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface IScmService {

	Scm getByKey(final ScmKey key) throws Exception;

	Scm save(final Scm scm);
}
