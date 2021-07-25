package org.johoco.depinsight.domain.key;

import org.johoco.depinsight.domain.composite.key.Key;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Deprecated
@RequiredArgsConstructor
@ToString
@Getter
public class MailingListKey implements Key {

	@NonNull
	private String name;
	@NonNull
	private String subscribe;
	private String unsubscribe;
	private String post;
	private String archive;
	private String otherArchives;

}
