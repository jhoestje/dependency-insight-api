package org.johoco.depinsight.service.impl;

import org.johoco.depinsight.domain.Packaging;
import org.johoco.depinsight.repository.PackagingRepository;
import org.johoco.depinsight.service.IPackagingService;
import org.springframework.stereotype.Service;

import lombok.NonNull;

@Service
public class PackagingService implements IPackagingService {

	private PackagingRepository repository;

	public PackagingService(final PackagingRepository repository) {
		this.repository = repository;
	}

	@Override
	public Packaging save(@NonNull Packaging version) {
		// TODO Auto-generated method stub
		return repository.save(version);
	}

	@Override
	public Packaging findPackagingByValue(String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
