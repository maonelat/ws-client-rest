package org.acme.soap.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Country {
    public String name;
    public String alpha2Code;
    public String capital;
    public List<String> topLevelDomain;
    public List<Currency> currencies;
    public String alpha3Code;

    public static class Currency {
        public String code;
        public String name;
        public String symbol;
    }
}
