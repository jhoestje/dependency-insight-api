package org.johoco.depinsight.service.impl;

import java.util.Optional;

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
	public Optional<Version> findVersionByValue(final String version) {
		return this.repository.findByValue(version);
	}

	@Override
	public Version save(@NonNull final String version) {
		Optional<Version> existing = this.repository.findByValue(version);
		if (existing.isEmpty()) {
			Version v = new Version();
			v.setValue(version);
			return this.repository.save(v);
		}
		return existing.get();
	}

}
