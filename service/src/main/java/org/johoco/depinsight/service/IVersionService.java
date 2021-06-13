package org.johoco.depinsight.service;

import java.util.Optional;

import org.johoco.depinsight.domain.Version;

import lombok.NonNull;

public interface IVersionService {

	Version save(final @NonNull Version version);

	Optional<Version> findVersionByValue(final String value);

	Version save(@NonNull final String version);
}
