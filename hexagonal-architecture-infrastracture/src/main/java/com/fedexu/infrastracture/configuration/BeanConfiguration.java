package com.fedexu.infrastracture.configuration;

import com.fedexu.Application;
import com.fedexu.domain.ordine.OrdineRepository;
import com.fedexu.domain.ordine.OrdineServiceImpl;
import com.fedexu.domain.ordine.OrdineService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Application.class)
public class BeanConfiguration {

    @Bean
    OrdineService orderService(final OrdineRepository ordineRepository) {
        return new OrdineServiceImpl(ordineRepository);
    }

}
