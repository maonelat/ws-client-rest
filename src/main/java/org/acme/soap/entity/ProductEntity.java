package org.acme.soap.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.*;

import javax.persistence.Entity;

@Data
@Entity
public class ProductEntity extends PanacheEntity {
    public String name;
    public String alpha2Code;
    public String capital;
}
