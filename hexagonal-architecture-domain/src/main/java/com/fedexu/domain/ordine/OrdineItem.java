package com.fedexu.domain.ordine;

import com.fedexu.domain.polizza.Polizza;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class OrdineItem {
    private UUID polizzaId;
    private BigDecimal price;

    public OrdineItem(final Polizza polizza) {
        this.polizzaId = polizza.getId();
        this.price = polizza.getPrice();
    }

    public UUID getpolizzaId() {
        return polizzaId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    private OrdineItem() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdineItem ordineItem = (OrdineItem) o;
        return Objects.equals(polizzaId, ordineItem.polizzaId) && Objects.equals(price, ordineItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(polizzaId, price);
    }
}
