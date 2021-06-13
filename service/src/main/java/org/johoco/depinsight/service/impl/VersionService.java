package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.Version;
import org.johoco.depinsight.repository.VersionRepository;
import org.johoco.depinsight.service.IVersionService;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class VersionService implements IVersionService {

	private VersionRepository repository;

	public VersionService(final VersionRepository repository) {
		this.repository = repository;
	}

	@Override
	public Version save(@NonNull Version version) {
		// TODO Auto-generated method stub
		return repository.save(version);
	}

	@Override
	public Version findVersionByValue(String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
