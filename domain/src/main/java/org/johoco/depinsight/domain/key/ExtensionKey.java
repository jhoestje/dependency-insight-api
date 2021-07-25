package org.johoco.depinsight.domain.key;

import org.johoco.depinsight.domain.composite.key.Key;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@Getter
public class ExtensionKey implements Key {
	@NonNull
	private String groupId;
	@NonNull
	private String artifactId;
	@NonNull
	private String Version;

}
