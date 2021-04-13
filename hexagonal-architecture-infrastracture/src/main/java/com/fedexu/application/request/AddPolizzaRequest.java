package com.fedexu.application.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fedexu.domain.polizza.Polizza;

import javax.validation.constraints.NotNull;

public class AddPolizzaRequest {
    @NotNull private Polizza polizza;

    @JsonCreator
    public AddPolizzaRequest(@JsonProperty("polizza") final Polizza polizza) {
        this.polizza = polizza;
    }

    public Polizza getProduct() {
        return polizza;
    }
}
