package com.fedexu.domain.ordine;

import com.fedexu.domain.ordine.Ordine;

import java.util.Optional;
import java.util.UUID;

public interface OrdineRepository {
    Optional<Ordine> findById(UUID id);

    boolean save(Ordine ordine);
}
