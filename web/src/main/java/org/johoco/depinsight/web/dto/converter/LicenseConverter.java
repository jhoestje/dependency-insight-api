package org.johoco.depinsight.web.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.johoco.depinsight.domain.License;
import org.johoco.depinsight.domain.key.LicenseKey;

public class LicenseConverter {
	public static License convert(final org.johoco.depinsight.dto.License dto) {
		LicenseKey key = new LicenseKey(dto.getName(), dto.getUrl(), dto.getDistribution());
		return new License(key);
	}

	public static org.johoco.depinsight.dto.License convert(final License license) {
		org.johoco.depinsight.dto.License dto = new org.johoco.depinsight.dto.License();
		dto.setName(license.getName());
		dto.setUrl(license.getUrl());
		dto.setDistribution(license.getDistribution());
		return dto;
	}

	public static List<License> convert(final List<org.johoco.depinsight.dto.License> licenseDtos) {
		List<License> ls = new ArrayList<>();
		for (org.johoco.depinsight.dto.License dto : licenseDtos) {
			ls.add(convert(dto));
		}
		return ls;
	}

	public static List<org.johoco.depinsight.dto.License> convertz(final List<License> licenses) {
		List<org.johoco.depinsight.dto.License> dtos = new ArrayList<>();
		for (License l : licenses) {
			dtos.add(convert(l));
		}
		return dtos;
	}

}
