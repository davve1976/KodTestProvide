package org.kodtest.api.resource;

import static org.junit.Assert.assertEquals;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.kodtest.api.configuration.ApplicationConfig;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;

public class ProductResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        // Configure JerseyTest to use resource class
    	return new ApplicationConfig();
    }

    @Test
    public void testGetAllProducts() {
        // Send a GET request to /api/products/all
        Response response = target("/api/products/all").request().get();

        // Check if the response status is 200 OK
        assertEquals(200, response.getStatus());

    }

}

