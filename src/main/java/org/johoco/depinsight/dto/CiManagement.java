package org.johoco.depinsight.dto;

import java.util.List;

import lombok.Data;

/**
 *
 *
 * @author John Hoestje
 */
@Data
public class CiManagement {
	private String system;
	private String url;
	List<Notifier> notifiers;
}
