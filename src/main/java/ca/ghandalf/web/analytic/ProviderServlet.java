package ca.ghandalf.web.analytic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@WebServlet(name = "provider", urlPatterns = "/provider", loadOnStartup = 1)
public class ProviderServlet extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(ProviderServlet.class);
	private static final long serialVersionUID = 1L;

	@Autowired
	private AnalyticProvider provider;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		logger.info("\n ......... doPost called ..............."); 
		doGet(request,response);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("......... doGet called ...............\n");
		
		response.setContentType("application/html;charset=UTF-8");
		
		request.setAttribute("analyticProvider", this.provider);
		request.setAttribute("googleAnalyticId", this.provider.getGoogleAnalyticId());
		request.setAttribute("googleTagManagementId", this.provider.getGoogleTagManagementId());
		request.setAttribute("pardotTrackingActiveId", this.provider.getPardotTrackingActiveId());
		request.setAttribute("pardotTrackingCodeId", this.provider.getPardotTrackingCodeId());
		
		logger.info(".........request.getAttribut(analyticProvider): {}", request.getAttribute("analyticProvider"));
		logger.info(".........request.getAttribut(googleAnalyticId): {}", request.getAttribute("googleAnalyticId"));
		logger.info(".........request.getAttribut(googleTagManagementId): {}", request.getAttribute("googleTagManagementId"));
		logger.info(".........request.getAttribut(pardotTrackingActiveId): {}", request.getAttribute("pardotTrackingActiveId"));
		logger.info(".........request.getAttribut(pardotTrackingCodeId): {}\n", request.getAttribute("pardotTrackingCodeId"));

		request.getRequestDispatcher("WEB-INF/view/provider.jsp").forward(request, response);
	}
}
