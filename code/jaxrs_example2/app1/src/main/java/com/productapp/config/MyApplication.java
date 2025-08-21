package com.productapp.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.productapp.providers.GenericExceptionMapper;
import com.productapp.providers.ProductNotFoundExceptionMapper;

@ApplicationPath("/api")   // replaces <url-pattern>/api/*</url-pattern>
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        // Scan package for REST resources
        packages("com.productapp");
        
        // You can also register providers/filters explicitly
         register(ProductNotFoundExceptionMapper.class,GenericExceptionMapper.class);
        // register(LoggingFilter.class);
    }
}