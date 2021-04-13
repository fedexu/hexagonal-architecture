package com.fedexu.application.rest;

import com.fedexu.application.request.AddPolizzaRequest;
import com.fedexu.application.request.CreateOrdineRequest;
import com.fedexu.application.response.CreateOrderResponse;
import com.fedexu.domain.ordine.Ordine;
import com.fedexu.domain.ordine.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ordini")
public class OrderController {

    private final OrdineService ordineService;

    @Autowired
    public OrderController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    CreateOrderResponse createOrder(@RequestBody final CreateOrdineRequest createOrdineRequest) {
        final UUID id = ordineService.createOrder(createOrdineRequest.getProduct());

        return new CreateOrderResponse(id);
    }

    @PostMapping(value = "/{id}/polizza", consumes = MediaType.APPLICATION_JSON_VALUE)
    void addProduct(@PathVariable final UUID id, @RequestBody final AddPolizzaRequest addPolizzaRequest) {
        ordineService.addProduct(id, addPolizzaRequest.getProduct());
    }

    @DeleteMapping(value = "/{id}/polizza", consumes = MediaType.APPLICATION_JSON_VALUE)
    void deleteProduct(@PathVariable final UUID id, @RequestParam final UUID polizzaId) {
        ordineService.deleteProduct(id, polizzaId);
    }

    @PostMapping("/{id}/complete")
    void completeOrder(@PathVariable final UUID id) {
        ordineService.completeOrder(id);
    }

    @GetMapping
    Ordine findOrder(@RequestParam final UUID id) {
        return ordineService.getOrder(id);
    }
}
