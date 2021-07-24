package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.Language;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
public interface ILanguageService {
	Iterable<Language> findAll();

	Language findByValue(final String value) throws Exception;

	Language save(final Language language);
}
