package com.demo;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")   // replaces <url-pattern>/api/*</url-pattern>
public class MyRestApplication extends ResourceConfig {

    public MyRestApplication() {
        // This replaces <param-value>com.demo</param-value>
        packages("com.demo");
    }
}