package com.code.sales.controller;

import com.code.sales.model.Discount;
import com.code.sales.service.ISalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Sales Controller, handles requests related to Sales
 *
 * @author hvemuri
 */
@RestController
public class SalesController {

    private static final Logger logger = LoggerFactory.getLogger(SalesController.class);

    @Autowired
    private ISalesService salesService;
    /**
     * Method to Calculate the Discount based on input given
     *
     * @param productPrices
     * @return Discount Object
     */
    @PostMapping("/calculateDiscount")
    public Discount calculateDiscount(@RequestBody List<Integer> productPrices) {

        logger.debug("Received product prices {}" , productPrices);

        if(productPrices == null) {
            throw new NullPointerException("Product prices cannot be null");
        }

        if(productPrices.isEmpty()) {
            throw new IllegalArgumentException("Product prices cannot be Empty");
        }

        return salesService.calculateDiscount(productPrices);
    }
}
