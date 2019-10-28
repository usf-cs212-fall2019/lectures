import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class AdventureServer {

	public static void main(String[] args) throws Exception {
		ServletContextHandler servletContext;

		// TODO

		DefaultHandler defaultHandler;

		// TODO

		ContextHandler defaultContext;

		// TODO

		HandlerList handlers = new HandlerList();

		// TODO

		Server server = new Server(8080);
		server.setHandler(handlers);
		server.start();
		server.join();
	}
}
