package org.faeterj.apicoruja.coruja.log;

public final class BootMessage {
	public static void log (Object object) {
		String className = object.getClass ( ).toString ( );
		System.out.println ("=== Iniciando " + className + "... ===");
	}
}

// OK