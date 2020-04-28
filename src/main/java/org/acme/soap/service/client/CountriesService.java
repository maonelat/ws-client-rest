package org.acme.soap.service.client;

import org.acme.soap.domain.Country;
import org.acme.soap.service.client.filter.LogFilter;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;
import java.util.Set;

@Path("/v2")
@RegisterRestClient(configKey = "country-api")
@RegisterProvider(LogFilter.class)
public interface CountriesService {

    @GET
    @Path("/name/{name}")
    @Produces("application/json")
    Set<Country> getByName(@PathParam("name") String name);
}