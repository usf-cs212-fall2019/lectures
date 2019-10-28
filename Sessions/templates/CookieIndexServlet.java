import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CookieIndexServlet extends CookieBaseServlet {

	public static final String VISIT_DATE = "Visited";
	public static final String VISIT_COUNT = "Count";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.info("GET " + request.getRequestURL().toString());

		if (request.getRequestURI().endsWith("favicon.ico")) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		prepareResponse("Cookies!", response);

		Map<String, Cookie> cookies; // TODO

		Cookie visitDate = null; // TODO
		Cookie visitCount = null; // TODO

		PrintWriter out = response.getWriter();
		out.printf("<p>");

		// Update visit count as necessary and output information.
		if (visitDate == null || visitCount == null) {
			// TODO
		}
		else {
			try {
				// TODO
				// log.info("Encoded: " + visitDate.getValue() + ", Decoded: " + decoded + ", Escaped: " + escaped);
			}
			catch (NullPointerException | IllegalArgumentException e) {
				// TODO
				out.printf("Unable to determine if you have visited this website before. ");
			}
		}

		out.printf("</p>%n");

		// TODO

		finishResponse(request, response);
	}
}
