package org.johoco.depinsight.domain.key;

import org.johoco.depinsight.domain.composite.key.Key;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@Getter
public class CiManagementKey implements Key {

	@NonNull
	private String url;

}
