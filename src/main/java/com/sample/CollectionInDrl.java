package com.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class CollectionInDrl {
	public static final void main(String[] args) {
		try {

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
}