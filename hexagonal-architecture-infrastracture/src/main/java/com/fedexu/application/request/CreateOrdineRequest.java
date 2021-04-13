package com.fedexu.application.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedexu.domain.polizza.Polizza;

import javax.validation.constraints.NotNull;

public class CreateOrdineRequest {
    @NotNull private Polizza polizza;

    @JsonCreator
    public CreateOrdineRequest(@JsonProperty("polizza") @NotNull final Polizza polizza) {
        this.polizza = polizza;
    }

    public Polizza getProduct() {
        return polizza;
    }
}
