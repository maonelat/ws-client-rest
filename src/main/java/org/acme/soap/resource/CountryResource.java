package org.acme.soap.resource;

import lombok.extern.slf4j.Slf4j;
import org.acme.soap.domain.Country;
import org.acme.soap.entity.CountryEntity;
import org.acme.soap.entity.ProductEntity;
import org.acme.soap.service.client.CountriesService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/country")
@Slf4j
public class CountryResource {

    @Inject
    @RestClient
    CountriesService countriesService;

//    @PersistenceContext(unitName = "country")
//    EntityManager countryEntityManager;
//
//    @PersistenceContext(unitName = "product")
//    EntityManager productEntityManager;

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Set<Country> name(@PathParam("name") String name) {
        Set<Country> result = countriesService.getByName(name);
        CountryEntity countryEntity = new CountryEntity(); countryEntity.setName("country");
//        countryEntityManager.persist(countryEntity);
        countryEntity.persistAndFlush();
        ProductEntity productEntity = new ProductEntity(); productEntity.setName("product");
//        productEntityManager.persist(productEntity);
        productEntity.persistAndFlush();
        log.info("Country List [{}]",countryEntity.listAll().toString());
        log.info("Product  List [{}]",productEntity.listAll().toString());
        return result;
    }
}