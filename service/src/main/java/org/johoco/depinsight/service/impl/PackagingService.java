package org.johoco.depinsight.service.impl;

import java.util.Optional;

import org.johoco.depinsight.domain.Packaging;
import org.johoco.depinsight.repository.arangodb.PackagingArangoRepository;
import org.johoco.depinsight.service.IPackagingService;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class PackagingService implements IPackagingService {

	private PackagingArangoRepository repository;

	public PackagingService(final PackagingArangoRepository repository) {
		this.repository = repository;
	}

	@Override
	public Packaging save(@NonNull Packaging version) {
		// TODO Auto-generated method stub
		return repository.save(version);
	}

	@Override
	public Optional<Packaging> findPackagingByValue(String packaging) {
		return this.repository.findByValue(packaging);
	}

	@Override
	public Packaging save(@NonNull String packaging) {
		Optional<Packaging> existing = this.repository.findByValue(packaging);
		if (existing.isEmpty()) {
			Packaging aid = new Packaging();
			aid.setValue(packaging);
			return this.repository.save(aid);
		}
		return existing.get();
	}

}
