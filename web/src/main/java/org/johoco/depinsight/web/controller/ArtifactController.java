package org.johoco.depinsight.web.controller;

import org.johoco.depinsight.service.impl.ArtifactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtifactController {

	private final static Logger LOG = LoggerFactory.getLogger(ArtifactController.class);
	private ArtifactService service;

	@Autowired
	public ArtifactController(final ArtifactService service) {
		this.service = service;
	}
}
