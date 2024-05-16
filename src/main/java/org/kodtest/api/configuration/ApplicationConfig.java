package org.kodtest.api.configuration;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {
		register(new ApplicationBinder());
		packages(true, "org.kodtest.api.resource");
	}
}