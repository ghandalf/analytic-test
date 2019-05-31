package ca.ghandalf.web.analytic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AnalyticProviderData {

	@Autowired
	private AnalyticProvider provider;
	
	public String getAnalytidId() {
		return this.provider.getGoogleAnalyticId();
	}
}
