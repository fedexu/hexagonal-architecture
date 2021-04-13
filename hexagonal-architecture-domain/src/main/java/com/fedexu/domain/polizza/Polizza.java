package com.fedexu.domain.polizza;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Polizza {
    private final UUID id;
    private final BigDecimal price;
    private final String name;

    @JsonCreator
    public Polizza(@JsonProperty("id") final UUID id, @JsonProperty("price") final BigDecimal price, @JsonProperty("name") final String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polizza polizza = (Polizza) o;
        return Objects.equals(id, polizza.id) && Objects.equals(price, polizza.price) && Objects.equals(name, polizza.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, name);
    }
}
