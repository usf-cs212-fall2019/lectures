import org.apache.commons.text.StringEscapeUtils;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * Demonstrates how to create, use, and clear cookies. Uses {@link StringEscapeUtils}
 * to sanitize data fetched from cookies.
 *
 * @see CookieBaseServlet
 * @see CookieIndexServlet
 * @see CookieConfigServlet
 */
public class CookieServer {

	/**
	 * Starts a Jetty server configured to use the cookie index and config servlets.
	 *
	 * @param args unused
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Server server = new Server(CookieBaseServlet.PORT);

		ServletHandler handler = new ServletHandler();
		handler.addServletWithMapping(CookieIndexServlet.class, "/");
		handler.addServletWithMapping(CookieConfigServlet.class, "/config");

		server.setHandler(handler);
		server.start();
		server.join();
	}
}
