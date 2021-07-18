package org.johoco.depinsight.web.controller;

import org.johoco.depinsight.api.context.gateway.ArtifactApi;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.dto.ArtifactKeyDTO;
import org.johoco.depinsight.dto.Pom;
import org.johoco.depinsight.web.dto.converter.ArtifactConverter;
import org.johoco.depinsight.web.dto.converter.PomConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artifact")
public class ArtifactController {

	private final static Logger LOGR = LoggerFactory.getLogger(ArtifactController.class);
	private ArtifactApi api;

	@Autowired
	public ArtifactController(final ArtifactApi api) {
		this.api = api;
	}

	@GetMapping("/find/language/{lang}/g/{groupId}/a/{artifactId}/v/{version}/p/{packaging}")
	public ArtifactKeyDTO getArtifact(@PathVariable("lang") final String language,
			@PathVariable("groupId") final String groupId, @PathVariable("artifactId") final String artifactId,
			@PathVariable("version") final String version, @PathVariable("packaging") final String packaging) {
		final ArtifactKey key = new ArtifactKey(language, groupId, artifactId, version, packaging);
		ArtifactKeyDTO found = ArtifactConverter.convertToKey(this.api.find(key));
		// return 404 otherwise 200
		return found;
	}

	@GetMapping("/find/pom/language/{lang}/g/{groupId}/a/{artifactId}/v/{version}/p/{packaging}")
	public Pom getArtifactPom(@PathVariable("lang") final String language,
			@PathVariable("groupId") final String groupId, @PathVariable("artifactId") final String artifactId,
			@PathVariable("version") final String version, @PathVariable("packaging") final String packaging) {
		final ArtifactKey key = new ArtifactKey(language, groupId, artifactId, version, packaging);
		Pom found = PomConverter.convert(this.api.find(key));
		// return 404 otherwise 200
		return found;
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public ArtifactKeyDTO createArtifactByKey(@RequestBody final ArtifactKeyDTO artifactDto) {
		Artifact artifact = ArtifactConverter.convert(artifactDto);

		Language lang = new Language();
		lang.setValue(artifactDto.getLanguage());

		Artifact saved = null;
		try {
			saved = this.api.save(lang, artifact);
		} catch (Exception e) {
			LOGR.error("Bad create", e);
		}
		return ArtifactConverter.convertToKey(saved);
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

		Language lang = new Language();
		lang.setValue(pomDto.getLanguage());

		Artifact saved = null;
		try {
			saved = this.api.save(lang, artifact);
		} catch (Exception e) {
			LOGR.error("Bad create", e);
		}
		return PomConverter.convert(saved);
	}

	@PutMapping("/update")
	public ArtifactKeyDTO updateArtifact(@RequestBody final ArtifactKeyDTO artifactDto) {
		Artifact artifact = null; // PomConverter.convert(artifactDto);

		Language lang = new Language();
		lang.setValue(artifactDto.getLanguage());

		Artifact saved = null;
		try {
			saved = null;// this.api.save(lang, artifact);
		} catch (Exception e) {
			LOGR.error("Bad update", e);
		}
		return null; // ArtifactConverter.convert(saved);
	}
}
