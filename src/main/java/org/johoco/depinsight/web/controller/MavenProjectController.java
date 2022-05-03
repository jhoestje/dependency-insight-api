package org.johoco.depinsight.web.controller;

import org.johoco.depinsight.api.context.gateway.MavenProjectApi;
import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.dto.Pom;
import org.johoco.depinsight.web.dto.converter.ArtifactConverter;
import org.johoco.depinsight.web.dto.converter.PomConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/maven/artifact")
public class MavenProjectController {

	private final static Logger LOGR = LoggerFactory.getLogger(MavenProjectController.class);
	private MavenProjectApi api;

	@Autowired
	public MavenProjectController(final MavenProjectApi api) {
		this.api = api;
	}

	/**
	 * POM may not be a good vehicle since a lot of dependency information isn't in
	 * the POM but inherited. Maybe save everything except the dependencies.
	 * 
	 * @param artifactDto
	 * @return
	 */
	@PostMapping("/create/pom")
	@ResponseStatus(HttpStatus.CREATED)
	public Pom createArtifactByPom(@RequestBody final Pom pomDto) {
		LOGR.debug("received request to create artifact by Pom");
		Artifact artifact = ArtifactConverter.convert(pomDto);

		Artifact saved = null;
		try {
			saved = this.api.savez(null, artifact);
		} catch (Exception e) {
			LOGR.error("Bad create", e);
		}
		return PomConverter.convert(saved);
	}

}
