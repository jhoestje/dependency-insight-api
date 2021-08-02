package org.johoco.depinsight.web.dto.converter;

import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.dto.ArtifactKeyDTO;
import org.johoco.depinsight.dto.Pom;

public class ArtifactConverter {
	public static Artifact convert(final Pom dto) {
		final ArtifactKey key = ArtifactKeyConverter.convert(dto);
		Artifact a = new Artifact(key);
		a.setOrganization(OrganizationConverter.convert(dto.getOrganization()));
		a.setLicenses(LicenseConverter.convert(dto.getLicenses()));
		a.setDevelopers(DeveloperConverter.convert(dto.getDevelopers()));
		a.setContributors(ContributorConverter.convert(dto.getContributors()));
		a.setMailingLists(MailingListConverter.convert(dto.getMailingLists()));
		a.setPrerequisites(PrerequisiteConverter.convert(dto.getPrerequisites()));
		a.setModules(dto.getModules());
		a.setScm(ScmConverter.convert(dto.getScm()));
		a.setIssueManagement(IssueManagementConverter.convert(dto.getIssueManagement()));
		a.setCiManagement(CiManagementConverter.convert(dto.getCiManagement()));
//		 List<DependencyManagement> dependencyManagement;
//		 List<Dependency> dependencies;
		a.setProperties(dto.getProperties());
		a.setRepositories(RepositoryConverter.convert(dto.getRepositories()));
		// a.setPluginRepositories(PluginRepositoryConverter.convert(dto.getPluginRepositories()));

		return a;
	}

	public static ArtifactKeyDTO convertToKey(final Artifact a) {
		return ArtifactKeyDTO.builder().language("").groupId(a.getKey().getGroupIdValue())
				.artifactId(a.getKey().getArtifactIdValue()).version(a.getKey().getVersion())
				.packaging(a.getKey().getPackaging()).createdDate(a.getCreatedDate())
				.lastUpdatedDate(a.getLastUpdatedDate()).build();
	}

	public static Artifact convert(ArtifactKeyDTO artifactDto) {
		ArtifactKey ak = ArtifactKey.builder().groupIdValue(artifactDto.getGroupId())
				.artifactIdValue(artifactDto.getArtifactId()).version(artifactDto.getVersion())
				.language(artifactDto.getLanguage()).packaging(artifactDto.getPackaging()).build();

		return new Artifact(ak);
	}
}
