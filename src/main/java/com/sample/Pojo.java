package com.sample;

import java.util.List;
import java.util.Map;

public class Pojo {
	private Map<String, List<String>> cityPlaces;

	public Map<String, List<String>> getCityPlaces() {
		return cityPlaces;
	}

	public void setCityPlaces(Map<String, List<String>> cityPlaces) {
		this.cityPlaces = cityPlaces;
	}
}