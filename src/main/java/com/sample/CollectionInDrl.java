package com.sample;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class CollectionInDrl {
	public static final void main(String[] args) {
		try {

//			KieSession kieSession = readKnowledgeBase();
			KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kieSession = kContainer.newKieSession("ksession-rules");

			Pojo pojo = new Pojo();
			Map<String, List<String>> map = new HashMap<String, List<String>>();
			List<String> cityMumbai = new ArrayList<String>();
			cityMumbai.add("Thane");
			cityMumbai.add("Ghatkopar");
			map.put("Mumbai", cityMumbai);
			List<String> cityPune = new ArrayList<String>();
			cityPune.add("Chinchwad");
			cityPune.add("Shivajinagar");
			map.put("Pune", cityPune);
			pojo.setCityPlaces(map);
			kieSession.insert(pojo);
			kieSession.fireAllRules();
			kieSession.dispose();
			System.out.println("Done!");
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

//	private static KieSession readKnowledgeBase() throws Exception {
//
//		KieServices ks = KieServices.Factory.get();
//		KieFileSystem kfs = ks.newKieFileSystem();
//		FileInputStream fis = new FileInputStream("./src/main/resources/rules/DroolCollection.drl");
//		kfs.write("DroolCollection.drl", ks.getResources().newInputStreamResource(fis));
//		KieBuilder kieBuilder = ks.newKieBuilder(kfs).buildAll();
//		Results results = kieBuilder.getResults();
//		if (results.hasMessages(Message.Level.ERROR)) {
//			System.out.println(results.getMessages());
//			throw new IllegalStateException("### errors ###");
//		}
//		KieContainer kieContainer = ks.newKieContainer(ks.getRepository().getDefaultReleaseId());
//
//		KieBaseConfiguration config = ks.newKieBaseConfiguration();
//		config.setOption(EventProcessingOption.STREAM);
//		KieBase kieBase = kieContainer.newKieBase(config);
//		KieSession kieSession = kieBase.newKieSession();
//		
////		KieContainer kieClasspathContainer = KieServices.Factory.get().getKieClasspathContainer();
////	    KieSession kieSession = kieClasspathContainer.newKieSession("StatefulPassportValidationStep" + "Mumbai");
//
//		return kieSession;
//	}
}