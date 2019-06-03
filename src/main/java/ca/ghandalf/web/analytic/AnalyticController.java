package ca.ghandalf.web.analytic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class AnalyticController {

	private static final Logger logger = LoggerFactory.getLogger(AnalyticController.class);
	
	@Autowired
	private AnalyticProvider provider;
	
	@RequestMapping("/analytic")
	public String provider(Model model) {
		logger.info("ID:: {}", this.provider.getGoogleAnalyticId());
		model.addAttribute("googleId", this.provider.getGoogleAnalyticId());
		return "analytic";
	}
}
