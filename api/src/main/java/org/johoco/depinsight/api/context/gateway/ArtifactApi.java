package org.johoco.depinsight.api.context.gateway;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.Build;
import org.johoco.depinsight.domain.CiManagement;
import org.johoco.depinsight.domain.Contributor;
import org.johoco.depinsight.domain.Developer;
import org.johoco.depinsight.domain.DistributionManagement;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.IssueManagement;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.License;
import org.johoco.depinsight.domain.Organization;
import org.johoco.depinsight.domain.Packaging;
import org.johoco.depinsight.domain.Repository;
import org.johoco.depinsight.domain.Scm;
import org.johoco.depinsight.domain.Version;
import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.domain.relationship.OfArtifactId;
import org.johoco.depinsight.domain.relationship.OfBuild;
import org.johoco.depinsight.domain.relationship.OfCiManagement;
import org.johoco.depinsight.domain.relationship.OfContributor;
import org.johoco.depinsight.domain.relationship.OfDeveloper;
import org.johoco.depinsight.domain.relationship.OfDistributionManagement;
import org.johoco.depinsight.domain.relationship.OfGavp;
import org.johoco.depinsight.domain.relationship.OfGroupId;
import org.johoco.depinsight.domain.relationship.OfIssueManagement;
import org.johoco.depinsight.domain.relationship.OfLanguage;
import org.johoco.depinsight.domain.relationship.OfLicense;
import org.johoco.depinsight.domain.relationship.OfOrganization;
import org.johoco.depinsight.domain.relationship.OfRepository;
import org.johoco.depinsight.domain.relationship.OfScm;
import org.johoco.depinsight.domain.relationship.OfVersion;
import org.johoco.depinsight.service.IArtifactIdService;
import org.johoco.depinsight.service.IArtifactService;
import org.johoco.depinsight.service.IBuildService;
import org.johoco.depinsight.service.ICiManagementService;
import org.johoco.depinsight.service.IContributorService;
import org.johoco.depinsight.service.IDeveloperService;
import org.johoco.depinsight.service.IDistributionManagementService;
import org.johoco.depinsight.service.IGroupIdService;
import org.johoco.depinsight.service.IIssueManagementService;
import org.johoco.depinsight.service.ILanguageService;
import org.johoco.depinsight.service.ILicenseService;
import org.johoco.depinsight.service.IOfCiManagementService;
import org.johoco.depinsight.service.IOfIssueManagementService;
import org.johoco.depinsight.service.IOrganizationService;
import org.johoco.depinsight.service.IPackagingService;
import org.johoco.depinsight.service.IPluginRepositoryService;
import org.johoco.depinsight.service.IRepositoryService;
import org.johoco.depinsight.service.IScmService;
import org.johoco.depinsight.service.IVersionService;
import org.johoco.depinsight.service.IofArtifactIdService;
import org.johoco.depinsight.service.IofBuildService;
import org.johoco.depinsight.service.IofChildArtifactService;
import org.johoco.depinsight.service.IofContributorService;
import org.johoco.depinsight.service.IofDeveloperService;
import org.johoco.depinsight.service.IofDistributionManagementService;
import org.johoco.depinsight.service.IofGavpService;
import org.johoco.depinsight.service.IofGroupIdService;
import org.johoco.depinsight.service.IofLanguageService;
import org.johoco.depinsight.service.IofLicenseService;
import org.johoco.depinsight.service.IofOrganizationService;
import org.johoco.depinsight.service.IofPluginRepositoryService;
import org.johoco.depinsight.service.IofRepositoryService;
import org.johoco.depinsight.service.IofScmService;
import org.johoco.depinsight.service.IofVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
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
	private IofGavpService ofGavpService;
	private IofChildArtifactService ofChildArtifactService;

	private ILicenseService licenseService;
	private IDeveloperService developerService;
	private IContributorService contributorService;

	private IScmService scmService;
	private IofScmService ofScmService;

	private IIssueManagementService issueManagementService;
	private IOfIssueManagementService ofIssueManagementService;

	private ICiManagementService ciManagementService;
	private IOfCiManagementService ofCiManagementService;

	private IRepositoryService repoService;
	private IofRepositoryService ofRepoService;

	private IPluginRepositoryService pluginRepoService;
	private IofPluginRepositoryService ofPluginRepoService;

	private IDistributionManagementService distroManagementService;
	private IofDistributionManagementService ofDistroManagementService;

	private IBuildService buildService;
	private IofBuildService ofBuildService;

	private IOrganizationService orgService;
	private IofOrganizationService ofOrgService;

	private IofLicenseService ofLicenseService;
	private IofDeveloperService ofDevService;
	private IofContributorService ofContributorService;

	@Autowired
	public ArtifactApi(final IArtifactService service, final IGroupIdService gidService,
			final IArtifactIdService aidService, final IVersionService versionService,
			final IPackagingService packagingService, final ILanguageService languaageService,
			final IofLanguageService ofLanguageService, final IofGroupIdService ofGroupIdService,
			final IofArtifactIdService ofArtifactIdService, final IofVersionService ofVersionService,
			final IofGavpService ofGavpService, final IofChildArtifactService ofChildArtifactService,
			final IOrganizationService orgService, final IofOrganizationService ofOrgService,
			final IofLicenseService ofLicenseService, final IofDeveloperService ofDevService,
			final IofContributorService ofContributorService, final ILicenseService licenseService,
			final IDeveloperService developerService, final IContributorService contributorService,
			final IScmService scmService, final IofScmService ofScmService,
			final IIssueManagementService issueManagementService,
			final IOfIssueManagementService ofIssueManagementService, final ICiManagementService ciManagementService,
			final IOfCiManagementService ofCiManagementService) {
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
		this.ofGavpService = ofGavpService;
		this.ofChildArtifactService = ofChildArtifactService;
		this.orgService = orgService;
		this.ofOrgService = ofOrgService;
		this.ofLicenseService = ofLicenseService;
		this.ofDevService = ofDevService;
		this.ofContributorService = ofContributorService;
		this.licenseService = licenseService;
		this.developerService = developerService;
		this.contributorService = contributorService;
		this.scmService = scmService;
		this.issueManagementService = issueManagementService;
		this.ofIssueManagementService = ofIssueManagementService;
		this.ofScmService = ofScmService;
		this.ciManagementService = ciManagementService;
		this.ofCiManagementService = ofCiManagementService;
	}

	public Artifact getArtifactByKey(final ArtifactKey key) {
		return service.getByKey(key);
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
			// change to finding later
//			Language savedLanguage = languageService.findByValue(language.getValue());
			Language savedLanguage = languageService.save(language);

			// save the documents
			final GroupId groupid = gidService.save(language, artifact.getKey().getGroupIdValue());
			final ArtifactId artifactId = aidService.save(language, groupid, artifact.getKey().getArtifactIdValue());
			final Version version = versionService.save(language, groupid, artifactId, artifact.getKey().getVersion());
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

			final Artifact savedArtifact = service.save(artifact);

			final OfGavp ofGavp = new OfGavp(savedArtifact, packaging);
			ofGavpService.save(ofGavp);

			if (savedArtifact.getOrganization() != null) {
				Organization o = orgService.save(savedArtifact.getOrganization());
				final OfOrganization ofO = new OfOrganization(savedArtifact, o);
				ofOrgService.save(ofO);
			}

			if (!CollectionUtils.isEmpty(savedArtifact.getLicenses())) {
				for (License l : savedArtifact.getLicenses()) {
					License savedL = licenseService.save(l);
					final OfLicense ofL = new OfLicense(savedArtifact, savedL);
					ofLicenseService.save(ofL);
				}
			}

			if (!CollectionUtils.isEmpty(savedArtifact.getDevelopers())) {
				for (Developer d : savedArtifact.getDevelopers()) {
					Developer savedD = developerService.save(d);
					final OfDeveloper ofD = new OfDeveloper(savedArtifact, savedD);
					ofDevService.save(ofD);
				}
			}

			if (!CollectionUtils.isEmpty(savedArtifact.getContributors())) {
				for (Contributor c : savedArtifact.getContributors()) {
					Contributor savedC = contributorService.save(c);
					final OfContributor ofC = new OfContributor(savedArtifact, savedC);
					ofContributorService.save(ofC);
				}
			}

//			private List<MailingList> mailingLists;
//			private Prerequisite prerequisites;
//			private List<String> modules;

			if (savedArtifact.getScm() != null) {
				Scm s = savedArtifact.getScm();
				Scm savedS = scmService.save(s);
				final OfScm ofS = new OfScm(savedArtifact, savedS);
				ofScmService.save(ofS);
			}

			if (savedArtifact.getIssueManagement() != null) {
				IssueManagement s = savedArtifact.getIssueManagement();
				IssueManagement savedS = issueManagementService.save(s);
				final OfIssueManagement ofS = new OfIssueManagement(savedArtifact, savedS);
				ofIssueManagementService.save(ofS);
			}

			if (savedArtifact.getCiManagement() != null) {
				CiManagement s = savedArtifact.getCiManagement();
				CiManagement savedS = ciManagementService.save(s);
				final OfCiManagement ofcm = new OfCiManagement(savedArtifact, savedS);
				ofCiManagementService.save(ofcm);
			}

			if (!CollectionUtils.isEmpty(savedArtifact.getRepositories())) {
				for (Repository r : savedArtifact.getRepositories()) {
					Repository savedR = repoService.save(r);
					final OfRepository ofR = new OfRepository(savedArtifact, savedR);
					ofRepoService.save(ofR);
				}
			}

			if (!CollectionUtils.isEmpty(savedArtifact.getPluginRepositories())) {
//				for (PluginRepository r : savedArtifact.getPluginRepositories()) {
//					PluginRepository savedR = pluginRepoService.save(r);
//					final OfPluginRepository ofR = new OfPluginRepository(savedArtifact, savedR);
//					ofPluginRepoService.save(ofR);
//				}
			}

			if (savedArtifact.getDistributionManagement() != null) {
				DistributionManagement dm = savedArtifact.getDistributionManagement();
				DistributionManagement savedDm = distroManagementService.save(dm);
				final OfDistributionManagement ofDm = new OfDistributionManagement(savedArtifact, savedDm);
				ofDistroManagementService.save(ofDm);
			}

			if (savedArtifact.getBuild() != null) {
				Build b = savedArtifact.getBuild();
				Build savedB = buildService.save(b);
				final OfBuild ofB = new OfBuild(savedArtifact, savedB);
				ofBuildService.save(ofB);
			}

//			private DistributionManagement distributionManagement;
//			private List<DependencyManagement> dependencyManagement;
//			private List<Dependency> dependencies;
//			private Map<String, String> properties;
//			private List<Repository> repositories;
//			private List<Repository> pluginRepositories;

			// save the document itself
			return savedArtifact;
		} catch (Exception e) {
			// TODO change to specific exceptions
			e.printStackTrace();
			throw e;
		}

	}

	public Artifact find(ArtifactKey key) {
		// TODO Auto-generated method stub
		return null;
	}
}
