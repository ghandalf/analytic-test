package ca.ghandalf.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import ca.ghandalf.web.analytic.ProviderServlet;

@Configuration
public class ApplicationConfig {

	@Autowired
	public ProviderServlet providerServlet;
}
