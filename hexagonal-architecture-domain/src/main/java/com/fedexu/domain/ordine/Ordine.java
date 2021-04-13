package com.fedexu.domain.ordine;

import com.fedexu.domain.polizza.Polizza;

import java.math.BigDecimal;
import java.util.*;

public class Ordine {
    private UUID id;
    private OrdineStatus status;
    private List<OrdineItem> ordineItems;
    private BigDecimal price;

    public Ordine(final UUID id, final Polizza polizza) {
        this.id = id;
        this.ordineItems = new ArrayList<>(Collections.singletonList(new OrdineItem(polizza)));
        this.status = OrdineStatus.CREATED;
        this.price = polizza.getPrice();
    }

    public void complete() {
        validateState();
        this.status = OrdineStatus.COMPLETED;
    }

    public void addOrder(final Polizza polizza) {
        validateState();
        validateProduct(polizza);
        ordineItems.add(new OrdineItem(polizza));
        price = price.add(polizza.getPrice());
    }

    public void removeOrder(final UUID id) {
        validateState();
        final OrdineItem ordineItem = getOrderItem(id);
        ordineItems.remove(ordineItem);

        price = price.subtract(ordineItem.getPrice());
    }

    private OrdineItem getOrderItem(final UUID id) {
        return ordineItems.stream()
            .filter(ordineItem -> ordineItem.getpolizzaId()
                .equals(id))
            .findFirst()
            .orElseThrow(() -> new OrdineException("La polizza id " + id + " non esiste."));
    }

    private void validateState() {
        if (OrdineStatus.COMPLETED.equals(status)) {
            throw new OrdineException("L'ordine é in stato completo.");
        }
    }

    private void validateProduct(final Polizza polizza) {
        if (polizza == null) {
            throw new OrdineException("Il prodotto non puo essere null.");
        }
    }

    public UUID getId() {
        return id;
    }

    public OrdineStatus getStatus() {
        return status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<OrdineItem> getOrderItems() {
        return Collections.unmodifiableList(ordineItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ordineItems, price, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Ordine))
            return false;
        Ordine other = (Ordine) obj;
        return Objects.equals(id, other.id) && Objects.equals(ordineItems, other.ordineItems) && Objects.equals(price, other.price) && status == other.status;
    }

    private Ordine() {
    }
}
