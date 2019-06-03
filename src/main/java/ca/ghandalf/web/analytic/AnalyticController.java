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
	public String analytic(Model model) {
		logger.info("\t .......... analytic has been called....");
		model.addAttribute("provider", this.provider);
		model.addAttribute("googleAnalyticId", this.provider.getGoogleAnalyticId());
		model.addAttribute("googleTagManagementId", this.provider.getGoogleTagManagementId());
		model.addAttribute("pardotTrackingActiveId", this.provider.getPardotTrackingActiveId());
		model.addAttribute("pardotTrackingCodeId", this.provider.getPardotTrackingCodeId());
		
		logger.info("\t googleAnalyticId: {}", this.provider.getGoogleAnalyticId());
		logger.info("\t googleTagManagementId: {}", this.provider.getGoogleTagManagementId());
		logger.info("\t pardotTrackingActiveId: {}", this.provider.getPardotTrackingActiveId());
		logger.info("\t pardotTrackingCodeId: {}", this.provider.getPardotTrackingCodeId());
		
		// Use to redirect the view, need the path here
		return "view/analytic";
	}

}
