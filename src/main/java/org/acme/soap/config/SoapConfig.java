package org.acme.soap.config;

import a.b.c.Calculator;
import a.b.c.CalculatorPortType;
import org.tempuri.SoapApi;
import org.tempuri.SoapApiSoap;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class SoapConfig {

    @Produces
    public SoapApiSoap getWSPort(){
        return new SoapApi().getSoapApiSoap();
    }

    @Produces
    public CalculatorPortType getCalculatorPortType(){
        return new Calculator().getCalculatorHttpSoap11Endpoint();
    }
}
