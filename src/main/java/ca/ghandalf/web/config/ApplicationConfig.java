package ca.ghandalf.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import ca.ghandalf.web.analytic.ProviderServlet;

@Configuration
@EnableWebMvc
public class ApplicationConfig {

	@Autowired
	public ProviderServlet providerServlet;

//	@Autowired
//	public AnalyticController analyticController;
	
//	@Bean
//	public ServletRegistrationBean<HttpServlet> analyticProviderServlet() {
//		ServletRegistrationBean<HttpServlet> register = new ServletRegistrationBean<>();
//		register.setServlet(analyticProviderServlet);
//		register.addUrlMappings("/analytic/*");
//		register.setLoadOnStartup(1);
//		return register;
//	}
}
