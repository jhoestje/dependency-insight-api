package org.johoco.depinsight.domain;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Resources implements Serializable {
	private static final long serialVersionUID = -9002679944804737661L;
	private String targetPath;
	private String filtering;
	private String directory;
	// example includes <code>**&#47;*.xml</code>
	List<String> includes;
	// FIXME: what to do about exclues??
//	List<Excludes> excludes;
	List<String> excludes;
}
