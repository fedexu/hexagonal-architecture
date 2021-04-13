package com.fedexu.domain.ordine;


import com.fedexu.domain.polizza.Polizza;

import java.util.List;
import java.util.UUID;

public class OrdineServiceImpl implements OrdineService {

    private final OrdineRepository ordineRepository;

    public OrdineServiceImpl(final OrdineRepository ordineRepository) {
        this.ordineRepository = ordineRepository;
    }

    @Override
    public UUID createOrder(final Polizza polizza) {
        final Ordine ordine = new Ordine(UUID.randomUUID(), polizza);
        ordineRepository.save(ordine);

        return ordine.getId();
    }

    @Override
    public void addProduct(final UUID id, final Polizza polizza) {
        final Ordine ordine = getOrder(id);
        ordine.addOrder(polizza);

        ordineRepository.save(ordine);
    }

    @Override
    public void completeOrder(final UUID id) {
        final Ordine ordine = getOrder(id);
        ordine.complete();

        ordineRepository.save(ordine);
    }

    @Override
    public void deleteProduct(final UUID id, final UUID polizzaId) {
        final Ordine ordine = getOrder(id);
        ordine.removeOrder(polizzaId);

        ordineRepository.save(ordine);
    }

    @Override
    public Ordine getOrder(UUID id) {
        return ordineRepository
          .findById(id)
          .orElseThrow(() -> new RuntimeException("L'ordine con questo id non esiste"));
    }
}
