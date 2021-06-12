package org.johoco.depinsight.web.controller;

import org.johoco.depinsight.api.context.bounded.GroupIdApi;
import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.relationship.OfGroupId;
import org.johoco.depinsight.domain.relationship.OfLanguage;
import org.johoco.depinsight.service.ILanguageService;
import org.johoco.depinsight.service.IOfLanguageService;
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
	private IOfLanguageService languageTypeService;

	@Autowired
	private GroupIdApi groupIdApi;

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

		GroupId gId1 = new GroupId();
		gId1.setValue("st2");

		// gId1.setLanguage(javaLang);

		ArtifactId aid1 = new ArtifactId();
		aid1.setValue("aid1");

		OfGroupId pgid = new OfGroupId();
		pgid.setArtifactId(aid1);
		pgid.setGroupId(gId1);

		//aid1.setGroupId(pgid);

		GroupId savedgid = groupIdApi.save(gId1);

		OfLanguage lt = new OfLanguage(savedgid, javaLang);
//		lt.setGroupId(gId1);
//		lt.setLanguage(javaLang);
		languageTypeService.save(lt);

//		List<GroupId> gids = new ArrayList<>();
//		gids.add(gId1);

//		javaLang.setGroupIds(gids);

//		languageService.save(javaLang);

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
