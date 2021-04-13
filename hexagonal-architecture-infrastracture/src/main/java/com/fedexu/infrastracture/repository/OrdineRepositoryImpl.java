package com.fedexu.infrastracture.repository;

import com.fedexu.domain.ordine.Ordine;
import com.fedexu.domain.ordine.OrdineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@Primary
public class OrdineRepositoryImpl implements OrdineRepository {

    Logger logger = LoggerFactory.getLogger(OrdineRepositoryImpl.class);

    @Autowired
    private H2OrdineMapper h2OrdineMapper;

    @Override
    public Optional<Ordine> findById(UUID id) {
        logger.info("Search for order " + id);
        return h2OrdineMapper.findById(id);
    }

    @Override
    public boolean save(Ordine ordine) {
        logger.info("Save order " + ordine.getId());
        ordine.getOrderItems().forEach( ordineItem -> h2OrdineMapper.saveItem(ordineItem.getpolizzaId(), ordineItem.getPrice(), ordine.getId() ));
        h2OrdineMapper.save(ordine.getId(), ordine.getStatus(), ordine.getPrice());
        return true;
    }
}
