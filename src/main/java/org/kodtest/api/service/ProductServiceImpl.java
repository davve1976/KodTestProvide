package org.kodtest.api.service;

import org.kodtest.api.model.Product;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.inject.Named;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ProductServiceImpl implements ProductService {

    @Override
    public Product getProductById(int id) {
    	// to be implemented....get from database
    	Product a = new Product();
        return a;
    }

	@Override
	public List<Product> getAllProducts() {
		// to be implemented....get from database
		return Collections.emptyList();
	}

    public List<Product> getAllProductsTest() {
        try {
            Gson gson = new Gson();
            String jsonString = fetchDataFromURL("https://fakestoreapi.com/products");
            String json = jsonString; // Your JSON string here
            Type productListType = new TypeToken<List<Product>>() {}.getType();
            return gson.fromJson(json, productListType);
        	//return 
		} catch (IOException e) {
			return Collections.emptyList();
		}
    }

    public Product getProductByIdTest(List<Product> products, int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public static String fetchDataFromURL(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            throw new IOException("Failed to fetch data from URL. Response code: " + responseCode);
        }
    }
}
