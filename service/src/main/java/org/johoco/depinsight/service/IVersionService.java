package org.johoco.depinsight.service;

import org.johoco.depinsight.domain.Version;

import lombok.NonNull;

public interface IVersionService {

	Version save(final @NonNull Version version);

	Version findVersionByValue(final String value);
}
