package com.code.sales.service.impl;

import com.code.sales.model.Discount;
import com.code.sales.service.ISalesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SalesService implements ISalesService {

    private static final Logger logger = LoggerFactory.getLogger(SalesService.class);

    @Override
    public Discount calculateDiscount(List<Integer> productPrices) {
        Collections.sort(productPrices, Collections.reverseOrder());

        List<Integer> payableItems = new ArrayList<>();
        List<Integer> discountedItems = new ArrayList<>();

        while (productPrices.size() > 1) {
            int maxPrice = productPrices.get(0);
            payableItems.add(maxPrice);
            productPrices.remove(0);

            for (int i = 0; i < productPrices.size(); i++) {
                if (productPrices.get(i) < maxPrice) {
                    discountedItems.add(productPrices.get(i));
                    productPrices.remove(i);
                    break;
                }
            }
        }

        if (!productPrices.isEmpty()) {
            payableItems.add(productPrices.get(0));
        }

        logger.debug("Discount calculation done for given product prices");
        return new Discount(discountedItems, payableItems);
    }
}
