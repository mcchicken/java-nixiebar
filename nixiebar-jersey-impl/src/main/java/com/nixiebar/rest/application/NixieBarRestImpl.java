package com.nixiebar.rest.application;

import com.nixiebar.rest.impl.AuthenticationHandlerImpl;
import com.nixiebar.rest.impl.CheckinStatsImpl;
import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class NixieBarRestImpl extends Application {

    public NixieBarRestImpl() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("NixieBar");
        beanConfig.setDescription("Retrieve beer stats for display on nixie tubes.");
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/nixiebar-jersey-impl-1.0/rest");
        beanConfig.setResourcePackage("com.nixiebar.rest.impl");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();

        resources.add(AuthenticationHandlerImpl.class);
        resources.add(CheckinStatsImpl.class);

        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }
}
