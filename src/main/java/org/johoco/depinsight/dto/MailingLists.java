package org.johoco.depinsight.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 *
 * @author John Hoestje
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MailingLists {
	private String name;
	private String subscribe;
	private String unsubscribe;
	private String post;
	private String archive;
	private String otherArchives;
}
