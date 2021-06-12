package org.johoco.depinsight.api.context.gateway;

import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.service.IArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtifactApi {
	private IArtifactService service;

	@Autowired
	public ArtifactApi(final IArtifactService service) {
		this.service = service;
	}
	
	public Artifact findGroupId(final ArtifactKey key) {
		return service.find(key);
	}

	public Artifact save(Artifact artifact) {
		return service.save(artifact);
	}
}
