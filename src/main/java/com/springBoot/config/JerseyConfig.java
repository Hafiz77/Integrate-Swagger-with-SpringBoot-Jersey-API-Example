package com.springBoot.config;


import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Hafiz on 8/25/2016.
 */


@Component
public class JerseyConfig extends ResourceConfig {
    @Value("${spring.jersey.application-path:/}")
    private String apiPath;

    public JerseyConfig() {
        // Register endpoints, providers, ...
        this.registerEndpoints();
    }

    @PostConstruct
    public void init() {
        // Register components where DI is needed
        this.configureSwaggerV1();

    }

    private void registerEndpoints() {
        //this.register(HelloResource.class);
        //this.register(UserResource.class);

        this.register(com.springBoot.rest.v1.UserResourceV1.class);
        this.register(com.springBoot.rest.v2.UserResourceV2.class);

        // Access through /<Jersey's servlet path>/application.wadl
       // this.register(WadlResource.class);
    }

    private void configureSwaggerV1() {
        // Available at localhost:port/swagger.json
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        BeanConfig config = new BeanConfig();
        config.setConfigId("springBoot-jersey-swagger-example version-1 & version-2");
        config.setTitle("Spring Boot + Jersey + Swagger Example version-1 & version-2 ");
        config.setVersion("v1");
        config.setContact("Abdullah Al Hafiz");
        config.setSchemes(new String[]{"http", "https"});
        config.setBasePath(this.apiPath);
        config.setResourcePackage("com.springBoot.rest");
        config.setPrettyPrint(true);
        config.setScan(true);


    }
}
