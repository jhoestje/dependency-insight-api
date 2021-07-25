package org.johoco.depinsight.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PluginExecution implements Serializable {
	private static final long serialVersionUID = -7953088214624406036L;

	private String id;
	private String phase;
	private List<String> goals;
	private String inherited;
	// configuration element per XSD: <xs:any minOccurs="0" maxOccurs="unbounded"
	// processContents="skip"/>
}
