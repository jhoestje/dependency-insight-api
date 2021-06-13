package org.johoco.depinsight.service;

import java.util.Optional;

import org.johoco.depinsight.domain.Packaging;

import lombok.NonNull;

public interface IPackagingService {

	Packaging save(final @NonNull Packaging packaging);

	Optional<Packaging> findPackagingByValue(final String value);

	Packaging save(@NonNull final String packaging);
}
