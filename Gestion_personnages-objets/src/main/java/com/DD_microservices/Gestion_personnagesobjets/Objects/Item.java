package com.DD_microservices.Gestion_personnagesobjets.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name= "object")
@Entity
public abstract class Item {

    @Id
    private Long id;

    public Item() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
