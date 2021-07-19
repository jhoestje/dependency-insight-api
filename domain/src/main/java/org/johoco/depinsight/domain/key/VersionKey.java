package org.johoco.depinsight.domain.key;

import org.johoco.depinsight.domain.composite.key.Key;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@Getter
public class VersionKey implements Key {

	@NonNull
	private String language;

	@NonNull
	private String groupIdValue;

	@NonNull
	private String artifactIdValue;

	@NonNull
	private String versionValue;
}
