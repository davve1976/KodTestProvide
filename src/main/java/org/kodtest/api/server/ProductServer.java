package org.kodtest.api.server;

import java.util.List;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.kodtest.api.configuration.ApplicationConfig;
import org.kodtest.api.model.Product;
import org.kodtest.api.service.ProductService;
import org.kodtest.api.service.ProductServiceImpl;

public class ProductServer {

	private static final String API_PATH = "/*";

	public static void main(String[] args) {
		setupWebServer();
	}

	private static void testFejkStore() {
		ProductService ps = new ProductServiceImpl();
		List<Product> all = ps.getAllProductsTest();
		Product product = ps.getProductByIdTest(all,1);
		System.out.println(product.toString());
	}

	private static void setupWebServer() {
		System.out.println("Setting up web server at http://localhost:8080");
		Server server = new Server();
		ServerConnector connector = new ServerConnector(server);
		connector.setHost("localhost");
		connector.setPort(8080);
		server.addConnector(connector);

		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
		context.setContextPath("/");
		server.setHandler(context);

		ResourceConfig config = new ApplicationConfig();

		ServletContainer container = new ServletContainer(config);

		ServletHolder servletHolder = new ServletHolder(container);

		context.addServlet(servletHolder, API_PATH);

		try {
			server.start();
			System.out.println("Web server started");
			testFejkStore();
			server.join();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			server.destroy();
		}
	}
}
