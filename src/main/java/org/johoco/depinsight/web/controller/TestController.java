package org.johoco.depinsight.web.controller;

import org.johoco.depinsight.api.context.gateway.ArtifactApi;
import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.Packaging;
import org.johoco.depinsight.domain.Version;
import org.johoco.depinsight.domain.composite.Artifact;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.domain.key.ArtifactIdKey;
import org.johoco.depinsight.domain.key.GroupIdKey;
import org.johoco.depinsight.domain.key.VersionKey;
import org.johoco.depinsight.service.ILanguageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	private final static Logger LOG = LoggerFactory.getLogger(TestController.class);

//	@Autowired
//	private WebConfig appConfig;

//	@Autowired
//	private WebProperties appProperities;

	@Autowired
	private ILanguageService languageService;

	@Autowired
	private ArtifactApi artifactApi;

	@Value("${messagez:Hello default}")
	private String message;

	@GetMapping("/validate")
	public Iterable<Language> testNeo() {
		System.out.println("4444444444444444444444444444444444444444");
		LOG.debug("whoooohoooowoooohoooowoooohoooowoooohoooo");

		// LanguageKey lk = new LanguageKey("JAVA");
		Language javaLang = new Language();
		javaLang.setValue("SMALLTALK");
		javaLang = languageService.save(javaLang);

		GroupIdKey gidKey = new GroupIdKey(javaLang.getValue(), "st2");
		GroupId gId1 = new GroupId(gidKey);

		ArtifactIdKey aidKey = new ArtifactIdKey(gidKey.getLanguage(), gidKey.getGroupIdValue(), "aid1");
		ArtifactId aid1 = new ArtifactId(aidKey);

		VersionKey vKey = new VersionKey(gidKey.getLanguage(), gidKey.getGroupIdValue(), aid1.getValue(), "1.0.0");
		Version v = new Version(vKey);

		Packaging p = new Packaging();
		p.setValue("JAR");

		ArtifactKey akey = new ArtifactKey("java", gId1.getKey().getGroupIdValue(), aid1.getValue(), v.getValue(),
				p.getValue());
		Artifact art = new Artifact(akey);

		try {
			artifactApi.save(javaLang, art);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return languageService.findAll();
	}

	@GetMapping("/message")
	String getMessage() {
		return this.message;
	}

//	public void run() throws Exception {
//		System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");
//		System.out.println("using environment: " + appProperities.getEnvironment());
//		System.out.println("name: " + appProperities.getName());
//	}
}
