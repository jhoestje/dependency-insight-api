package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.relationship.OfLanguage;
import org.johoco.depinsight.repository.arangodb.extended.OfLanguageRepository;
import org.johoco.depinsight.service.IofLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author John Hoestje
 *
 */
@Service
public class OfLanguageService extends BaseService<OfLanguage> implements IofLanguageService {

	private OfLanguageRepository repository;

	@Autowired
	public OfLanguageService(final OfLanguageRepository repository) {
		this.repository = repository;
	}

	/**
	 * Does find one on edges work? repo.findOne(Example.of(ofLanguage)) error 1501.
	 */
	@Override
	public OfLanguage save(final OfLanguage ofLanguage) {
		OfLanguage toSave = this.repository.getByVertexIds(ofLanguage).orElse(ofLanguage);
		super.preSave(toSave);
		return repository.save(toSave);
	}

	@Override
	public Iterable<OfLanguage> findAll() {
		return repository.findAll();
	}

}
