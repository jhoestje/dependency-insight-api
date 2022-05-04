package org.johoco.depinsight.dto;

import lombok.Data;

@Data
public class ChecksumDTO {
	private String sha1;
	private String sha512;
	private String sha256;
	private String md5;
}
