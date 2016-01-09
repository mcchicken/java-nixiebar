package com.nixiebar.rest.application;

import com.nixiebar.rest.impl.AuthenticationHandlerImpl;
import com.nixiebar.rest.impl.CheckinStatsImpl;
import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@Path("/rest")
public class NixieBarRestImpl extends Application {

    public NixieBarRestImpl() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8002");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("io.swagger.resources");
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
