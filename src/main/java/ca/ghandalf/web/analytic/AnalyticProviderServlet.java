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

//@Component
//@WebServlet(name = "analytic", urlPatterns = "/analyticTest", loadOnStartup = 1)
public class AnalyticProviderServlet { //extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(AnalyticProviderServlet.class);
	private static final long serialVersionUID = 1L;

	@Autowired
	private AnalyticProvider provider;

//	@Override
//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//	     doGet(request,response);
//	}
//	
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		logger.info("\n ......... doGet called ...............\n");
//		
//		response.setContentType("application/html;charset=UTF-8");
//		
//		request.setAttribute("analyticProvider", this.provider);
//		request.setAttribute("googleAnalyticId", this.provider.getGoogleAnalyticId());
//		request.setAttribute("googleTagManagementId", this.provider.getGoogleTagManagementId());
//		request.setAttribute("pardotTrackingActiveId", this.provider.getPardotTrackingActiveId());
//		request.setAttribute("pardotTrackingCodeId", this.provider.getPardotTrackingCodeId());
//		
//		logger.info("\n .........request.getAttribut(analyticProvider): {}", request.getAttribute("analyticProvider"));
//		logger.info("\n .........request.getAttribut(googleAnalyticId): {}", request.getAttribute("googleAnalyticId"));
//		logger.info("\n .........request.getAttribut(googleTagManagementId): {}", request.getAttribute("googleTagManagementId"));
//		logger.info("\n .........request.getAttribut(pardotTrackingActiveId): {}", request.getAttribute("pardotTrackingActiveId"));
//		logger.info("\n .........request.getAttribut(pardotTrackingCodeId): {}", request.getAttribute("pardotTrackingCodeId"));
//
//		request.getRequestDispatcher("pages/provider.jsp").forward(request, response);
////		request.getRequestDispatcher("jsp/analytic/provider.jsp").forward(request, response);
////		response.sendRedirect("jsp/analytic/provider.jsp");
//		
////		request.getRequestDispatcher("provider.html").forward(request, response);
////		response.getWriter().println(htmlContent());
//	}
	
	private String htmlContent() {
		return "<div id=\"data\" >"
				+ "<script type=\"text/javascript\">\r\n"
				+ " var googleAnalyticId=" + this.provider.getGoogleAnalyticId()
				+ "        	console.log(\"googleAnalyticId is :: \" + googleAnalyticId);\r\n" + 
				"    	</script>"
				+ "</div>";
	}
	
}
