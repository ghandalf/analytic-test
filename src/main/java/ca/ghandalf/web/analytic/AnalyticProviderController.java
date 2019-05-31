package ca.ghandalf.web.analytic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

@WebServlet(name = "analytic", urlPatterns = {"/analytic/provider"})
public class AnalyticProviderController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private AnalyticProvider provider;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/html;charset=UTF-8");
		request.setAttribute("analyticProvider", this.provider);
		request.setAttribute("googleAnalyticId", this.provider.getGoogleAnalyticId());
		request.setAttribute("googleTagManagementId", this.provider.getGoogleTagManagementId());
		
		
		request.getRequestDispatcher("WEB-INF/jsp/analytic/provider.jsp").forward(request, response);
	}
	
	
}
