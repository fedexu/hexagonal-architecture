package com.fedexu.domain.ordine;

import com.fedexu.domain.polizza.Polizza;

import java.util.UUID;

public interface OrdineService {
    UUID createOrder(Polizza polizza);

    void addProduct(UUID id, Polizza polizza);

    void completeOrder(UUID id);

    void deleteProduct(UUID id, UUID polizzaId);

    Ordine getOrder(UUID id);
}
