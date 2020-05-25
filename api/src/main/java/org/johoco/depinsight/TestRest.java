package org.johoco.depinsight;

import org.johoco.depinsight.api.config.AppConfig;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.johoco.depinsight.repository.LanguageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRest {
	
	private final static Logger LOG = LoggerFactory.getLogger(TestRest.class);
	
	@Autowired
	private AppConfig appConfig;
	
	@Autowired
	private LanguageRepository languageRepo;

	
	@GetMapping("/validate/")
	public String testNeo() {
		System.out.println("4444444444444444444444444444444444444444");
		LOG.debug("whoooohoooowoooohoooowoooohoooowoooohoooo");
		
		Language javaLang = new Language();
		javaLang.setValue("JAVA");
		
		GroupId gId1 = new GroupId();
		gId1.setValue("org");
		
		languageRepo.save(javaLang);
		
		return "asdfasdfasdfsadfsdaf";
	}
	
	public void run() throws Exception {
		System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");
		System.out.println("using environment: " + appConfig.getEnvironment());
		System.out.println("name: " + appConfig.getName());
	}
}
