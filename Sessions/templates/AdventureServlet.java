import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@SuppressWarnings("serial")
public class AdventureServlet extends HttpServlet {

	private static Logger log = Log.getRootLogger();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession(true);

		AdventureRoom room = null;
		Direction direction = null;

		Map<String, String> values = new HashMap<>();

		try {
			// TODO
		}
		catch (Exception e) {
			log.debug(e);
		}

		if (room == null || direction == null) {
			// log.info("Starting new game for session " + session.getId());
			// TODO
		}
		else {
			// TODO
			// log.info("Session " + session.getId() + " moved from " + old + " to " + room.ordinal());
		}

		// TODO

		if (room.done()) {
			// log.info("Game finished for session " + session.getId());
			// TODO
		}
		else {
			// TODO
		}

		// TODO

		// finish up response
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.flushBuffer();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO
	}
}
