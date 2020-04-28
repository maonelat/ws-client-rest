package org.acme.soap.service;

import a.b.c.CalculatorPortType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.opentracing.Traced;
import org.tempuri.Product;
import org.tempuri.ResponseResult;
import org.tempuri.SoapApiSoap;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@Traced
@ApplicationScoped
public class ProductService {

    SoapApiSoap api;
    CalculatorPortType calculatorPortType;

    @Inject
    public ProductService(SoapApiSoap soapApiSoap, CalculatorPortType calculatorPortType){
        this.api = soapApiSoap;
        this.calculatorPortType=calculatorPortType;
    }

    public ResponseResult getProduct(int productID){
        log.debug("Finding product with ID : {}",productID);
        ResponseResult res = api.addProduct("Pro", 1.00, "1");
        return res;
    }

    public Integer doCalculation(){
        return calculatorPortType.add(1,1);
    }

    public ResponseResult deleteProduct(int productID) {
        log.debug("Delete product with ID : {}",productID);
        return api.deleteProduct(productID);
    }


    public ResponseResult createProduct(Product product) {
        log.debug("Create product : {}",product);
        return api.addProduct(product.getName(),product.getListPrice().doubleValue(), product.getProductNumber());
    }

    public ResponseResult updateProduct(int productID, Product product) {
        log.debug("Update product with Id : {}, value ={}",productID,product);
        return api.updateProduct(productID,product.getName(),product.getListPrice().doubleValue(), product.getProductNumber());
    }
}
