package ca.ghandalf.web.analytic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AnalyticProvider {

	/**
	 * The default value will be provided for other environment then PROD
	 * In this case the analytic will not be able to call the Analytic Provider 
	 */
	@Value("${google.analytic.id:UA-default-x}")
	private String googleAnalyticId;

	@Value("${google.tag.management.id:TM-default-x}")
	private String googleTagManagementId;

	@Value("${pardot.tracking.active.id:PA-default-x}")
	private String pardotTrackingActiveId;

	@Value("${pardot.tracking.code.id:PC-default-x}")
	private String pardotTrackingCodeId;

	public String getGoogleAnalyticId() {
		return googleAnalyticId;
	}

	public String getGoogleTagManagementId() {
		return googleTagManagementId;
	}

	public String getPardotTrackingActiveId() {
		return pardotTrackingActiveId;
	}

	public String getPardotTrackingCodeId() {
		return pardotTrackingCodeId;
	}

}
