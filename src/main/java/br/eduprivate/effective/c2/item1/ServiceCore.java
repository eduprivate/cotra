package br.eduprivate.effective.c2.item1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceCore {

	private static final Map<String, Core> coreProviders = 
			new ConcurrentHashMap();
	private static final String DEFAULT_CORE_NAME = "index";
	
	private ServiceCore(){
	}
	
	public static void registerDefaultCoreService(Core core) {
		coreProviders.put(DEFAULT_CORE_NAME, core);
	}
	
	public static void registerCoreService(String name, Core core) {
		coreProviders.put(name, core);
	}
	
	public static Core newDefaultInstance(){
		return newInstance(DEFAULT_CORE_NAME);
	}
	
	public static Core newInstance(String name) {
		Core core = coreProviders.get(name);
		if (core == null) {
			throw new IllegalArgumentException(
	                "No provider registered with name: " + name); 
		}
		return core;
	}
	
}
