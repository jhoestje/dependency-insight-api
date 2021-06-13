package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.Packaging;

import lombok.NonNull;

public interface IPackagingService {

	Packaging save(final @NonNull Packaging packaging);

	Packaging findPackagingByValue(final String value);
}
