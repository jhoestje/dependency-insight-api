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
public class Notifier {
	private String type;
	private String sendOnError; // boolean
	private String sendOnFailure; // boolean
	private String sendOnSuccess; // boolean
	private String sendOnWarning; // boolean
	private String address;
// configuration element <xs:any minOccurs="0" maxOccurs="unbounded" processContents="skip"/>
}
