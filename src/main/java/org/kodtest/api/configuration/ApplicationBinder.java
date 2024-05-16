package org.kodtest.api.configuration;

import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.kodtest.api.service.ProductService;

import jakarta.inject.Singleton;

public class ApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(ProductService.class).to(ProductService.class).in(Singleton.class);
    }
}