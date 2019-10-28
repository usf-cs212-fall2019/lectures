import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.text.StringSubstitutor;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/**
 * Demonstrates how to use session tracking and enum types to create a simple
 * adventure game.
 *
 * @see AdventureServer
 * @see AdventureServlet
 * @see AdventureRoom
 * @see Direction
 */
public class AdventureServlet extends HttpServlet {

	/** Identifier for serialization (unused). */
	private static final long serialVersionUID = 1L;

	/** The Jetty logger for this servlet (not log4j2) */
	private static Logger log = Log.getRootLogger();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession(true);

		// tracks current game state
		AdventureRoom room = null;
		Direction direction = null;

		// replacement values for template
		Map<String, String> values = new HashMap<>();

		// try to get current game state
		try {
			room = (AdventureRoom) session.getAttribute("room");
			direction = Direction.valueOf(request.getParameter("direction"));
		}
		catch (Exception e) {
			log.debug(e);
		}

		// make sure values are valid
		if (room == null || direction == null) {
			log.info("Starting new game for session " + session.getId());
			room = AdventureRoom.START_ROOM;
			direction = Direction.EAST;
		}
		else {
			int old = room.ordinal();
			room = room.moveRoom(direction);
			log.info("Session " + session.getId() + " moved from " + old + " to " + room.ordinal());
		}

		// add room information to template values
		values.put("room", Integer.toString(room.ordinal()));
		values.put("message", room.toString());
		values.put("direction", direction.name());

		// save the updated room value in the session
		session.setAttribute("room", room);

		if (room.done()) {
			// game won or lost
			log.info("Game finished for session " + session.getId());
			session.setAttribute("room", AdventureRoom.START_ROOM);
			session.invalidate();

			// make all of the direction buttons disabled
			values.put("west",  "disabled");
			values.put("east",  "disabled");
			values.put("north", "disabled");
			values.put("south", "disabled");
		}
		else {
			// calculate which buttons to disable
			values.put("west",  room.canMove(Direction.WEST)  ? "" : "disabled");
			values.put("east",  room.canMove(Direction.EAST)  ? "" : "disabled");
			values.put("north", room.canMove(Direction.NORTH) ? "" : "disabled");
			values.put("south", room.canMove(Direction.SOUTH) ? "" : "disabled");
		}

		// setup template using commons-text
		Path path = Path.of("templates", "main.html");
		String template = Files.readString(path, StandardCharsets.UTF_8);

		// add remaining values
		values.put("action", response.encodeURL("/"));
		values.put("session", session.getId());

		// generate html from template
		StringSubstitutor replacer = new StringSubstitutor(values);
		String html = replacer.replace(template);

		// write resulting html to response
		writer.write(html);

		// finish up response
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.flushBuffer();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
