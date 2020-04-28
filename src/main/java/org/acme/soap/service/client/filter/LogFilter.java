package org.acme.soap.service.client.filter;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.net.URI;

@Slf4j
public class LogFilter implements ClientRequestFilter, ClientResponseFilter {

    @Override
    public void filter(ClientRequestContext reqContext) throws IOException {
        System.out.println("-- Client request info --");
        reqContext.getHeaders().add("LOY", "BIZ ONE");
        log(reqContext.getUri(), reqContext.getHeaders());
    }

    @Override
    public void filter(ClientRequestContext reqContext, ClientResponseContext resContext) throws IOException {
        System.out.println(resContext.getStatusInfo().toEnum()+"-- Client response info --");
        log(reqContext.getUri(), resContext.getHeaders());
    }

    private void log(URI uri, MultivaluedMap<String, ?> headers) {
        log.debug("Request URI: " + uri.getPath());
        log.debug("Headers:");
        headers.entrySet().forEach(h -> System.out.println(h.getKey() + ": " + h.getValue()));
    }
}
