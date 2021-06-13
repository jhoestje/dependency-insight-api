package org.johoco.depinsight.api.context.gateway;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.Packaging;
import org.johoco.depinsight.domain.Version;
import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.domain.relationship.OfArtifactId;
import org.johoco.depinsight.domain.relationship.OfGroupId;
import org.johoco.depinsight.domain.relationship.OfLanguage;
import org.johoco.depinsight.domain.relationship.OfVersion;
import org.johoco.depinsight.service.IArtifactIdService;
import org.johoco.depinsight.service.IArtifactService;
import org.johoco.depinsight.service.IGroupIdService;
import org.johoco.depinsight.service.ILanguageService;
import org.johoco.depinsight.service.IPackagingService;
import org.johoco.depinsight.service.IVersionService;
import org.johoco.depinsight.service.IofArtifactIdService;
import org.johoco.depinsight.service.IofGroupIdService;
import org.johoco.depinsight.service.IofLanguageService;
import org.johoco.depinsight.service.IofVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtifactApi {

	private IArtifactService service;
	private IGroupIdService gidService;
	private IArtifactIdService aidService;
	private IVersionService versionService;
	private IPackagingService packagingService;
	private ILanguageService languageService;
	private IofLanguageService ofLanguageService;
	private IofGroupIdService ofGidService;
	private IofArtifactIdService ofAidService;
	private IofVersionService ofVersionService;

	@Autowired
	public ArtifactApi(final IArtifactService service, final IGroupIdService gidService,
			final IArtifactIdService aidService, final IVersionService versionService,
			final IPackagingService packagingService, final ILanguageService languaageService,
			final IofLanguageService ofLanguageService, final IofGroupIdService ofGroupIdService,
			final IofArtifactIdService ofArtifactIdService, final IofVersionService ofVersionService) {
		this.service = service;
		this.gidService = gidService;
		this.aidService = aidService;
		this.versionService = versionService;
		this.packagingService = packagingService;
		this.languageService = languaageService;
		this.ofLanguageService = ofLanguageService;
		this.ofGidService = ofGroupIdService;
		this.ofAidService = ofArtifactIdService;
		this.ofVersionService = ofVersionService;
	}

	public Artifact findGroupId(final ArtifactKey key) {
		return service.find(key);
	}

	/**
	 * Make sure all the parts are saved as well as the Artifact object.
	 * 
	 * Language must already exist and is not a dynamic value
	 * 
	 * @param language
	 * @param artifact
	 * @return persisted artifact
	 * @throws Exception
	 */
	public Artifact save(final Language language, final Artifact artifact) throws Exception {

		// language
		try {
			Language savedLanguage = languageService.findByValue(language.getValue());
			// save the documents
			final GroupId groupid = gidService.save(language, artifact.getKey().getGroupId());
			final ArtifactId artifactId = aidService.save(artifact.getKey().getArtifactId());
			final Version version = versionService.save(artifact.getKey().getVersion());
			final Packaging packaging = packagingService.save(artifact.getKey().getPackaging());

			final OfLanguage ofl = new OfLanguage(groupid, savedLanguage);
			final OfGroupId ofGid = new OfGroupId(artifactId, groupid);
			final OfArtifactId ofAid = new OfArtifactId(version, artifactId);
			final OfVersion ofV = new OfVersion(packaging, version);

			// save the relationships
			this.ofLanguageService.save(ofl);
			this.ofGidService.save(ofGid);
			this.ofAidService.save(ofAid);
			this.ofVersionService.save(ofV);

			// save the document itself
			return service.save(artifact);
		} catch (Exception e) {
			// TODO change to specific exceptions
			e.printStackTrace();
			throw e;
		}

	}
}
