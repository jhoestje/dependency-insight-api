package org.johoco.depinsight.web.controller;

import java.util.Date;

import org.johoco.depinsight.api.context.bounded.GroupIdApi;
import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.domain.relationship.LanguageType;
import org.johoco.depinsight.domain.relationship.PartOfGroupId;
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

		GroupId gId1 = new GroupId();
		gId1.setValue("st2");
		
		LanguageType lt = new LanguageType();
		lt.setGroupId(gId1);
		lt.setLanguage(javaLang);
		lt.setCreatedDate(new Date());

		gId1.setLanguage(lt);
		
		ArtifactId aid1 = new ArtifactId();
		aid1.setValue("aid1");
		
		PartOfGroupId pgid = new PartOfGroupId();
		pgid.setArtifactId(aid1);
		pgid.setGroupId(gId1);
		pgid.setCreatedDate(new Date());
		
		aid1.setPartOfGroupId(pgid);
		
		groupIdApi.save(gId1);
		
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
