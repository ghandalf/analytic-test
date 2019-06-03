package ca.ghandalf.web.analytic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnalyticController {

	private static final Logger logger = LoggerFactory.getLogger(AnalyticController.class);
	
	@Autowired
	private AnalyticProvider provider;
	
	@RequestMapping("/")
	public String welcome(Model model) {
		logger.info("\t......welcome has been called....");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("now", df.format(new Date()));
		model.addAttribute("googleAnalyticId", this.provider.getGoogleAnalyticId());
		model.addAttribute("googleTagManagementId", this.provider.getGoogleTagManagementId());
		return "index";
	}

	@RequestMapping("/analytic")
	public String provider(Model model) {
		logger.info("\t .......... provider has been called....");
		model.addAttribute("provider", this.provider);
		model.addAttribute("googleAnalyticId", this.provider.getGoogleAnalyticId());
		model.addAttribute("googleTagManagementId", this.provider.getGoogleTagManagementId());
		// Use to redirect the view, need the path here
		return "view/provider";
	}

}
